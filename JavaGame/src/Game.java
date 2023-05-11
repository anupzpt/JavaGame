import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.lang.String;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Point;
import javax.swing.JOptionPane;


public class Game extends JFrame implements ActionListener{
    public int check=0;
    JPanel container = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponents(g);
            Image image = new ImageIcon(this.getClass().getResource("/Background.png")).getImage();
            g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
        }

    };
    JPanel container2 = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponents(g);
            Image image = new ImageIcon(this.getClass().getResource("/Background.png")).getImage();
            g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
        }
    };
    JPanel panel=new JPanel(new GridLayout(4,4));

    JLabel[] holes = new JLabel[16];
    int[] board =new int[16];
    JButton btn = new JButton();
    JButton btn2 = new JButton();
    JLabel Title = new JLabel();
//    JLabel scoreField = new JLabel("Score : 0");
    int score=0;
    int timeLeft =30;
    int highscore =0;
    JLabel lblScore =new JLabel("Score : 0");
    JLabel lblTimeLeft;
    JLabel lblHighscore;
    Timer timer;
    JTextField tf =  new JTextField();

    ImageIcon[] images = new ImageIcon[] {new ImageIcon("Mole.png"), new ImageIcon("Mole2.png"),new ImageIcon("Mole3.png"),new ImageIcon("Mole4.png"),new ImageIcon("Mole5.png"),new ImageIcon("Mole6.png"),new ImageIcon("Mole8.png"),new ImageIcon("Mole9.png"),new ImageIcon("Mole11.png"),new ImageIcon("Mole12.png")};
    private ActionEvent e;

    void start(){
//        ImageIcon hammerIcon = new ImageIcon(loadImage("/Hammer.png").getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH));
//        Cursor hammerCursor = Toolkit.getDefaultToolkit().createCustomCursor(hammerIcon.getImage(), new Point(0,0), "custom cursor");
//        panel.setCursor(hammerCursor);
       panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(loadImage("/Hammer.png").getImage(),new Point(0,0),"custom cursor"));
        //creates a starting frame
        setTitle("!!! Whack A Mole !!!");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100,100,608,720);

        container2.setBorder(new EmptyBorder(5,5,5,5));
        container2.setLayout(null);

        btn.setBackground(Color.YELLOW);
        btn.setText("Play Game");
        btn.setFont(new Font("Century Gothic", Font.BOLD,25));
        btn.setBorder(null);
        btn.setBounds(150,425,300,60);
        btn.setVisible(true);
        btn.setLayout(null);
        container2.add(btn);
        btn.addActionListener(this);

        Title.setText("WHACK A MOLE");
        Title.setBackground(Color.GREEN);
        Title.setForeground(new Color(225, 192, 23, 255));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("Century Gothic",Font.BOLD,60));
        Title.setBounds(0,180,602,47);

        container2.add(Title);

        setVisible(true);
        setContentPane(container2);

    }
    void initialGame()
    {
        //creates frame
        setTitle("!!! Whack A Mole !!!");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 608, 720);

        //background or container for the game
        container.setBackground(Color.GREEN);
        container.setBorder(new EmptyBorder(5,5,5,5));
        container.setLayout(null);

        //Score label
//        scoreField.setText("Score:0");
        lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblScore.setFont(new Font("Century Gothic",Font.BOLD,25));
        lblScore.setBounds(423,68,144,33);
        lblScore.setForeground(new Color(135,206,250));
        lblScore.setBackground(Color.GREEN);
        container.add(lblScore);

        //text-field
