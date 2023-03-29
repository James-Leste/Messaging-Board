package com.example.ForumServer.service.impl;

import com.example.ForumServer.mapper.UserMapper;
import com.example.ForumServer.service.UserService;
import com.example.ForumServer.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        if(user.getId() == null){ // user 是新增的
            return userMapper.insert(user);
        } else{ //user 已经存在
            return userMapper.update(user);
        }
    }

    @Override
    public List<User> findAll() {
        return userMapper.getAll();
    }

    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }
}
