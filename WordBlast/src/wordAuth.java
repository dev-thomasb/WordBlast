import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class wordAuth {
    private static HashSet<String> validWords = new HashSet<>();

    //Checks if the word is valid by checking if HashSet contains the word
    public static boolean isWordValid(String word) {
        if (validWords.isEmpty()) {
            generateValidWords();
        }
        return validWords.contains(word);
    }

    //Generates the HashSet of valid words from the words.txt file
    public static void generateValidWords() {
        validWords.clear();
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
    public static void removeWord(String word) {
        validWords.remove(word);
    }

}