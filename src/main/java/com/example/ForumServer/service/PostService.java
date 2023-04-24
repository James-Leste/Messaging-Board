package com.example.ForumServer.service;

import com.example.ForumServer.Common.Result;
import com.example.ForumServer.pojo.posts.Post;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface PostService {
    public Result save(Post post);

    public List<Post> findAll();

    //public User getUserById(String user_id);

    public Result getPostByEmail(String user_email);

    public Result getPostById(BigInteger post_id);

    public int delete(int id);
}
