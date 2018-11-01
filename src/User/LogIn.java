package User;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn{

    private JFrame jFrame = new JFrame("Log In");

    private JButton signIn = new JButton("Sign In");
    private JButton signUp = new JButton("Sign Up");
    private JButton startGame = new JButton("Play");
    private JButton quitButton = new JButton("Quit");

    private JTextField nameField = new JTextField(30);
    private JPasswordField passwordField = new JPasswordField(30);

    private JLabel logInLabel = new JLabel("Enter your login..");
    private JLabel passwordLabel = new JLabel("Enter your password..");

    public LogIn(){
        jFrame.setSize(400,200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = jFrame.getContentPane();

        container.setLayout(new GridLayout(4,2,10,10));

        container.add(logInLabel);
        container.add(nameField);
        container.add(passwordLabel);
        container.add(passwordField);
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You should fill all fields to move on..", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    User user = new User(nameField.getText(), passwordField.getText());
                    jFrame.dispose();
                    new Game(user);
                }
            }
        });
        container.add(signIn);
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp();
                jFrame.dispose();
            }
        });
        container.add(signUp);
        startGame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Game();
                jFrame.dispose();
            }
        });
        jFrame.add(startGame);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        container.add(quitButton);

        jFrame.setVisible(true);
    }
}