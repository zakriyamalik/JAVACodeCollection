package DesignPatterns.SingletonDesginPattern;

import javax.swing.*;

// Demo class to test the SingletonFrameBuilder with Singleton pattern
public class JSingletonFrameBuilderDemo {
    public static void main(String[] args) {
        JFrame frame = SingletonFrameBuilder.getInstance()
                .setTitle("Singleton JFrame")
                .setWidth(500)
                .setHeight(400)
                .addPositiveButton()
                .addNegativeButton()
                .build();

        frame.setVisible(true);
    }
}