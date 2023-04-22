package com.example.ForumServer.controller;

import com.example.ForumServer.Common.Result;
import com.example.ForumServer.mapper.PostMapper;
import com.example.ForumServer.pojo.posts.Post;
import com.example.ForumServer.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/post")
@CrossOrigin
public class PostController {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostService postService;


    @PostMapping(value = "/insert")
    public Result insertPost(@RequestBody Post post){
        return postService.save(post);
        //return postMapper.insert(post);
    }

    @GetMapping(value = "/all")
    public List<Post> getAllPosts(){
        return postMapper.getAll();
    }
}
