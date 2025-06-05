package com.museui;

import com.museui.listener.ClickListener;
import com.museui.listener.EventListener;
import com.museui.listener.KeyListener;
import com.museui.listener.MouseMoveListener;

public interface Component {
    void setClickListener(ClickListener clickListener);
    void setMouseMoveListener(MouseMoveListener mouseMoveListener);
    void setKeyListener(KeyListener keyListener);
    void removeListener(Class<? extends EventListener> type);
    void render(GraphicsContext g);
    void setBounds(int x, int y, int width, int height);
    void setSize(int w, int h);
}
