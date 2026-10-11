

public class Player {
    private int playerNum;
    private int playerScore;
    private String playerName;

    public Player() { // Construct with nothing, every player starts at 0.
        playerNum = 0;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void addScore(int points) {
        playerScore += points;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
