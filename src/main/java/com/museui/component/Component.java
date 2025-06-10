package com.museui.component;

import com.museui.listener.ClickListener;
import com.museui.listener.EventListener;
import com.museui.listener.KeyListener;
import com.museui.listener.MouseListener;
import com.museui.toolkit.GraphicsContext;

@SuppressWarnings("unused")
public interface Component {
    void setClickListener(ClickListener clickListener);
    void setMouseListener(MouseListener mouseListener);
    void setKeyListener(KeyListener keyListener);
    void removeListener(Class<? extends EventListener> type);
    void render(GraphicsContext g);
    void setBounds(int x, int y, int width, int height);
    void setSize(int w, int h);
}
