import java.util.*;

public class gameLoop {
    private final inputManager input = new inputManager();
    private final scoreMaker scoring = new scoreMaker();

    ArrayList<Player> playerList = new ArrayList<>();

    public void run() {
        int playerAmount = input.players();

        // Register everyone before turns begin.
        for (int i = 0; i < playerAmount; i++) {
            Player player = new Player();
            player.setPlayerNum(i + 1);
            player.setPlayerName(input.playerName());
            playerList.add(player);
        }

        // Give each registered player one turn.
        for (Player player : playerList) {
            System.out.println(player.getPlayerName() + ", your turn!");
            String word = input.gameInput();
            System.out.println(player.getPlayerName() + " entered: " + word);
            if (wordAuth.isWordValid(word)) {
                int points = scoring.CalculateScore(word);
                player.addScore(points);
                System.out.println("Valid word! You earned " + points + " points.");
            } else {
                System.out.println("Invalid word. No points awarded.");
            }
            System.out.println("Total score: " + player.getPlayerScore());
        }
    }
}

