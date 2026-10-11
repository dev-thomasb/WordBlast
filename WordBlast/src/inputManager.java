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
        return getPlayers();
    }
    public String playerName() {
        System.out.println("Input player name:");
        return scanner.nextLine();
    }
    public String gameInput() {
        System.out.println("Quick, input your word!!!");
        word = scanner.nextLine();
        return getWord();
    }
    public int getPlayers() {
        return numPlayers;
    }
    public String getWord() {
        return word;
    }
}