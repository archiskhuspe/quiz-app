import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String username, int score) {
        setBounds(600, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/finalscore.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 200, 300, 250);
        add(l1);

        JLabel l2 = new JLabel("Thank you " + username + " for playing!");
        l2.setBounds(45, 30, 700, 30);
        l2.setFont(new Font("Courier New", Font.BOLD, 26));
        add(l2);

        JLabel l3 = new JLabel("Your score is: " + score);
        l3.setBounds(350, 200, 300, 30);
        l3.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(l3);

        JButton b1 = new JButton("Play Again");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(400, 270, 120, 30);
        b1.addActionListener(this);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
        new QuizApp().setVisible(true);
    }

    public static void main(String[] args) {
        new Score("", 0).setVisible(true);
    }
}
