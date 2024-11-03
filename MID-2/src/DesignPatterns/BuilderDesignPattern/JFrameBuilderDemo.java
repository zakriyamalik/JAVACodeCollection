package DesignPatterns.BuilderDesignPattern;

import javax.swing.*;

// Demo class to test the FrameBuilder
public class JFrameBuilderDemo {
    public static void main(String[] args) {
        JFrame frame = new FrameBuilder()
                .setTitle("Custom JFrame")
                .setWidth(500)
                .setHeight(400)
                .addPositiveButton()
                .addNegativeButton()
                .build();

        frame.setVisible(true);
    }
}