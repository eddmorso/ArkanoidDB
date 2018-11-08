package Game;

import User.LogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class GameOverDialog {

    private JFrame jFrame = new JFrame("Game Over!!!");

    GameOverDialog(){
        if(Game.user.getBestScore() < Game.score){
            Game.user.setBestScore(Game.score);
        }
        Game.user.setNumberOfGames();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arkanoiddb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL","root","root");
            PreparedStatement statement = connection.prepareStatement("update users set noGames = ?, bestScore = ? where name = ?");
            statement.setInt(1, Game.user.getNumberOfGames());
            statement.setInt(2, Game.user.getBestScore());
            statement.setString(3, Game.user.getName());
            statement.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex);
        }
        JLabel overLabel = new JLabel("Game Over :'(");
        JLabel scoreLabel = new JLabel("Your score: " + Game.score);
        JLabel againLabel = new JLabel("Would you like to try again?");

        JButton againButton = new JButton("Try again");
        JButton logOutButton = new JButton("LogOut");
        JButton quitButton = new JButton("Quit");
        JButton showInfoButton = new JButton("Show User Info");

        jFrame.setSize(400,200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = jFrame.getContentPane();

        container.setLayout(new GridLayout(4,2,10,10));

        container.add(overLabel);
        container.add(scoreLabel);
        container.add(againLabel);
        againButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                if(Game.user == null){
                    new Game();
                }else
                    new Game(Game.user);
            }
        });
        container.add(againButton);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Game.user.getBestScore() < Game.score){
                    Game.user.setBestScore(Game.score);
                }
                Game.user.setNumberOfGames();
                try{
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arkanoiddb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL","root","root");
                    PreparedStatement statement = connection.prepareStatement("update users set noGames = ?, bestScore = ? where name = ?");
                    statement.setInt(1, Game.user.getNumberOfGames());
                    statement.setInt(2, Game.user.getBestScore());
                    statement.setString(3, Game.user.getName());
                    statement.executeUpdate();
                }catch (Exception ex){
                    System.out.println(ex);
                }
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
        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowUserInfo();
            }
        });
        container.add(showInfoButton);
        jFrame.setVisible(true);
    }
}