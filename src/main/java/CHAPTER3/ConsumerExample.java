package CHAPTER3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
        ConsumerExample consumer = new ConsumerExample();

        consumer.forEach(User.create(), user -> {
            System.out.println(user.toString());
        });
    }
}
