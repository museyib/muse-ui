package com.museui.component;

import com.museui.event.ClickEvent;
import com.museui.event.MouseEvent;
import com.museui.event.MouseMoveEvent;
import com.museui.listener.ClickListener;
import com.museui.listener.EventListener;
import com.museui.listener.KeyListener;
import com.museui.listener.MouseListener;
import com.museui.toolkit.Color;
import com.museui.toolkit.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class BaseComponent implements Component {

    protected boolean hovered;
    protected boolean pressed;

    protected int x, y, width, height;

    protected boolean visible = true;

    protected Color background = Color.LIGHT_GRAY;

    protected Color foreground = Color.BLACK;

    protected final List<EventListener> listeners = new ArrayList<>();
    protected ClickListener clickListener;
    protected MouseListener mouseListener;
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

    public void setMouseListener(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
        listeners.removeIf(listener -> listener instanceof MouseListener);
        listeners.add(mouseListener);
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

    private boolean isInsideBounds(int x, int y) {
        return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
    }

    protected void onMouseClick(int x,  int y) {
        if (isInsideBounds(x, y)) {
            setPressed(true);
            if (clickListener != null) {
                clickListener.clicked(new ClickEvent(x, y, 0));
            }
        } else {
            setPressed(false);
        }
    }

    protected void onMouseMove(int x, int y) {
        if (isInsideBounds(x, y)) {
            setHovered(true);
            if (mouseListener != null ) {
                mouseListener.mouseMoved(new MouseMoveEvent(x, y));
            }
        } else {
            setHovered(false);
            setPressed(false);
        }
    }

    protected void onMouseDown(int x, int y) {
        if (isInsideBounds(x, y)) {
            setPressed(true);
            if (mouseListener != null) {
                mouseListener.mouseDown(new MouseEvent(x, y));
            }
        }
    }

    protected void onMouseUp(int x, int y) {
        if (isInsideBounds(x, y)) {
            if (mouseListener != null) {
                mouseListener.mouseUp(new MouseEvent(x, y));
            }
        }
        setPressed(false);
    }

    public void handleMouseClick(int x, int y) {
        onMouseClick(x, y);
    }

    public void handleMouseMove(int x, int y) {
        onMouseMove(x, y);
    }

    public void handleMouseDown(int x, int y) {
        onMouseDown(x, y);
    }

    public void handleMouseUp(int x, int y) {
        onMouseUp(x, y);
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

    public boolean isHovered() {
        return hovered;
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
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

    public MouseListener getMouseMoveListener() {
        return mouseListener;
    }
}
