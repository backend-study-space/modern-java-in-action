package CHAPTER7;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final String SENTENCE = "Nel    mezzo del cammin di nostra vita";
    public static void main(String[] args) {
        System.out.println(countWordsIteratively(SENTENCE));

        WordCounter wordCounter = new WordCounter(0, true);

        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);

        System.out.println("Found " + wordCounter.countWords(characterStream) + " words");
    }

    private static int countWordsIteratively(String s) {
        int counter = 0;

        boolean lastSpace = true;

        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) counter++;
                lastSpace = false;
            }
        }

        return counter;
    }
}
