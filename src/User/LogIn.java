package User;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
                String resultQuery = "";
                if(nameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You should fill all fields to move on..", "Error", JOptionPane.ERROR_MESSAGE);
                }
                try{
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arkanoiddb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL","root","root");
                    PreparedStatement statement = connection.prepareStatement("select password from users where name = ?");
                    statement.setString(1, nameField.getText());
                    ResultSet resultSet = statement.executeQuery();
                    resultSet.next();
                    resultQuery = resultSet.getString(1);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Something goes wrong :'(", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                }
                if(resultQuery.equals(passwordField.getText())){
                    User user = new User(nameField.getText(), passwordField.getText());
                    jFrame.dispose();
                    new Game(user);
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong password", "Error", JOptionPane.ERROR_MESSAGE);
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