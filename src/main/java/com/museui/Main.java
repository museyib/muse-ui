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
        Button button = new Button("Button");
        button.setBounds(100, 100, 500, 100);
        button.setClickListener((event) -> {
            System.out.println("Clicked on button: " + event);
        });
        window.addComponent(button);
        window.show();
    }
}