package com.example.ForumServer.controller;

import com.example.ForumServer.Common.Result;
import com.example.ForumServer.mapper.PostMapper;
import com.example.ForumServer.pojo.posts.Post;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value ="/post")
@CrossOrigin
public class PostController {

    private final PostMapper postMapper;

    @Autowired
    public PostController(PostMapper postMapper){
            this.postMapper = postMapper;
    }

    @PostMapping(value = "/create")
    public Result insertPost(@RequestBody Post post){
        return new Result();
        //return postMapper.insert(post);
    }

    @GetMapping(value = "/getAll")
    public Collection<Post> getAllPosts(){
        return postMapper.getAll();
    }
}
