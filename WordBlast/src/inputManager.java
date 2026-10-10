import java.util.*;

public class inputManager {
    private static int numPlayers;
    private static String word;
    private static Scanner scanner = new Scanner(System.in);
    public boolean players() {
        System.out.println("How many players?");
        numPlayers = scanner.nextInt();
        getPlayers();
        return(true);
    }
    public boolean gameInput() {
        System.out.println("Quick, input your word!!!");
        word = scanner.nextLine();
        getWord();
        return(true);
    }
    public int getPlayers() {
        return numPlayers;
    }
    public String getWord() {
        return word;
    }
}