package com.museui.event;

import lombok.Data;

@Data
public class KeyEvent {
    private int keyCode;
    public KeyEvent(int keyCode) {
        this.keyCode = keyCode;
    }
}
