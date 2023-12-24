package CHAPTER3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();

        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PredicateExample predicate = new PredicateExample();

        List<User> users = User.create();

        List<User> filteredUsers = predicate.filter(users, user -> user.getId() < 3L);

        System.out.println(filteredUsers);
    }
}
