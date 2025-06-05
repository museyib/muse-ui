package com.museui;

public class GraphicsContext {
    private final int width;
    private final int height;
    private final int[] buffer;

    public GraphicsContext(int[] buffer, int width, int height) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
    }

    public void drawPixel(int x, int y, Color color) {
        buffer[y * width + x] = color.getRGB();
    }

    public void fillRect(int x, int y, int w, int h, Color color) {
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + h; j++) {
                if (i >= 0 && i < width && j >= 0 && j < height) {
                    buffer[j * width + i] = color.getRGB();
                }
            }
        }
    }

    public void drawRect(int x, int y, int width, int height, Color color) {
        for (int i = x; i < x + width; i++) {
            drawPixel(i, y, color);
        }

        for (int i = x; i < x + width; i++) {
            drawPixel(i, y + height - 1, color);
        }

        for (int j = y; j < y + height; j++) {
            drawPixel(x, j, color);
        }

        for (int j = y; j < y + height; j++) {
            drawPixel(x + width - 1, j, color);
        }
    }

    public void drawChar(char c, int x, int y, Color color) {
        byte[] bitmap = Font.getCharBitmap(c);
        for (int j = 0; j < bitmap.length; j++) {
           for (int i = 0; i < Font.CHAR_WIDTH; i++) {
               if ((bitmap[j] & (1 << (Font.CHAR_WIDTH - 1 - i))) != 0) {
                   drawPixel(x + i, y + j, color);
               }
           }
        }
    }

    public void drawString(String text, int x, int y, Color color) {
        int cursorx = x;
        for (char c : text.toCharArray()) {
            drawChar(c, cursorx, y, color);
            cursorx += Font.CHAR_WIDTH + 1;
        }
    }
}
