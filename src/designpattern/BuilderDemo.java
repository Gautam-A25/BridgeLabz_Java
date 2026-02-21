package designpattern;

class User {

    private String name;
    private int age;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    static class Builder {
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public void show() {
        System.out.println(name + " " + age);
    }
}

public class BuilderDemo {
    public static void main(String[] args) {

        User user = new User.Builder()
                .setName("Nehaa")
                .setAge(21)
                .build();

        user.show();
    }
}