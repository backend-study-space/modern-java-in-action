package CHAPTER4;

import java.util.stream.Stream;

public class InfiniteStreamExample {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 2)
                .forEach(System.out::println);
    }
}
