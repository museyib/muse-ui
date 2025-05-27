package com.museui.event;

import lombok.Data;

@Data
public abstract class MouseEvent {
    protected int x;
    protected int y;

    public MouseEvent(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}
