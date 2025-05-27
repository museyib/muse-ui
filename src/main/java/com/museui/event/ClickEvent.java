package com.museui.event;


import lombok.Getter;

@Getter
public class ClickEvent extends MouseEvent {
    private final int button;

    public ClickEvent(int x, int y, int button) {
        super(x, y);
        this.button = button;
    }
}
