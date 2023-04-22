package com.example.ForumServer.service.impl;

import com.example.ForumServer.Common.Constants;
import com.example.ForumServer.Common.Result;
import com.example.ForumServer.mapper.PostMapper;
import com.example.ForumServer.mapper.UserMapper;
import com.example.ForumServer.pojo.posts.Post;
import com.example.ForumServer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Override
    public Result save(Post post) {
        int n = postMapper.insert(post);
        Result result;
        if(n > 0) {
            result = Result.success("发帖成功");
        } else {
            result = Result.error(Constants.code_402, "发帖失败");
        }
        return result;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Result getPostByEmail(String user_email) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
