package ru.sbt.socialnetwork.posts;

import java.util.List;

public interface IStoragePosts {
    List<Post> getPosts(long userid);

    void putPost(Post post);
}
