package ru.sbt.socialnetwork.users;

import java.util.Objects;

public class User {
    private static long idCounter;

    private final long id;
    private String name;
    private int age;
    private Gender gender;
    private String hobbies;

    public User() {
        this.id = idCounter++;
    }

    public User(String name, int age, Gender gender, String hobbies) {
        this();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String info) {
        this.hobbies = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name) &&
                gender == user.gender &&
                Objects.equals(hobbies, user.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender, hobbies);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