//        tf.setBounds(480,50,80,30);
//        container.add(tf);

        btn2.setText("Start");
        btn2.setBounds(20,70,100,30);
        btn2.setFont(new Font("Century Gothic", Font.BOLD, 20));
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(Color.BLACK);
        btn2.addActionListener(this);
        container.add(btn2);

        //title set
        JLabel Title = new JLabel("Whack-A-Mole");
        Title.setForeground(new Color(245, 216, 6, 247));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("Century Gothic",Font.BOLD,30));
        Title.setBackground(Color.GREEN);
        Title.setBounds(0,15,602,47);

        lblTimeLeft = new JLabel("30");
        lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLeft.setForeground(new Color(135,206,250));
        lblTimeLeft.setBackground(Color.GREEN);
        lblTimeLeft.setFont(new Font("Cambria Math", Font.BOLD, 24));
        lblTimeLeft.setBounds(232,75,144,33);
        container.add(lblTimeLeft);

        lblHighscore = new JLabel("Highscore: 0");
        lblHighscore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblHighscore.setForeground(new Color(152, 209, 245));
        lblHighscore.setFont(new Font("Cambria", Font.BOLD, 20));
        lblHighscore.setBounds(433, 35, 134, 33);
        container.add(lblHighscore);
        //add title
        container.add(Title);
        setVisible(true);
        //replaces the content pane of the frame with the specified container
        setContentPane(container);
    }
    void Game(){
        //function call
        initialGame();
        panel();
        holes();
        clearBoard();
        event();

    }
    void event(){
        for(int i=0;i< holes.length;i++)
        {
            JLabel lbl = holes[i];
            lbl.setName(Integer.toString(i));
            lbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel lbl =(JLabel)e.getSource();
                    int id =Integer.parseInt(lbl.getName());
                    hit(id);
                }
            });
        }
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn2.setEnabled(false);
                clearBoard();
                popUp();
                timer.start();
            }
        });
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(timeLeft == 0){
                    lblTimeLeft.setText("" + timeLeft);
                    timer.stop();
                    gameOver();
                }
                lblTimeLeft.setText("" + timeLeft);
                timeLeft--;
            }
        });
    }
    void hit(int id){
        if(check==1) {
            int value = board[id];
            if (value == 1) {
                score++;
            } else {
                score--;
            }
            lblScore.setText("Score:" + score);
            clearBoard();
            popUp();
        }
    }
    void gameOver(){
        btn2.setEnabled(true);
        if(score > highscore){
            highscore = score;
            lblHighscore.setText("Highscore: " + highscore);
            JOptionPane.showMessageDialog(this, "Your final score is: " + score, "You beat the high score!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Your final score is: " + score, "Game Over!", JOptionPane.INFORMATION_MESSAGE);
        }
        score = 0;
        timeLeft = 30;
        lblScore.setText("Score: 0");
        lblTimeLeft.setText("30");
        clearBoard();
    }
    void panel(){
        try{
            panel.setBackground(new Color(0, 100, 0));
            panel.setBounds(32, 105, 528, 528);
            panel.setLayout(null);
            container.add(panel);

//            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
//                    loadImage("/hammer.png").getImage(),
//                    new Point(0,0),"custom cursor1"));
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }
    void holes(){
        //create hole
        holes[0] = new JLabel();
        //holes[0].setName("0");
        holes[0].setBounds(0, 396, 132, 132);
        panel.add(holes[0]);

        holes[1] = new JLabel();
        //holes[1].setName("1");
        holes[1].setBounds(132, 396, 132, 132);
        panel.add(holes[1]);

        holes[2] = new JLabel();
        //holes[2].setName("2");
        holes[2].setBounds(264, 396, 132, 132);
        panel.add(holes[2]);

        holes[3] = new JLabel();
        //holes[3].setName("3");
        holes[3].setBounds(396, 396, 132, 132);
        panel.add(holes[3]);

        holes[4] = new JLabel();
        //holes[4].setName("4");
        holes[4].setBounds(0, 264, 132, 132);
        panel.add(holes[4]);

        holes[5] = new JLabel();
        //holes[5].setName("5");
        holes[5].setBounds(132, 264, 132, 132);
        panel.add(holes[5]);

        holes[6] = new JLabel();
        //holes[6].setName("6");
        holes[6].setBounds(264, 264, 132, 132);
        panel.add(holes[6]);

        holes[7] = new JLabel();
        //holes[7].setName("7");
        holes[7].setBounds(396, 264, 132, 132);
        panel.add(holes[7]);

        holes[8] = new JLabel();
        //holes[8].setName("8");
        holes[8].setBounds(0, 132, 132, 132);
        panel.add(holes[8]);

        holes[9] = new JLabel();
        //holes[9].setName("9");
        holes[9].setBounds(132, 132, 132, 132);
        panel.add(holes[9]);

        holes[10] = new JLabel();
        //holes[10].setName("10");
        holes[10].setBounds(264, 132, 132, 132);
        panel.add(holes[10]);

        holes[11] = new JLabel();
        //holes[11].setName("11");
        holes[11].setBounds(396, 132, 132, 132);
        panel.add(holes[11]);

        holes[12] = new JLabel();
        //holes[12].setName("12");
        holes[12].setBounds(0, 0, 132, 132);
        panel.add(holes[12]);

        holes[13] = new JLabel();
        //holes[13].setName("13");
        holes[13].setBounds(132, 0, 132, 132);
        panel.add(holes[13]);

        holes[14] = new JLabel();
        //holes[14].setName("14");
        holes[14].setBounds(264, 0, 132, 132);
        panel.add(holes[14]);

        holes[15] = new JLabel();
        //holes[15].setName("15");
        holes[15].setBounds(396, 0, 132, 132);
        panel.add(holes[15]);

        for(int i = 0; i < 16; i++){
            holes[i].setIcon(loadImage("/moleIn.png"));
            board[i] = 0;
        }
    }
    void clearBoard(){
        for(int i=0; i<16;i++)
        {
            holes[i].setIcon(loadImage("/moleIn.png"));
            board[i]=0;
        }
    }
    void popUp(){
        try {
            int img_nos =16;
            Random random = new Random();
            int element;
            do {
                element = (int) (Math.random() * img_nos) % holes.length;
            } while (board[element] == 1);
            int number = random.nextInt(img_nos) % images.length;
            String img = String.valueOf(images[number]);
            holes[element].setIcon(moleImage(img));
            board[element] = 1;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
//        Random rnd = new Random(System.currentTimeMillis());
//        int moleID = rnd.nextInt(16);
//        board[moleID]=1;
//        holes[moleID].setIcon(moleImage("/mole2.png"));
    }

    private ImageIcon moleImage(String path){
        try{
            Image mole_image = new ImageIcon(this.getClass().getResource(path)).getImage();
            Image scale = mole_image.getScaledInstance(132,132,Image.SCALE_DEFAULT);
            return new ImageIcon(scale);
        }
        catch(NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }
    private ImageIcon loadImage(String path){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaled = image.getScaledInstance(132,132 , Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btn){
            Game();
        }
        else if (e.getSource() == btn2){
            check=1;
        }
        else{
            System.out.println("No button clicked");
        }
    }
}

