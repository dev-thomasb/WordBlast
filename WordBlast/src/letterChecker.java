import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class letterChecker {
    private int letterSetAmount;
    private String letterSet;
    private final scoreMaker scoring = new scoreMaker();

    public void makeLetterSet() {
        // The upper bound is exclusive: this chooses either 2 or 3.
        letterSetAmount = ThreadLocalRandom.current().nextInt(2, 4);
        letterSet = null;

        ArrayList<String> words = wordAuth.getRemainingWords();
        Collections.shuffle(words);
        for (String word : words) {
            if (checkIfGood(word)) {
                return;
            }
        }
        throw new IllegalStateException(
                "No remaining word can provide " + letterSetAmount + " characters.");
    }

    private boolean checkIfGood(String word) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i <= word.length() - letterSetAmount; i++) {
            positions.add(i);
        }
        Collections.shuffle(positions);

        int maxScore = letterSetAmount == 3 ? 12 : 11;
        for (int start : positions) {
            String candidate = word.substring(start, start + letterSetAmount);
            if (scoring.CalculateScore(candidate) <= maxScore) {
                letterSet = candidate;
                return true;
            }
        }
        return false;
    }

    public String getLetterSet() {
        return letterSet;
    }

    public boolean checkWord(String word) {
        return word != null && letterSet != null && word.contains(letterSet);
    }
}
