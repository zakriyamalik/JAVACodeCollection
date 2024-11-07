import javax.swing.*;
import java.awt.*;

public class login extends JFrame {
    String un;

    public login() {
        un = "";
    }

    public void showlogin() {
        JFrame jf = new JFrame("Login");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(0, 0, 600, 600);

        JPanel panel1 = new JPanel(new GridLayout(2, 2, 80, 80));
        JLabel usernamelb = new JLabel("Username:");
        JTextField usernametf = new JTextField();

        JLabel passwordlb = new JLabel("Password:");
        JPasswordField passwordtf = new JPasswordField();
        panel1.setPreferredSize(new Dimension(200, 300));

        JButton loginbtn = new JButton("Login");
        loginbtn.addActionListener(e -> {
            String username = usernametf.getText();
            String password = new String(passwordtf.getPassword());

            try {
                if (Database.validateUser(username, password)) {
                    JOptionPane.showMessageDialog(jf, "User Exist");
                } else {
                    int num=Database.insertUser(username,password);
                    if(num==1) {
                        JOptionPane.showMessageDialog(jf, "User registered");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(jf, "User not registered");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        panel1.add(usernamelb);
        panel1.add(usernametf);
        panel1.add(passwordlb);
        panel1.add(passwordtf);

        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(loginbtn);

        jf.add(panel1, BorderLayout.CENTER);
        jf.add(panel2, BorderLayout.SOUTH);
        jf.setVisible(true);
    }

    public String getUn() {
        return un;
    }
}