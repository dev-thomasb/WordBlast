import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class wordAuth {
    private static final HashSet<String> validWords = new HashSet<>();
    private static final ArrayList<String> wordList = new ArrayList<>();
    private static boolean loaded;

    public static boolean isWordValid(String word) {
        ensureLoaded();
        return word != null && validWords.contains(word);
    }

    private static void ensureLoaded() {
        if (!loaded) {
            generateValidWords();
        }
    }

    public static void generateValidWords() {
        validWords.clear();
        wordList.clear();
        loaded = false;
        InputStream dictionary = wordAuth.class.getResourceAsStream("/validwords.txt");
        try {
            if (dictionary == null) {
                Path path = Path.of("src/validwords.txt");
                if (!Files.exists(path)) {
                    path = Path.of("WordBlast/src/validwords.txt");
                }
                dictionary = Files.newInputStream(path);
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(dictionary, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String entry = line.trim();
                    if (!entry.isEmpty() && validWords.add(entry)) {
                        wordList.add(entry);
                    }
                }
            }
            loaded = true;
        } catch (IOException e) {
            validWords.clear();
            wordList.clear();
            throw new IllegalStateException("Unable to load validwords.txt.", e);
        }
    }

    public static void removeWord(String word) {
        ensureLoaded();
        validWords.remove(word);
        wordList.remove(word);
    }

    public static String getRandomWord() {
        ensureLoaded();
        if (wordList.isEmpty()) {
            return null;
        }
        int randomIndex = ThreadLocalRandom.current().nextInt(wordList.size());
        return wordList.get(randomIndex);
    }
}
