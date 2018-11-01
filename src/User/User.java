package User;

public class User {
    private String name;
    private String password;
    private int numberOfGames;
    private int bestScore;

    User(String name, String password){
        this.name = name;
        this.password = password;
        //get info from DB...
        //..
    }

    User(String name, String password, int numberOfGames, int bestScore){
        this.bestScore = bestScore;
        this.name = name;
        this.numberOfGames = numberOfGames;
        this.password = password;
        //push info into DB..
        //..
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