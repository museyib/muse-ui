#include <windows.h>
#include <stdint.h>
#include "com_museui_nativebase_NativeWindow.h"

static const wchar_t *CLASS_NAME = L"JNI_Window_Class";
static JavaVM* g_vm  = NULL;
static jclass g_nativeWindowClass = NULL;
static jobject g_windowInstance = NULL;
static jmethodID g_onClickMethod = NULL;

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {
    g_vm = vm;

    JNIEnv* env;
    if((*vm)->GetEnv(vm, (void**)&env, JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    jclass cls = (*env)->FindClass(env, "com/museui/nativebase/NativeWindow");
    if (cls == NULL) return JNI_ERR;

    g_nativeWindowClass = (*env)->NewGlobalRef(env, cls);

    return JNI_VERSION_1_6;
}

/* Basic window procedure */
LRESULT CALLBACK WndProc(HWND hWnd, UINT uMsg, WPARAM wParam, LPARAM lParam) {
    switch (uMsg) {
        case WM_DESTROY:
            PostQuitMessage(0);
            return 0;
        case WM_NCHITTEST:{
            LRESULT hit = DefWindowProc(hWnd, uMsg, wParam, lParam);
            if (hit != HTCLIENT)
                    return hit;

            // Get cursor position in window coordinates
            POINT pt = {
                .x = GET_SC_WPARAM(lParam),
                .y = GET_SC_WPARAM(lParam)
            };
            ScreenToClient(hWnd, &pt);

            const int border = 0;
            RECT winRect;
            GetClientRect(hWnd, &winRect);

            if (pt.y >= winRect.top && pt.y < winRect.top + border) {
                if (pt.x >= winRect.left && pt.x < winRect.left + border) return HTTOPLEFT;
                if (pt.x < winRect.right && pt.x >= winRect.right - border) return HTTOPRIGHT;
                return HTTOP;
            } else if (pt.y < winRect.bottom && pt.y >= winRect.bottom - border) {
                if (pt.x >= winRect.left && pt.x < winRect.left + border) return HTBOTTOMLEFT;
                if (pt.x < winRect.right && pt.x >= winRect.right - border) return HTBOTTOMRIGHT;
                return HTBOTTOM;
            } else if (pt.x >= winRect.left && pt.x < winRect.left + border) {
                return HTLEFT;
            } else if (pt.x < winRect.right && pt.x >= winRect.right - border) {
                return HTRIGHT;
            } else {
                return HTCLIENT;
            }

            return HTCLIENT;
        }
        case WM_SETCURSOR:
             if (LOWORD(lParam) == HTCLIENT) {
                 SetCursor(LoadCursor(NULL, IDC_ARROW));
                 return TRUE;
             }
             break;
        case WM_LBUTTONDOWN: {
            int x = LOWORD(lParam);
            int y = HIWORD(lParam);

            JNIEnv* env;
            if ((*g_vm)->AttachCurrentThread(g_vm, (void**)&env, NULL) == 0) {
                if (g_windowInstance && g_onClickMethod) {
                    (*env)->CallVoidMethod(env, g_windowInstance, g_onClickMethod, x, y);
                }
            }

            return 0;
        }

    }
    return DefWindowProc(hWnd, uMsg, wParam, lParam);
}

/* Helper to register class once */
static void ensure_class_registered() {
    static BOOL registered = FALSE;
    if (registered) return;

    WNDCLASSW wc = {0};
    wc.lpfnWndProc = WndProc;
    wc.hInstance   = GetModuleHandle(NULL);
    wc.lpszClassName = CLASS_NAME;
    RegisterClassW(&wc);
    registered = TRUE;
}

/* JNI: createWindow */
JNIEXPORT jlong JNICALL Java_com_museui_nativebase_NativeWindow_createWindow(JNIEnv *env, jclass cls,
                                    jint width, jint height, jstring jtitle) {
    ensure_class_registered();

    const char* utf8Title = (*env)->GetStringUTFChars(env, jtitle, NULL);

   int wlen = MultiByteToWideChar(CP_UTF8, 0, utf8Title, -1, NULL, 0);
   wchar_t* title = (wchar_t*)malloc(wlen * sizeof(wchar_t));
   MultiByteToWideChar(CP_UTF8, 0, utf8Title, -1, title, wlen);

    HWND hwnd = CreateWindowExW(
        0, CLASS_NAME, title,
        WS_OVERLAPPEDWINDOW,
        CW_USEDEFAULT, CW_USEDEFAULT, width, height,
        NULL, NULL, GetModuleHandle(NULL), NULL);

    (*env)->ReleaseStringUTFChars(env, jtitle, utf8Title);
    ShowWindow(hwnd, SW_SHOW);
    free(title);
    return (jlong)(intptr_t)hwnd;
}

/* JNI: setPixel */
JNIEXPORT void JNICALL Java_com_museui_nativebase_NativeWindow_setPixel(JNIEnv *env, jclass cls,
                                jlong hwndLong, jint x, jint y, jint argb) {
    HWND hWnd = (HWND)(intptr_t)hwndLong;
    HDC  hdc  = GetDC(hWnd);

    COLORREF color = ((argb & 0xFF) << 16) | (argb & 0xFF00) | ((argb >> 16) & 0xFF);
    SetPixel(hdc, x, y, color);

    ReleaseDC(hWnd, hdc);
}

/* JNI: messageLoop */
JNIEXPORT void JNICALL Java_com_museui_nativebase_NativeWindow_messageLoop(JNIEnv *env, jclass cls) {
    MSG msg;
    while (GetMessage(&msg, NULL, 0, 0)) {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }
}

JNIEXPORT void JNICALL Java_com_museui_nativebase_NativeWindow_blitFrameBuffer(JNIEnv* env, jclass cls, jlong hwndLong, jintArray pixelArray, jint width, jint height)  {
    HWND hWnd = (HWND)(intptr_t)hwndLong;
    HDC hdc = GetDC(hWnd);

    jint* pixels = (*env)->GetIntArrayElements(env, pixelArray, NULL);

    BITMAPINFO bmi = {0};
    bmi.bmiHeader.biSize = sizeof(BITMAPINFOHEADER);
    bmi.bmiHeader.biWidth = width;
    bmi.bmiHeader.biHeight = -height; // top-down image
    bmi.bmiHeader.biPlanes = 1;
    bmi.bmiHeader.biBitCount = 32;
    bmi.bmiHeader.biCompression = BI_RGB;

    StretchDIBits(hdc,
        0, 0, width, height,
        0, 0, width, height,
        pixels, &bmi, DIB_RGB_COLORS, SRCCOPY);

    (*env)->ReleaseIntArrayElements(env, pixelArray, pixels, 0);
    ReleaseDC(hWnd, hdc);
}

JNIEXPORT void JNICALL Java_com_museui_nativebase_NativeWindow_registerInstance(JNIEnv* env, jobject thisObj) {
    if(g_windowInstance) {
        (*env)->DeleteGlobalRef(env, g_windowInstance);
        g_windowInstance = NULL;
    }

    g_windowInstance = (*env)->NewGlobalRef(env, thisObj);
    jclass cls = (*env)->GetObjectClass(env, g_windowInstance);
    g_onClickMethod = (*env)->GetMethodID(env, cls, "onMouseClick", "(II)V");

    if(g_onClickMethod == NULL) {
        MessageBoxA(NULL, "Failed to find onMouseClick(int, int)", "Error", MB_OK);
    }
}