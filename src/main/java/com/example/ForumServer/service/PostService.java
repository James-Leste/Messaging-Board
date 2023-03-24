package com.example.ForumServer.service;

import com.example.ForumServer.pojo.posts.Post;
import com.example.ForumServer.pojo.user.User;

import java.util.List;

public interface PostService {

    List<Post> getPostByUser(User user);
}