import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutExe {
    private JFrame mainFrame;
    private JPanel controlPanel;

    public BorderLayoutExe() {
    }

    public static void main(String[] args) {
        BorderLayoutExe bl=new BorderLayoutExe();
        bl.prepareGui();
        bl.showBorderLayout();

    }
    private void prepareGui()
    {
        mainFrame=new JFrame("BorderLayout Frame");
        mainFrame.setSize(300,300);
       // mainFrame.setLayout(new BorderLayout());
        controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        mainFrame.add(controlPanel);

        mainFrame.setVisible(true);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

    }
    private void showBorderLayout()
    {
        JPanel panel=new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setSize(300,300);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        panel.setLayout(layout);

        panel.add(new JButton("Center"),BorderLayout.CENTER);
        panel.add(new JButton("Line Start"),BorderLayout.LINE_START);
        panel.add(new JButton("Line End"),BorderLayout.LINE_END);
        panel.add(new JButton("East"),BorderLayout.EAST);
        panel.add(new JButton("West"),BorderLayout.WEST);
        panel.add(new JButton("North"),BorderLayout.NORTH);
        panel.add(new JButton("South"),BorderLayout.SOUTH);
        controlPanel.add(panel);


        mainFrame.setVisible(true);



    }




}
