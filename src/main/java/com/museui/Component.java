package com.museui;

import com.museui.listener.ClickListener;
import com.museui.listener.EventListener;
import com.museui.listener.KeyListener;

public interface Component {
    void setClickListener(ClickListener clickListener);
    void setKeyListener(KeyListener keyListener);
    void removeListener(Class<? extends EventListener> type);
    void render(GraphicsContext g);
}
