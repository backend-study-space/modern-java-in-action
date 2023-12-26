package CHAPTER6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Main {

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {
        List<Dish> menu = Dish.create();

        Map<Dish.Type, List<Dish>> collect = menu
                .stream()
                .collect(groupingBy(Dish::getType));

        System.out.println(collect);

        Map<Dish.Type, List<Dish>> collect1 = menu
                .stream()
                .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));

        System.out.println(collect1);

        Map<Dish.Type, List<Integer>> collect2 = menu
                .stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getCalories, toList())));

        System.out.println(collect2);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect3 = menu
                .stream()
                .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }, toList())));

        System.out.println(collect3);

        Map<Boolean, Dish> collect4 = menu
                .stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));

        System.out.println(collect4);
    }

    public boolean isPrime(int candidate) {
        int sqrt = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, sqrt)
                .noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.range(2, n).boxed()
                .collect(partitioningBy(this::isPrime));
    }
}
