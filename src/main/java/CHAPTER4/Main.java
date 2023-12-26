package CHAPTER4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        legacyLogic();
//        streamLogic();
        getLogStreamLogic();
    }

    private static void legacyLogic() {
        List<Dish> menu = Dish.create();

        List<Dish> lowCaloricDishes = new ArrayList<>();

        // 메뉴에서 400 칼로리 이하인 메뉴만 선택해서, 가비지 변수에 더해줌
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        // 정렬
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        ArrayList<String> lowCaloricDishesName = new ArrayList<>();

        // 가비지 변수에서 이름 값만 가져와서 새 리스트에 더해줌.
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
    }

    private static void streamLogic() {
        List<String> lowCaloricDishesName = Dish.create()
                .stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    private static void getLogStreamLogic() {
        List<String> lowCaloricDishesName = Dish.create()
                .stream()
                .filter(d -> {
                    System.out.println("filtering : " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping : " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
    }
}
