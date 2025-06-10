package com.museui.event;

@SuppressWarnings("unused")
public class ClickEvent extends MouseEvent {
    private final int button;

    public ClickEvent(int x, int y, int button) {
        super(x, y);
        this.button = button;
    }

    public int getButton() {
        return button;
    }
}
