package DesignPatterns.BuilderDesignPattern;

import javax.swing.*;
import java.awt.*;

// The Builder class to configure JFrame properties
class FrameBuilder {
    private String title = "Default Title";
    private int width = 400;
    private int height = 300;
    private boolean hasPositiveButton = false;
    private boolean hasNegativeButton = false;

    public FrameBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public FrameBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public FrameBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public FrameBuilder addPositiveButton() {
        this.hasPositiveButton = true;
        return this;
    }

    public FrameBuilder addNegativeButton() {
        this.hasNegativeButton = true;
        return this;
    }

    public JFrame build() {
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        if (hasPositiveButton) {
            JButton yesButton = new JButton("Yes");
            yesButton.addActionListener(e -> System.out.println("Yes button clicked"));
            panel.add(yesButton);
        }

        if (hasNegativeButton) {
            JButton noButton = new JButton("No");
            noButton.addActionListener(e -> System.out.println("No button clicked"));
            panel.add(noButton);
        }

        frame.add(panel);
        return frame;
    }
}


