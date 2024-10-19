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
        jf.setBounds(240, 200, 400, 400);

        JPanel panel1 = new JPanel(new GridLayout(2, 2, 80, 80));
        JLabel usernamelb = new JLabel("Username:");
        JTextField usernametf = new JTextField();

        JLabel passwordlb = new JLabel("Password:");
        JPasswordField passwordtf = new JPasswordField();
        panel1.setPreferredSize(new Dimension(200, 300));

        JButton signupbtn = new JButton("Signup");
        signupbtn.addActionListener(e -> new Signup());

        JButton loginbtn = new JButton("Login");
        loginbtn.addActionListener(e -> {
            String username = usernametf.getText();
            String password = new String(passwordtf.getPassword());

            try {
                Database.TableData();



//                if (Database.validateUser(username, password)) {
//                    un = username;
//                    new Dashboard(un);  // Redirect to dashboard
//                    jf.dispose();
//                } else {
//                    JOptionPane.showMessageDialog(jf, "Invalid credentials");
//                }
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
        panel2.add(signupbtn);

        jf.add(panel1, BorderLayout.CENTER);
        jf.add(panel2, BorderLayout.SOUTH);
        jf.setVisible(true);
    }

    public String getUn() {
        return un;
    }
}
