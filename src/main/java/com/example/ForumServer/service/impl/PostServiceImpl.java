package com.example.ForumServer.service.impl;

import com.example.ForumServer.Common.Constants;
import com.example.ForumServer.Common.Result;
import com.example.ForumServer.mapper.PostMapper;
import com.example.ForumServer.mapper.UserMapper;
import com.example.ForumServer.pojo.posts.Post;
import com.example.ForumServer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Override
    public Result save(Post post) {
        if(post.getPost_id() == null){ //这是一条新增的帖子
            postMapper.insert(post);
            return Result.success("发帖成功");
        }else{
            postMapper.update(post);
            return Result.success("主题帖修改成功");
        }
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
    public Result getPostById(BigInteger post_id) {
        List<Post> posts = postMapper.getPostsById(post_id);
        if(posts.size() == 1){
            return Result.success("帖子读取成功", posts.get(0));
        } else {
            return Result.error(Constants.code_402, "帖子读取出错");
        }
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
