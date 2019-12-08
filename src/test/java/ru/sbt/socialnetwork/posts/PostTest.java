package ru.sbt.socialnetwork.posts;

import org.junit.Rule;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    @Rule
    Post post = new Post(1);

    @org.junit.jupiter.api.Test
    void setGetTitle() {
        post.setTitle("Title 1");
        assertEquals(post.getTitle(), "Title 1");
    }

    @org.junit.jupiter.api.Test
    void setGetContent() {
        post.setContent("Тестовое содержимое");
        assertEquals(post.getContent(), "Тестовое содержимое");
    }
}