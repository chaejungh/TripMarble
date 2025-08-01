package tripmarble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class D02DiceSwing extends JFrame {
    private JLabel resultLabel;
    private JButton rollButton;
    private Random random;

    public D02DiceSwing() {
        setTitle("주사위 굴리기");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        resultLabel = new JLabel("주사위를 굴려보세요!");
        resultLabel.setFont(new Font("굴림", Font.BOLD, 20));

        rollButton = new JButton("주사위 굴리기");
        rollButton.setFont(new Font("굴림", Font.PLAIN, 16));

        random = new Random();

        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dice = random.nextInt(6) + 1;
                resultLabel.setText("주사위 눈: " + dice);
            }
        });

        add(resultLabel);
        add(rollButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new D02DiceSwing();
    }
}