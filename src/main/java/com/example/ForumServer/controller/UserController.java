package com.example.ForumServer.controller;

import com.example.ForumServer.pojo.user.User;
import com.example.ForumServer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RestController 代表这个类处理http请求
@RequestMapping(value ="/v1", method = RequestMethod.GET)
@CrossOrigin
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/get/users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userMapper.findAll();
    }

    @GetMapping(value = "/get/user")
    public List<User> getUserByEmail(String user_email){
        return userMapper.findUserByEmail(user_email);
    }

    @GetMapping("/string")
    public String getString(@RequestParam(value = "m") String msg){
        return "hello, " + msg;
    }

    @RequestMapping(value = "/insert/user", method = RequestMethod.POST)
    public int insertUser(@RequestBody User user){
        return userMapper.insert(user);
    }

    @GetMapping(value = "/validate")
    public boolean validateUser(String user_email, String user_password){
        List<User> users = getUserByEmail(user_email);
        if(users.size() != 1) return false;
        else{
            User user = users.get(0);
            return user.getUser_password().equals(user_password);
        }
    }

}
