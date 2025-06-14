package com.museui.toolkit;

@SuppressWarnings("unused")
public class Color {
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color LIGHT_GRAY = new Color(192, 192, 192);
    public static final Color GRAY = new Color(160, 160, 160);
    public static final Color BUTTON_HOVER = new Color(150, 150, 150);
    public static final Color BUTTON_PRESS = new Color(130, 130, 130);
    public static final Color DARK_GRAY = new Color(128, 128, 128);


    private final int red;
    private final int green;
    private final int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRGB() {
        return red << 16 | green << 8 | blue;
    }

    @Override
    public String toString() {
        return "Color{" + "red=" + red + ", green=" + green + ", blue=" + blue + '}';
    }
}
