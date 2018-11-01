package Game;

import User.LogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameOverDialog {

    private JFrame jFrame = new JFrame("Game Over!!!");

    GameOverDialog(){

        JLabel overLabel = new JLabel("Game Over :'(");
        JLabel scoreLabel = new JLabel("Your score: " + Game.score);
        JLabel againLabel = new JLabel("Would you like to try again?");

        JButton againButton = new JButton("Try again");
        JButton logOutButton = new JButton("LogOut");
        JButton quitButton = new JButton("Quit");

        jFrame.setSize(400,200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = jFrame.getContentPane();

        container.setLayout(new GridLayout(3,2,10,10));

        container.add(overLabel);
        container.add(scoreLabel);
        container.add(againLabel);
        againButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                if(Game.user == null){
                    new Game();
                }else{
                    if(Game.user.getBestScore() < Game.score){
                        Game.user.setBestScore(Game.score);
                    }
                    Game.user.setNumberOfGames();
                    new Game(Game.user);
                }

            }
        });
        container.add(againButton);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        container.add(quitButton);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new LogIn();
            }
        });
        container.add(logOutButton);
        jFrame.setVisible(true);
    }
}