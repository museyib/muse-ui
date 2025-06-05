package com.museui.nativebase;

import com.museui.BaseComponent;
import com.museui.Button;
import com.museui.Component;
import com.museui.GraphicsContext;
import com.museui.event.ClickEvent;

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

    private void onMouseClick(int x, int y) {
        if (clickListener != null)
            clickListener.clicked(new ClickEvent(x, y, 0));
    }

    private void onMouseMove(int x, int y) {
        for (Component component : components) {
            if (component instanceof Button button) {
                boolean hovered = x >= button.getX() && x < button.getX() + button.getWidth()
                        && y >= button.getY() && y < button.getY() + button.getHeight();
                button.setHovered(hovered);
            }
        }
        render(graphics);
        repaint();
    }

    private void onMouseDown(int x, int y) {
        for (Component component : components) {
            if (component instanceof Button button) {
                boolean pressed = x >= button.getX() && x < button.getX() + button.getWidth()
                        && y >= button.getY() && y < button.getY() + button.getHeight();
                button.setPressed(pressed);
            }
        }
        render(graphics);
        repaint();
    }

    private void onMouseUp(int x, int y) {
        for (Component component : components) {
            if (component instanceof Button button) {
                button.setPressed(false);
                if (button.getClickListener() != null && button.isHovered())
                    button.getClickListener().clicked(new ClickEvent(x, y, 0));
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
