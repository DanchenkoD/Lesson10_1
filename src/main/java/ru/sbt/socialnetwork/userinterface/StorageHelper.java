package ru.sbt.socialnetwork.userinterface;

import ru.sbt.socialnetwork.friends.IStorageFriends;
import ru.sbt.socialnetwork.posts.IStoragePosts;
import ru.sbt.socialnetwork.posts.Post;
import ru.sbt.socialnetwork.users.IStorageUsers;
import ru.sbt.socialnetwork.users.User;

import java.util.ArrayList;
import java.util.List;

public class StorageHelper {
    private final IStorageUsers usersStorage;
    private final IStoragePosts postsStorage;
    private final IStorageFriends friendsStorage;

    public StorageHelper(IStorageUsers usersStorage, IStoragePosts postsStorage, IStorageFriends friendsStorage) {
        this.usersStorage = usersStorage;
        this.postsStorage = postsStorage;
        this.friendsStorage = friendsStorage;
    }

    /**
     * Получить профиль пользователя
     *
     * @param userid id пользователя
     */
    User getProfile(long userid) {
        return usersStorage.getUser(userid);
    }

    /**
     * Получить "стену" пользователя (посты пользователя)
     *
     * @param userid id пользователя
     */
    List<Post> getWall(long userid) {
        return postsStorage.getPosts(userid);
    }

    /**
     * Получить список друзей пользователя
     *
     * @param userid id пользователя
     */
    List<User> getFriends(long userid) {
        return friendsStorage.getFriends(userid);
    }

    /**
     * Получить новости пользователя (посты друзей за последнее время)
     *
     * @param userid id пользователя
     */
    List<Post> getFeed(long userid) {
        List<Post> feed = new ArrayList<Post>();
        for (User friend : friendsStorage.getFriends(userid)) {
            //Для каждого друга, получить все посты
            //(в идеале тут выбор нескольких последних постов)
            feed.addAll(postsStorage.getPosts(friend.getId()));
        }
        return feed;
    }
}
