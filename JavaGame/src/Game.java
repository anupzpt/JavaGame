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
        setContentPane(container);
    }
}

