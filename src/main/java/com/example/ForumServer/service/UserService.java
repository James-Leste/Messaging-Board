package com.example.ForumServer.service;

import com.example.ForumServer.Common.Result;
import com.example.ForumServer.pojo.user.User;
import com.example.ForumServer.pojo.user.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public Result save(User user);

    public List<User> findAll();

    public User getUserById(String user_id);

    public int delete(int id);

    Result login(UserDto userDto);

}
