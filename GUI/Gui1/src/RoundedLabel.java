import javax.swing.*;
import java.awt.*;

public class RoundedLabel extends JLabel {

    private Color backgroundColor;
    private int arcWidth;
    private int arcHeight;

    public RoundedLabel(String text, Color bgColor, int arcWidth, int arcHeight) {
        super(text);
        this.backgroundColor = bgColor;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false); // Make sure we don't use the default background rendering
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw rounded rectangle with background color
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        // Paint the text and other JLabel stuff
        super.paintComponent(g);
        g2.dispose();
    }
}
