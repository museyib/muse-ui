package com.museui.component;

import com.museui.toolkit.Color;
import com.museui.toolkit.Font;
import com.museui.toolkit.GraphicsContext;

import static com.museui.toolkit.Color.*;

@SuppressWarnings("unused")
public class Button extends BaseComponent {
    private String text;


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

        int textX = x + (width - text.length() * (Font.CHAR_WIDTH + 1)) / 2;
        int textY = y + (height - Font.CHAR_HEIGHT) / 2;
        g.drawString(text, textX, textY, foreground);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
