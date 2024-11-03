import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    // Flags to prevent infinite recursion
  public static void main(String[] args) {
        JFrame f = new JFrame("GUI Example");
        JButton b1 = new JButton("+");
        JButton b2 = new JButton("-");
        JButton b3= new JButton("Counter");
        final JTextField tf = new JTextField();
        final JTextField tf1 = new JTextField();
        final JTextField tf2 = new JTextField();

        tf.setBounds(50, 50, 150, 20);
        tf.setText("0");
        tf1.setBounds(50, 80, 150, 20);
        tf1.setText("0");

        tf2.setBounds(50, 110, 150, 20);
        tf2.setText("0");

        b1.setBounds(50, 140, 100, 40);
        f.add(b1);
        b2.setBounds(50, 190, 100, 40);
        f.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the current value from the text field, increment it, and update the field
                    int text = Integer.parseInt(tf.getText());
                    text++;
                    tf.setText(String.valueOf(text));
                    int sum=0;
                    sum=Integer.parseInt(tf.getText())+Integer.parseInt(tf1.getText());
                    tf2.setText(String.valueOf(sum));
                } catch (NumberFormatException ex) {
                    // Handle invalid input (resetting to 1 if input is invalid)
                    tf.setText("1");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the current value from the text field, increment it, and update the field
                    int text = Integer.parseInt(tf.getText());
                    text--;
                    tf.setText(String.valueOf(text));
                    int sum=0;
                    if(Integer.parseInt(tf.getText())>Integer.parseInt(tf1.getText()))
                    {
                        sum = Integer.parseInt(tf.getText()) - Integer.parseInt(tf1.getText());
                    }
                    else if(Integer.parseInt(tf.getText())<Integer.parseInt(tf1.getText()))
                    {
                        sum = Integer.parseInt(tf1.getText()) - Integer.parseInt(tf.getText());
                    }
                    else
                    {


                    }
                    tf2.setText(String.valueOf(sum));
                } catch (NumberFormatException ex) {
                    // Handle invalid input (resetting to 1 if input is invalid)
                    tf.setText("1");
                }
            }
        });


        JTextArea area=null;
      area=new JTextArea("Pata nai kia ban rha hai");
      area.setBounds(50, 240, 200, 80);

      String text=area.getText();
      final String[][] words = {text.split("\\s")};
        JLabel l1,l2;
        l1=new JLabel();
        l1.setBounds(50,330,100,30);

        l2=new JLabel();
        l2.setBounds(160,330,100,30);
      l1.setText("Words: "+0);
      l2.setText("Characters: "+0);
        b3.setBounds(50,370,100,30);
      JTextArea finalArea = area;
      b3.addActionListener(new ActionListener() {
          @Override

          public void actionPerformed(ActionEvent e) {
              try {
                  String text= finalArea.getText();
                  words[0] =text.split("\\s");
                  // Get the current value from the text field, increment it, and update the field
                  l1.setText("Words: "+ words[0].length);
                  l2.setText("Characters: "+text.length());
              } catch (NumberFormatException ex) {
                  // Handle invalid input (resetting to 1 if input is invalid)
                  l1.setText("Words: "+0);
                  l2.setText("Characters: "+0);
              }
          }
      });
      String languages[]={"C","C++","C#","Java","PHP"};
      final JComboBox cb=new JComboBox(languages);
      cb.setBounds(50, 410,90,20);
      f.add(cb);



      f.add(b3);
        f.add(l1);
        f.add(l2);
        f.add(area);
        f.add(tf);
        f.add(tf1);
        f.add(tf2);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
