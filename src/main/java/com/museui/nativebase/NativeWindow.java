package com.museui.nativebase;

import com.museui.BaseComponent;
import com.museui.event.ClickEvent;
import lombok.Setter;

public class NativeWindow extends BaseComponent {
    static {
        System.loadLibrary("NativeWin");
    }

    private native long createWindow(int w, int h, String title);
    private native void messageLoop();
    private native void blitFrameBuffer(long hWnd, int[] pixels, int w, int h);
    private native void registerInstance();

    @Setter
    private String title;
    private long hWnd;

    public NativeWindow() {
        super();
        title = "Native Window";
        fillBackground();
        repaint();
    }

    public NativeWindow(String title) {
        this();
        this.title = title;
    }

    public void repaint() {
        blitFrameBuffer(hWnd, buffer, width, height);
    }

    public void show() {
        registerInstance();
        hWnd = createWindow(width, height, title);
        render(graphics);
        repaint();
        messageLoop();

    }

    private void onMouseClick(int x, int y) {
        if (clickListener != null)
            clickListener.clicked(new ClickEvent(x, y, 0));
        repaint();
    }
}
