package CHAPTER3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<User> users = User.create();

        users.sort((user1, user2) -> {
            return user1.getId().compareTo(user2.getId());
        });

        users.sort(Comparator.comparing(User::getId));

        List<String> str = List.of("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);

        Supplier<User> u1 = User::new;
        User user = u1.get();

        Function<Long, User> u2 = User::new;
        User user1 = u2.apply(0L);

        List<Long> longs = List.of(0L, 1L, 2L, 3L);

        List<User> map = map(longs, User::new);

        BiFunction<Long, String, User> c3 = User::create;
        User a = c3.apply(0L, "a");

        users.sort(Comparator
                .comparing(User::getId)
                .reversed()
                .thenComparing(User::getName));


    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(f.apply(t));
        }

        return result;
    }
}
