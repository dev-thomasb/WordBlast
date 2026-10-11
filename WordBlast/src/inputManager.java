import java.util.*;

public class inputManager {

    private int numPlayers;
    private String word;
    private static Scanner scanner = new Scanner(System.in);

    public inputManager(){

    }

    
    public int players() {
        System.out.println("How many players?");
        numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left after the number.
        return getPlayers();
    }
    public String playerName() {
        System.out.println("Input player name:");
        return scanner.nextLine();
    }
    public String gameInput() {
        System.out.println("Quick, input your word!!!");
        word = scanner.nextLine();
        word = word.toLowerCase();
        return getWord();
    }
    public int getPlayers() {
        return numPlayers;
    }
    public String getWord() {
        return word;
    }
}
