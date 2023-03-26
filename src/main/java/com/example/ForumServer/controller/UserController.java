package com.example.ForumServer.controller;

import com.example.ForumServer.pojo.user.User;
import com.example.ForumServer.mapper.UserMapper;
import com.example.ForumServer.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // RestController 代表这个类处理http请求
@RequestMapping(value ="/user", method = RequestMethod.GET)
@CrossOrigin
public class UserController {

    @Resource
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public int save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/login")
    // @RequestBody注解可以把传过来的JSON数据转为对象
    public boolean login(@RequestBody User user){
        String username = user.getUser_name();
        String password = user.getUser_password();
        if(username.isBlank() || password.isBlank()){
            return false;
        }
        return false;
    }
//    @RequestMapping(value = "/get/users", method = RequestMethod.GET)
//    public List<User> getAllUsers(){
//        return userMapper.findAll();
//    }
//
//    @GetMapping(value = "/get/user")
//    public List<User> getUserByEmail(String user_email){
//        return userMapper.findUserByEmail(user_email);
//    }
//
//    @GetMapping("/string")
//    public String getString(@RequestParam(value = "m") String msg){
//        return "hello, " + msg;
//    }
//
//    @RequestMapping(value = "/insert/user", method = RequestMethod.POST)
//    public int insertUser(@RequestBody User user){
//        return userMapper.insert(user);
//    }
//
//    @GetMapping(value = "/validate")
//    public boolean validateUser(String user_email, String user_password){
//        List<User> users = getUserByEmail(user_email);
//        if(users.size() != 1) return false;
//        else{
//            User user = users.get(0);
//            return user.getUser_password().equals(user_password);
//        }
//    }

}
