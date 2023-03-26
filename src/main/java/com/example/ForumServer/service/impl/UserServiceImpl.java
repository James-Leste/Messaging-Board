package com.example.ForumServer.service.impl;

import com.example.ForumServer.mapper.UserMapper;
import com.example.ForumServer.service.UserService;
import com.example.ForumServer.pojo.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {

        return false;
    }
}
