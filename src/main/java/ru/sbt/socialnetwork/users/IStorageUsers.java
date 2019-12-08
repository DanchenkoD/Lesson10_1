package ru.sbt.socialnetwork.users;

public interface IStorageUsers {
    User getUser(long id);
    void putUser(User user);
}
