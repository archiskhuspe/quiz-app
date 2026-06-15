import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    JButton b1, b2;
    String username;

    Rules(String username) {
        this.username = username;
        setBounds(600, 200, 800, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Welcome " + username + " to the ultimate Java Quiz!");
        l1.setForeground(new Color(30, 144, 255));
        l1.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
        l1.setBounds(50, 20, 700, 30);
        add(l1);

        JLabel l2 = new JLabel("");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(20, 90, 600, 350);
        l2.setText(
                "<html>" +
                        "1. You get 15 seconds to answer a question."
                        + "<br><br>" +
                        "2. You get 10 points for each correct answer. 0 points for unattempted/wrong answers."
                        + "<br><br>" +
                        "3. All the questions are compulsory." + "<br><br>"
                        +
                        "4. 50-50 lifeline is available, and the options gets reduced from 4 to 2 for that question."
                        + "<br><br>" +
                        "5. The lifeline can be used only once." + "<br><br>" +
                        "6. Revise your Java concepts before attempting this quiz."
                        + "<br><br>" +
                        "7. There are 10 questions in total." + "<br><br>" +
                        "8. May you score well! All the best!" + "<br><br>" +
                        "<html>");
        add(l2);

        b1 = new JButton("Back");
        b1.setBounds(250, 500, 100, 30);
        b1.setBackground(new Color(30, 144, 255));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Start");
        b2.setBounds(400, 500, 100, 30);
        b2.setBackground(new Color(30, 144, 255));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            this.setVisible(false);
            new QuizApp().setVisible(true);
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
            new Quiz(username).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Rules("");
    }
}