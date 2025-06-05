package com.museui;

import com.museui.listener.ClickListener;
import com.museui.listener.EventListener;
import com.museui.listener.KeyListener;
import com.museui.listener.MouseMoveListener;

import java.util.ArrayList;
import java.util.List;

public class BaseComponent implements Component {

    protected int x, y, width, height;

    protected boolean visible = true;

    protected Color background = Color.LIGHT_GRAY;

    protected Color foreground = Color.BLACK;

    protected final List<EventListener> listeners = new ArrayList<>();
    protected ClickListener clickListener;
    protected MouseMoveListener mouseMoveListener;
    protected KeyListener keyListener;

    public BaseComponent() {
        width = 800;
        height = 600;
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void setSize(int w, int h) {
        width = w;
        height = h;
    }

    @Override
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
        listeners.removeIf(listener -> listener instanceof ClickListener);
        listeners.add(clickListener);
    }

    public void setMouseMoveListener(MouseMoveListener mouseMoveListener) {
        this.mouseMoveListener = mouseMoveListener;
        listeners.removeIf(listener -> listener instanceof MouseMoveListener);
        listeners.add(mouseMoveListener);
    }

    @Override
    public void setKeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
        listeners.removeIf(listener -> listener instanceof KeyListener);
        listeners.add(keyListener);
    }

    @Override
    public void removeListener(Class<? extends EventListener> type) {
        listeners.removeIf(type::isInstance);
    }

    @Override
    public void render(GraphicsContext g) {
        if (!visible) return;
        g.fillRect(x, y, width, height, background);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Color getForeground() {
        return foreground;
    }

    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    public List<EventListener> getListeners() {
        return listeners;
    }

    public ClickListener getClickListener() {
        return clickListener;
    }

    public KeyListener getKeyListener() {
        return keyListener;
    }

    public MouseMoveListener getMouseMoveListener() {
        return mouseMoveListener;
    }
}
