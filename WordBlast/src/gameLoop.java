import java.util.*;

public class gameLoop {
    private final inputManager input = new inputManager();
    private final scoreMaker scoring = new scoreMaker();

    ArrayList<Player> playerList = new ArrayList<>();

    public void run() {
        int playerAmount = input.players();

        for (int i = 0; i < playerAmount; i++) {
            Player player = new Player();
            player.setPlayerNum(i + 1);
            playerList.add(player);

            System.out.println("Player " + player.getPlayerNum() + ", your turn!");
            String word = input.gameInput();
            System.out.println("Player " + player.getPlayerNum() + " entered: " + word);
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

