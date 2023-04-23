package com.example.ForumServer.controller;

import com.example.ForumServer.Common.Result;
import com.example.ForumServer.mapper.PostMapper;
import com.example.ForumServer.pojo.posts.Post;
import com.example.ForumServer.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/post")
@CrossOrigin
public class PostController {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostService postService;


    @PostMapping(value = "/edit")
    public Result insertPost(@RequestBody Post post){
        return postService.save(post);
    }

    @GetMapping(value = "/all")
    public List<Post> getAllPosts(){
        return postMapper.getAll();
    }

    @GetMapping("/page")
    public Map<String, Object> findByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
        //分页查询
        int start = (pageNumber - 1) * pageSize;
        int postCount = postMapper.count();
        List<Post> result = postMapper.getPostsByPage(start, pageSize);
        Map<String, Object> response = new HashMap<>();
        response.put("total", postCount);
        response.put("result", result);
        return response;
    }
}
