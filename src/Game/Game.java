package Game;

import User.User;

import javax.swing.*;

public class Game{
    static User user;
    static JFrame jFrame = new JFrame("Arkanoid");
    static int score;
    private GamePanel gamePanel = new GamePanel();

    {
        final int WIDTH = GamePanel.SCALE * GamePanel.WIDTH, HEIGHT = GamePanel.SCALE * GamePanel.HEIGHT;
        jFrame.setSize(WIDTH + 10, HEIGHT);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }

    public Game(){
        score = 0;
    }

    public Game(User user){
        this.user = user;
        score = 0;
    }
}