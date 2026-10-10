import java.util.*;

public class inputManager {
    private int numPlayers;
    private String name;
    private String word;
    private static Scanner scanner = new Scanner(System.in);
    public int players() {
        System.out.println("How many players?");
        numPlayers = scanner.nextInt();
        return getPlayers();
    }
    public String playerName() {
        System.out.println("Input player name:");
        name = scanner.nextLine();
        return getName();
    }
    public String gameInput() {
        System.out.println("Quick, input your word!!!");
        word = scanner.nextLine();
        return getWord();
    }
    public int getPlayers() {
        return numPlayers;
    }
    public String getName() {
        return name;
    }
    public String getWord() {
        return word;
    }
}