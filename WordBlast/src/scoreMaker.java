public class scoreMaker{

    public int CalculateScore(String word){
        int score = 0;
        //for(char c : word.toCharArray()){
        //    score += CharacterScore(c);
        //}
        for(int i = 0; i < word.length(); i++){
            score += CharacterScore(word.charAt(i));
        }
        return score;
    }

    private int CharacterScore(char c){
        switch(c){
            case 'a': case 'e': case 'i': case 'o': case 'u': case 'l': case 'n': case 's': case 't': case 'r':
                return 1;
            case 'd': case 'g':
                return 2;
            case 'b': case 'c': case 'm': case 'p':
                return 3;
            case 'f': case 'h': case 'v': case 'w': case 'y':
                return 4;
            case 'k':
                return 5;
            case 'j': case 'x':
                return 8;
            case 'q': case 'z':
                return 10;
            default:
                return 0;
        }
    }

}
