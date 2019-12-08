package ru.sbt.socialnetwork.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User ();
    }

    @Test
    void setGetName() {
        user.setName("Сергей");
        assertEquals(user.getName(), "Сергей");
    }

    @Test
    void setGetAge() {
        user.setAge(21);
        assertEquals(user.getAge(),21);
    }

    @Test
    void setGetGender() {
        user.setGender(Gender.MALE);
        assertEquals(user.getGender(), Gender.MALE);
    }

    @Test
    void setGetHobbies() {
        user.setHobbies("Рыбалка, Компьютнрные игры");
        assertEquals(user.getHobbies(),"Рыбалка, Компьютнрные игры");
    }
}