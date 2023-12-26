package CHAPTER4.실전연습;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final Trader raoul = new Trader("Raoul", "Cambridge");
    private static final Trader mario = new Trader("Mario", "Milan");
    private static final Trader alan = new Trader("Alan", "Cambridge");
    private static final Trader brian = new Trader("Brian", "Cambridge");

    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        quiz1();
        quiz2();
        quiz3();
        quiz4();
        quiz4Refactor();
        quiz5();
        quiz6();
        quiz7();
    }

    private static void quiz1() {
        List<Transaction> collect = transactions
                .stream()
                .filter(it -> it.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    private static void quiz2() {
        List<String> collect = transactions
                .stream()
                .map(it -> it.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList()); // toSet으로도 사용 가능

        System.out.println(collect);
    }

    private static void quiz3() {
        List<Transaction> collect = transactions
                .stream()
                .filter(it -> it.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(it -> it.getTrader().getName()))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    private static void quiz4() {
        List<List<String>> collect = transactions.stream()
                .map(it -> Arrays
                        .stream(it.getTrader().getName().split(""))
                        .map(String::toLowerCase)
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println(collect);

    }

    private static void quiz4Refactor() {
        String reduce = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(reduce);
    }

    private static void quiz5() {
        boolean milan = transactions
                .stream()
                .anyMatch(it -> it.getTrader().getCity().equals("Milan"));

        System.out.println(milan);
    }

    private static void quiz6() {
        List<Integer> collect = transactions
                .stream()
                .filter(it -> it.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    private static void quiz7() {
        Integer integer = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .get();

        System.out.println(integer);
    }
}
