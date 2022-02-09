import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Guess implements ActionListener {

    JFrame frame;
    JPanel panel;
    JButton guess,playAgain,giveUp;
    TextField t1,t2,t3;
    JLabel label,label1;
    Random random;
    int number;
    int numberOfGuesses=0;

    Guess(){

        random=new Random();
        this.number=random.nextInt(100);

        frame=new JFrame("Guess the Number");
        frame.setSize(800,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setLocationRelativeTo(null);

        guess=new JButton("Guess");
        guess.setBackground(Color.black);
        guess.setForeground(Color.orange);
        guess.setBounds(170,400,100,50);
        guess.setFocusable(false);
        frame.add(guess);
        guess.addActionListener(this);

        playAgain=new JButton("Play Again");
        playAgain.setBackground(Color.black);
        playAgain.setForeground(Color.orange);
        playAgain.setBounds(500,400,100,50);
        playAgain.setFocusable(false);
        playAgain.addActionListener(this);
        frame.add(playAgain);

        giveUp=new JButton("GIVE UP ?");
        giveUp.setBackground(Color.black);
        giveUp.setForeground(Color.orange);
        giveUp.setBounds(330,450,100,80);
        giveUp.setFocusable(false);
        giveUp.addActionListener(this);
        frame.add(giveUp);

        label=new JLabel("Guess the number");
        label.setFont(new Font("SansSerif Bold",Font.BOLD,50));
        label.setBounds(0,200,10,10);
        label.setForeground(Color.orange);
        frame.add(label);

        panel=new JPanel();
        panel.setBounds(120,100,500,70);
        panel.setBackground(Color.black);
        panel.setOpaque(true);
        panel.add(label);
        frame.add(panel);

        t1=new TextField();
        t1.setBounds(320,200,100,50);
        t1.setFont(new Font("SansSerif Bold",Font.BOLD,45));
        frame.add(t1);

        t2=new TextField("Guess no between 1-100");
        t2.setBounds(150,300,500,60);
        t2.setFont(new Font("SansSerif Bold",Font.BOLD,40));
        t2.setEditable(false);
        frame.add(t2);

        t3=new TextField();
        t3.setBounds(120,21,160,50);
        t3.setFont(new Font("SansSerif Bold",Font.BOLD,45));
        t3.setEditable(false);
        t3.setBackground(Color.black);
        t3.setForeground(Color.orange);
        frame.add(t3);

        label1=new JLabel("-No of Guesses");
        label1.setBounds(290,0,300,100);
        label1.setFont(new Font("SansSerif Bold",Font.BOLD,30));
        frame.add(label1);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guess) {
            int player = Integer.parseInt(t1.getText());
            if (player > 100) {
                t2.setText("Guess the number b/w 1-100");
                t2.setFont(new Font("SansSerif Bold", Font.BOLD, 35));
                t2.setBackground(Color.white);
                t2.setForeground(Color.BLACK);
                numberOfGuesses++;
                t3.setText(String.valueOf(numberOfGuesses));

            } else if (player > number) {
                t2.setText("Too High..");
                t2.setBackground(Color.red);
                t2.setForeground(Color.white);
                numberOfGuesses++;
                t3.setText(String.valueOf(numberOfGuesses));
            } else if (player < number) {
                t2.setText("Too Low..");
                t2.setBackground(Color.red);
                t2.setForeground(Color.white);
                numberOfGuesses++;
                t3.setText(String.valueOf(numberOfGuesses));
            } else {
                t2.setText(number+" You guessed it right! ");
                t2.setForeground(Color.black);
                t2.setBackground(Color.GREEN);
                numberOfGuesses++;
                t3.setText(String.valueOf(numberOfGuesses));
                numberOfGuesses = 0;
            }

        }
        if(e.getSource()==playAgain){
            random=new Random();
            this.number=random.nextInt(100);
            t1.setText("");
            t2.setText("");
            t2.setBackground(Color.white);
            t3.setText("");
            numberOfGuesses=0;

        }
        if(e.getSource()==giveUp){
            t2.setText("Number was "+number);
            t2.setFont(new Font("SansSerif Bold", Font.BOLD, 35));
            t2.setBackground(Color.white);
            t2.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new Guess();
    }
}
