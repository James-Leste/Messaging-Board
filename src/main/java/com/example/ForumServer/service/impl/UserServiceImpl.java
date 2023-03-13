package com.example.ForumServer.service.impl;

import com.example.ForumServer.mapper.UserMapper;
import com.example.ForumServer.service.UserService;
import com.example.ForumServer.pojo.user.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public List<User> getUser() {
        return userMapper.findAll();
    }
}
