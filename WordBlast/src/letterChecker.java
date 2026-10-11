import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class letterChecker{
    private int letterSetAmount;
    private String letterSet;
    private scoreMaker scoreMaker;
    private wordAuth wordAuth;

    public void makeLetterSet(){
        boolean foundSet = false;
        while(!foundSet){
            String wordToCheck = wordAuth.getRandomWord();
            foundSet = checkIfGood(wordToCheck);
        }
    }
    private boolean checkIfGood(String word)
    {
        ArrayList<Integer> comboes = new ArrayList<>();
        if(letterSetAmount == 3){
            for(int i = 0; i < word.length()-2; i++){
                comboes.add(i);
            }
            int loopSize = comboes.size();
            for(int i = 0; i < loopSize; i++){
                int randomIndex = ThreadLocalRandom.current().nextInt(comboes.size());
                comboes.remove(randomIndex);
                String combo = word.substring(randomIndex, randomIndex + 3);
                if(scoreMaker.CalculateScore(combo) <= 12){
                    letterSet = combo;
                    return true;
                }
            }
        }
        else if(letterSetAmount == 2){
            for(int i = 0; i < word.length()-1; i++){
                comboes.add(i);
            }
            int loopSize = comboes.size();
            for(int i = 0; i < loopSize; i++){
                int randomIndex = ThreadLocalRandom.current().nextInt(comboes.size());
                comboes.remove(randomIndex);
                String combo = word.substring(randomIndex, randomIndex + 2);
                if(scoreMaker.CalculateScore(combo) <= 11){
                    letterSet = combo;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkWord(String word){
        for(int i = 0; i < word.length()-1; i++){
            char alpha = word.charAt(i);
            char beta = word.charAt(i+1);
            char gamma = word.charAt(i+2);
            if(letterSetAmount == 3){
                if(i + 2 > word.length()){
                    return false;
                }
                if(alpha == letterSet.charAt(0) && beta == letterSet.charAt(1) && gamma == letterSet.charAt(2)){
                    return true;
                }
            }
            else if(letterSetAmount == 2){
                if(alpha == letterSet.charAt(0) && beta == letterSet.charAt(1)){
                    return true;
                }
            }
        }
        return false;
    }

}
