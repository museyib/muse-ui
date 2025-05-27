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
        for (int i = x; i < h; i++) {
            for (int j = y; j < w; j++) {
                if (i >= 0 && i < width && j >= 0 && j < height)
                    buffer[y * width + j] = color.getRGB();
            }
        }
    }
}
