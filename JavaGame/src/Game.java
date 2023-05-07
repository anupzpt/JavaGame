import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Game extends JFrame {
    JPanel container = new JPanel();
    JPanel panel =new JPanel();
    JLabel[] holes = new JLabel[16];
    private ImageIcon loadImage(String path){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaled = image.getScaledInstance(132,132 , Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
    void Game(){
        //creates frame
        setTitle("Whack A Mole");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 608, 720);
        setVisible(true);

        //background or container for the game
        container.setBackground(new Color(64, 110, 64));
        container.setBorder(new EmptyBorder(5,5,5,5));
        container.setLayout(null);

        //title set
        JLabel Title = new JLabel("Whack A Mole");
        Title.setForeground(new Color(225, 192, 23, 255));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("Century Gothic",Font.BOLD,20));
        Title.setBounds(0,15,602,47);

        //add title
        container.add(Title);

        //function call
        panel();
        holes();
        
        //replaces the content pane of the frame with the specified container
        setContentPane(container);
    }
    void panel(){
        //panel for hole
        panel.setBackground(new Color(76, 148, 76));
        panel.setBounds(32, 105, 528, 528);
        panel.setLayout(null);
        container.add(panel);
    }

    void holes(){
        //create hole
        holes[0] = new JLabel("0");
        holes[0].setName("0");
        holes[0].setBounds(0, 396, 132, 132);
        panel.add(holes[0]);

        holes[1] = new JLabel("1");
        holes[1].setName("1");
        holes[1].setBounds(132, 396, 132, 132);
        panel.add(holes[1]);

        holes[2] = new JLabel("2");
        holes[2].setName("2");
        holes[2].setBounds(264, 396, 132, 132);
        panel.add(holes[2]);

        holes[3] = new JLabel("3");
        holes[3].setName("3");
        holes[3].setBounds(396, 396, 132, 132);
        panel.add(holes[3]);

        holes[4] = new JLabel("4");
        holes[4].setName("4");
        holes[4].setBounds(0, 264, 132, 132);
        panel.add(holes[4]);

        holes[5] = new JLabel("5");
        holes[5].setName("5");
        holes[5].setBounds(132, 264, 132, 132);
        panel.add(holes[5]);

        holes[6] = new JLabel("6");
        holes[6].setName("6");
        holes[6].setBounds(264, 264, 132, 132);
        panel.add(holes[6]);

        holes[7] = new JLabel("7");
        holes[7].setName("7");
        holes[7].setBounds(396, 264, 132, 132);
        panel.add(holes[7]);

        holes[8] = new JLabel("8");
        holes[8].setName("8");
        holes[8].setBounds(0, 132, 132, 132);
        panel.add(holes[8]);

        holes[9] = new JLabel("9");
        holes[9].setName("9");
        holes[9].setBounds(132, 132, 132, 132);
        panel.add(holes[9]);

        holes[10] = new JLabel("10");
        holes[10].setName("10");
        holes[10].setBounds(264, 132, 132, 132);
        panel.add(holes[10]);

        holes[11] = new JLabel("11");
        holes[11].setName("11");
        holes[11].setBounds(396, 132, 132, 132);
        panel.add(holes[11]);

        holes[12] = new JLabel("12");
        holes[12].setName("12");
        holes[12].setBounds(0, 0, 132, 132);
        panel.add(holes[12]);

        holes[13] = new JLabel("13");
        holes[13].setName("13");
        holes[13].setBounds(132, 0, 132, 132);
        panel.add(holes[13]);

        holes[14] = new JLabel("14");
        holes[14].setName("14");
        holes[14].setBounds(264, 0, 132, 132);
        panel.add(holes[14]);

        holes[15] = new JLabel("15");
        holes[15].setName("15");
        holes[15].setBounds(396, 0, 132, 132);
        panel.add(holes[15]);

        for(int i = 0; i < 16; i++){
            holes[i].setIcon(loadImage("/moleIn.png"));
        }
    }
}

