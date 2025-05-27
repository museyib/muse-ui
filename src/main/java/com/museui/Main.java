package com.museui;

import com.museui.nativebase.NativeWindow;

public class Main {
    public static void main(String[] args) {
        NativeWindow window = new NativeWindow("Hello World");
        int width = 800;
        int height = 600;
        window.setSize(width, height);
        window.setClickListener((event) -> {
            System.out.println("Clicked: " + event);
        });
        window.show();
    }
}