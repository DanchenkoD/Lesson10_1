package ru.sbt.socialnetwork.friends;

import ru.sbt.socialnetwork.users.User;

import java.util.List;

public interface IStorageFriends {
    List<User> getFriends(long userid);
}
