package com.museui.listener;

import com.museui.event.MouseEvent;
import com.museui.event.MouseMoveEvent;

public interface MouseListener extends EventListener {
    void mouseMoved(MouseMoveEvent e);
    void mouseDown(MouseEvent e);
    void mouseUp(MouseEvent e);
}
