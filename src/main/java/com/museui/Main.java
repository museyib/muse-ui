package com.museui;

import com.museui.component.Button;
import com.museui.component.NativeWindow;
import com.museui.event.MouseEvent;
import com.museui.listener.MouseAdapter;

public class Main {
    public static void main(String[] args) {
        NativeWindow window = new NativeWindow("Hello World");
        int width = 800;
        int height = 600;
        window.setSize(width, height);
        Button button = new Button("Button");
        button.setBounds(100, 100, 300, 50);
        button.setMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                System.out.println(e.toString());
            }
        });
        window.addComponent(button);
        window.show();
    }
}