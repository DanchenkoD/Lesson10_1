package ru.sbt.socialnetwork.userinterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sbt.socialnetwork.friends.IStorageFriends;
import ru.sbt.socialnetwork.posts.IStoragePosts;
import ru.sbt.socialnetwork.posts.Post;
import ru.sbt.socialnetwork.users.Gender;
import ru.sbt.socialnetwork.users.IStorageUsers;
import ru.sbt.socialnetwork.users.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StorageHelperTest {
    private StorageHelper storageHelper;

    private IStorageUsers usersStor;
    private IStoragePosts postsStor;
    private IStorageFriends frendsStor;

    @BeforeEach
    void setUp() {
        this.usersStor = mock(IStorageUsers.class);
        this.postsStor = mock(IStoragePosts.class);
        this.frendsStor = mock(IStorageFriends.class);

        //Create users
        User user0 = new User(
                "Николай",
                8,
                Gender.MALE,
                "Мультики, Компьютнрные игры"
        );

        User user1 = new User(
                "Василий",
                67,
                Gender.MALE,
                "Рыбалка, Хокей"
        );

        User user2 = new User(
                "Аня",
                23,
                Gender.FEMALE,
                "Кулинария, Вышивание"
        );

        when(usersStor.getUser(0)).thenReturn(user0);
        when(usersStor.getUser(1)).thenReturn(user1);
        when(usersStor.getUser(2)).thenReturn(user2);

        //Create posts
        List<Post> posts0 = new ArrayList<>();
        List<Post> posts1 = new ArrayList<>();
        List<Post> posts2 = new ArrayList<>();

        Post post0 = new Post(0, "Фиксики", "Новая серия Фиксиков");
        Post post1 = new Post(1, "Турнир", "Соревнование по рыбной ловле");
        Post post2 = new Post(2, "Торт рыжик", "Рецепт торта");

        posts0.add(post0);
        posts1.add(post1);
        posts2.add(post2);

        when(postsStor.getPosts(0)).thenReturn(posts0);
        when(postsStor.getPosts(1)).thenReturn(posts1);
        when(postsStor.getPosts(2)).thenReturn(posts2);

        //Create friends
        List<User> friends = new ArrayList<>();
        friends.add(user1);
        friends.add(user2);

        when(frendsStor.getFriends(0)).thenReturn(friends);

        this.storageHelper = new StorageHelper(usersStor, postsStor, frendsStor);

    }

    @Test
    void getProfile() {
        User user = storageHelper.getProfile(0);

        assertEquals(user.getName(), "Николай");
        assertEquals(user.getAge(), 8);
        assertEquals(user.getGender(), Gender.MALE);
        assertEquals(user.getHobbies(), "Мультики, Компьютнрные игры");
    }

    @Test
    void getWall() {
        List<Post> posts = storageHelper.getWall(0);

        assertEquals(posts.get(0).getUserid(), 0);
        assertEquals(posts.get(0).getTitle(), "Фиксики");
        assertEquals(posts.get(0).getContent(), "Новая серия Фиксиков");
    }

    @Test
    void getFriends() {
        List<User> friends = storageHelper.getFriends(0);

        assertEquals(friends.get(0), storageHelper.getProfile(1));
        assertEquals(friends.get(1), storageHelper.getProfile(2));
    }

    @Test
    void getFeed() {
        List<Post> feed = storageHelper.getFeed(0);

        assertEquals(feed.get(0).getTitle(), "Турнир");
        assertEquals(feed.get(1).getTitle(), "Торт рыжик");
    }
}