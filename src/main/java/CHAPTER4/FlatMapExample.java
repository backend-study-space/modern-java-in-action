package CHAPTER4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
//        String[] arrayOfWords = {"Goodbye", "World"};
//
//        List<Stream<String>> badExample = Arrays.stream(arrayOfWords)
//                .map(word -> word.split(""))
//                .map(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());
//
//        List<String> goodExample = Arrays.stream(arrayOfWords)
//                .map(word -> word.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());
//
//        System.out.println(badExample);
//        System.out.println(goodExample);
//
//        quiz();
//        quiz2();
        quiz3();
    }

    private static void quiz() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        List<Integer> collectedList = integers.stream().map(it -> it * it).collect(Collectors.toList());

        System.out.println(collectedList);
    }

    private static void quiz2() {
        List<Integer> integers1 = List.of(1, 2, 3);
        List<Integer> integers2 = List.of(3, 4);

        List<int[]> collect = integers1
                .stream()
                .flatMap(i -> integers2
                        .stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());


        collect.forEach(a -> System.out.println(Arrays.toString(a)));
    }

    private static void quiz3() {
        List<Integer> integers1 = List.of(1, 2, 3);
        List<Integer> integers2 = List.of(3, 4);

        List<int[]> collect = integers1.stream()
                .flatMap(i -> integers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        collect.forEach(a -> System.out.println(Arrays.toString(a)));
    }
}
