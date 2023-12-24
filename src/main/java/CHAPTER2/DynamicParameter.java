package CHAPTER2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicParameter {

    static interface ApplePredicate {
        boolean test(Apple apple);
    }

    static class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    static class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals("green");
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) { // predicate 객체로 사과 검사 조건을 캡슐화 함.
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        filterApples(inventory, new DynamicParameter.AppleGreenColorPredicate());
    }
}
