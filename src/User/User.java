package User;

import java.sql.*;

public class User {
    private String name;
    private String password;
    private int numberOfGames;
    private int bestScore;

    User(String name, String password){
        this.name = name;
        this.password = password;
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arkanoiddb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL","root","root");
            PreparedStatement statement = connection.prepareStatement("select noGames, bestScore from users where name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            this.numberOfGames = resultSet.getInt(1);
            this.bestScore = resultSet.getInt(2);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword(){
        return password;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public void setNumberOfGames(){
        this.numberOfGames++;
    }
}