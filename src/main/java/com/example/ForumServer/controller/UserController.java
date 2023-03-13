package com.example.ForumServer.controller;

import com.example.ForumServer.pojo.user.User;
import com.example.ForumServer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RestController 代表这个类处理http请求
@RequestMapping(value ="/v1", method = RequestMethod.GET)
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/get/user", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userMapper.findAll();
    }

    @GetMapping("/string")
    public String getString(@RequestParam(value = "m") String msg){
        return "hello, " + msg;
    }

    @RequestMapping(value = "/insert/user", method = RequestMethod.POST)
    public int insertUser(@RequestBody User user){
        return userMapper.insert(user);
    }

}
