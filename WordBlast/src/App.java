public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(wordAuth.isWordValid("hello"));
        wordAuth.removeWord("hello");
        System.out.println(wordAuth.isWordValid("hello"));
    }


}
