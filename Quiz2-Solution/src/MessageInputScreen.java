import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MessageInputScreen{
    String un;
    JLayeredPane layeredPane;  // JLayeredPane to hold layers
    JPanel notificationPanel;


    void showDashboard() {
        JFrame jf = new JFrame("Message input");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setBounds(100, 100, 600, 600);

        // Create the main panels
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(50,50,600,600);
        JLabel label1 = new JLabel("sender");
        JLabel label2=new JLabel("recipient");
        JLabel label3=new JLabel("Message");
        JTextField Textfield1 = new JTextField("");
        JTextField Textfield2=new JTextField("");
        JTextField Textfield3=new JTextField("");
        label1.setBounds(50,50,100,50);
        label2.setBounds(50,120,100,50);
        label3.setBounds(50,190,100,50);

        Textfield1.setBounds(150,50,100,50);
        Textfield2.setBounds(150,120,100,50);
        Textfield3.setBounds(150,190,100,50);

        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);

        panel1.add(Textfield1);
        panel1.add(Textfield2);
        panel1.add(Textfield3);
        JButton submit=new JButton("Submit");
        submit.setBounds(150,250,80,40);
        panel1.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sender=Textfield1.getText();
                String recepient=Textfield2.getText();
                String message=Textfield3.getText();
                int num= 0;
                try {
                    num = Database.insertMessage(sender,recepient,message);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,"Number of rows affected are"+num);
            }
        });

        jf.add(panel1);

        // Show the frame
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        MessageInputScreen ms=new MessageInputScreen();
        ms.showDashboard();
    }
}
