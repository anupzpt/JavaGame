import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Game extends JFrame {
    void Game(){
        //creates frame
        setTitle("Whack A Mole");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 608, 600);
        setVisible(true);

        //background or container for the game
        JPanel container = new JPanel();
        container.setBackground(new Color(64, 110, 64));
        container.setBorder(new EmptyBorder(5,5,5,5));
        container.setLayout(null);

        //title set
        JLabel Title = new JLabel("Whack A Mole");
        Title.setForeground(new Color(225, 192, 23, 255));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("Century Gothic",Font.BOLD,20));
        Title.setBounds(0,10,602,47);

        //add title
        container.add(Title);

        //replaces the content pane of the frame with the specified container
        setContentPane(container);
    }
}

