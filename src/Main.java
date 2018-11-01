import User.LogIn;

import javax.swing.*;

public class Main {
    public static void main(String [] args){
        JOptionPane.showMessageDialog(null, "During the game press ESC to quit.", "Info", JOptionPane.INFORMATION_MESSAGE);
        new LogIn();
    }
}