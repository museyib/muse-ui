package com.museui;

import static com.museui.Color.*;

public class Button extends BaseComponent {
    private String text;
    private boolean hovered;
    private boolean pressed;


    public Button(String text) {
        this.text = text;
        background = GRAY;
        setSize(100, 30);
    }

    @Override
    public void render(GraphicsContext g) {
        if (!visible) return;
        Color bg = background;
        if (pressed) {
            bg = BUTTON_PRESS;
        }
        else if (hovered) {
            bg = BUTTON_HOVER;
        }
        g.fillRect(x, y, width, height, bg);
        g.drawRect(x, y, width, height, foreground);

        int textX = x+ (width - text.length() * (Font.CHAR_WIDTH + 1)) / 2;
        int textY = y + (height - Font.CHAR_HEIGHT) / 2;
        g.drawString(text, textX, textY, foreground);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHovered() {
        return hovered;
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
}
