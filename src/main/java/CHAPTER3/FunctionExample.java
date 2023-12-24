package CHAPTER3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    public <T, R> List<R> map(List<T> list, Function<T, R> function) {
        ArrayList<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(function.apply(t));
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> mappedList = new FunctionExample().map(User.create(), User::getName);

        System.out.println(mappedList);
    }
}
