package com.example.ForumServer.controller;

import com.example.ForumServer.mapper.PostMapper;
import com.example.ForumServer.pojo.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value ="/v1", method = RequestMethod.GET)
@CrossOrigin
public class PostController {
    private final PostMapper postMapper;

    @Autowired
    public PostController(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    @PostMapping(value = "/create/post")
    public int insertPost(@RequestBody Post post){
        return 0;
        //return postMapper.insert(post);
    }

    @GetMapping(value = "/getAll/post")
    public Collection<Post> getAllPosts(){
        return postMapper.getAll();
    }
}
