package User;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp{

    private JFrame jFrame = new JFrame("Sign Up");

    private JLabel nameLabel = new JLabel("Enter your name please..");
    private JLabel passwordLabel = new JLabel("Enter your password please..");
    private JLabel repeatLabel = new JLabel("Repeat your password please..");

    private JTextField nameField = new JTextField(30);
    private JPasswordField passwordField = new JPasswordField(30);
    private JPasswordField repeatField = new JPasswordField(30);

    private JButton signUp = new JButton("Sign Up");
    private JButton backButton = new JButton("Back");

    SignUp(){
        jFrame.setSize(400,200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = jFrame.getContentPane();

        container.setLayout(new GridLayout(4,2,10,10));

        container.add(nameLabel);
        container.add(nameField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(repeatLabel);
        container.add(repeatField);
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameField.getText().isEmpty() || passwordField.getText().isEmpty() || repeatField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "You should fill all fields to move on..", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(passwordField.getText().equals(repeatField.getText())){
                    User user = new User(nameField.getText(), passwordField.getText(), 0, 0);
                    jFrame.dispose();
                    new Game(user);
                }else{
                    JOptionPane.showMessageDialog(null, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        container.add(signUp);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new LogIn();
            }
        });
        container.add(backButton);

        jFrame.setVisible(true);
    }
}