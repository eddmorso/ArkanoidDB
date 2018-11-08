package Game;

import javax.swing.*;
import java.awt.*;

class ShowUserInfo {

    private JFrame jFrame = new JFrame("Info");

    ShowUserInfo(){
        JLabel nameLabel = new JLabel("   Name: " + Game.user.getName());
        JLabel bestScoreLabel = new JLabel("   Best score: " + Game.user.getBestScore());
        JLabel noGamesLabel = new JLabel("   Total number of games: " + Game.user.getNumberOfGames());

        jFrame.setSize(300,150);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);

        Container container = jFrame.getContentPane();

        container.setLayout(new GridLayout(3,2,5,5));

        container.add(nameLabel);
        container.add(bestScoreLabel);
        container.add(noGamesLabel);

        jFrame.setVisible(true);
    }
}
