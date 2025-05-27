package com.museui;

import com.museui.listener.ClickListener;
import com.museui.listener.EventListener;
import com.museui.listener.KeyListener;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class BaseComponent implements Component {

    protected int x, y, width, height;

    @Getter
    @Setter
    protected Color background = Color.LIGHT_GRAY;

    @Getter
    @Setter
    protected Color foreground = Color.BLACK;

    @Getter
    protected final List<EventListener> listeners = new ArrayList<>();
    protected ClickListener clickListener;
    protected KeyListener keyListener;

    protected final int[] buffer;

    @Getter
    protected GraphicsContext graphics;

    public BaseComponent() {
        width = 800;
        height = 600;
        buffer = new int[width * height];
        graphics = new GraphicsContext(buffer, width, height);
    }

    public void setBounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setSize(int w, int h) {
        width = w;
        height = h;
    }

    protected void fillBackground() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                buffer[y * width + x] = background.getRGB();
            }
        }
    }

    @Override
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
        listeners.removeIf(listener -> listener instanceof ClickListener);
        listeners.add(clickListener);
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
        g.fillRect(0, 0, width, height, background);
    }
}
