package CHAPTER7;

import java.util.stream.Stream;

public class WordCounter {

    private final int counter;

    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accmulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter
                , wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }

    public int countWords(Stream<Character> stream) {
        WordCounter wordCounter =
                stream.reduce(
                    new WordCounter(0, true),
                        WordCounter::accmulate,
                        WordCounter::combine
                );

        return wordCounter.getCounter();
    }
}
