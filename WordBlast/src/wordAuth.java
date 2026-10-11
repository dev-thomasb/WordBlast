import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class wordAuth {
    //validWords used to check if word is valid, wordList used to get random word
    private static HashSet<String> validWords = new HashSet<>();
    private static ArrayList<String> wordList = new ArrayList<>();

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
        wordList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("src/validwords.txt"))) {
            String line;
            //while line is not blank
            while ((line = br.readLine()) != null) {
                validWords.add(line.trim());
                wordList.add(line.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void removeWord(String word) {
        validWords.remove(word);
        wordList.remove(word);
    }

    public static String getRandomWord() {
        if (wordList.isEmpty()) {
            return null; // No words remain
        }
        //Generates a random value based off wordList size
        int randomIndex = ThreadLocalRandom.current().nextInt(wordList.size());
        
        return wordList.get(randomIndex);
    }

}