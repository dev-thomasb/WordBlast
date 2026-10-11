import java.util.*;

public class gameLoop {
    private final inputManager input = new inputManager();

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
        }
    }
}

