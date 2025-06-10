package com.museui.component;

import com.museui.toolkit.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class NativeWindow extends BaseComponent {
    static {
        System.loadLibrary("NativeWin");
    }

    private native long createWindow(int w, int h, String title);
    private native void messageLoop();
    private native void blitFrameBuffer(long hWnd, int[] pixels, int w, int h);
    private native void registerInstance();


    protected final int[] buffer;
    protected GraphicsContext graphics;

    private final List<Component> components = new ArrayList<>();

    private String title;
    private long hWnd;

    public NativeWindow() {
        super();
        buffer = new int[width * height];
        graphics = new GraphicsContext(buffer, width, height);
        title = "Native Window";
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

    protected void onMouseClick(int x, int y) {
        super.onMouseClick(x, y);
        for (Component component : components) {
            if (component instanceof BaseComponent baseComponent) {
                baseComponent.handleMouseClick(x, y);
            }
        }
        render(graphics);
        repaint();
    }

    protected void onMouseMove(int x, int y) {
        super.onMouseMove(x, y);
        for (Component component : components) {
            if (component instanceof BaseComponent baseComponent) {
                baseComponent.handleMouseMove(x, y);
            }
        }
        render(graphics);
        repaint();
    }

    protected void onMouseDown(int x, int y) {
        super.onMouseDown(x, y);
        for (Component component : components) {
            if (component instanceof BaseComponent baseComponent) {
                baseComponent.handleMouseDown(x, y);
            }
        }
        render(graphics);
        repaint();
    }

    protected void onMouseUp(int x, int y) {
        super.onMouseUp(x, y);
        for (Component component : components) {
            if (component instanceof BaseComponent baseComponent) {
                baseComponent.handleMouseUp(x, y);
            }
        }
        render(graphics);
        repaint();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void render(GraphicsContext g) {
        super.render(g);
        for (Component component : components) {
            component.render(g);
        }
        repaint();
    }
}
