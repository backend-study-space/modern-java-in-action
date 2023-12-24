package CHAPTER3;

import java.util.List;

public class User {
    private Long id;

    private String name;

    private User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public static List<User> create() {
        return List.of(new User(1L, "a"), new User(2L, "b"), new User(3L, "c"));
    }

    public static User create(Long id, String name) {
        return new User(id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
