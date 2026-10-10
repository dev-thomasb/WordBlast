import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class wordAuth {
    private static HashSet<String> validWords = new HashSet<>();
    
    public static boolean isWordValid(String word) {
        // Create a hashset of valid words that is based off
        // the words in words.txt
        if (validWords.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader("src/validwords.txt"))) {
            String line;
            //while line is not blank
            while ((line = br.readLine()) != null) {
                validWords.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        
        return validWords.contains(word);
    }

}