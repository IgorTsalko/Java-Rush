package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {
    protected Map<String, User> users = new LinkedHashMap();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone;
        try {
            clone = (Solution) solution.clone();
            System.out.println("Original: " + solution);
            System.out.println("Clone:    " + clone);
            System.out.println("Are Original and Clone equal: " + solution.equals(clone));

            System.out.println("Original users: " + solution.users);
            System.out.println("Clone    users: " + clone.users);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            User u = new User(this.age, this.name);
            return u;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution s = new Solution();
        s.users.putAll(this.users);
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
