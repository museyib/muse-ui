package com.museui.event;

import lombok.Getter;

@Getter
public class MouseMoveEvent extends MouseEvent {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public MouseMoveEvent(int x, int y, int startX, int startY, int endX, int endY) {
        super(x, y);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
