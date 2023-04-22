package com.example.ForumServer.controller;


import com.example.ForumServer.Common.Result;
import com.example.ForumServer.pojo.user.User;
import com.example.ForumServer.mapper.UserMapper;
import com.example.ForumServer.pojo.user.UserDto;
import com.example.ForumServer.service.UserService;

import com.example.ForumServer.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController // RestController 代表这个类处理http请求
@RequestMapping(value ="/user", method = RequestMethod.GET)
@CrossOrigin
public class UserController {



    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


    @PostMapping("/save")
    public Result save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/login")
    // @RequestBody注解可以把传过来的JSON数据转为对象
    public Result login(@RequestBody UserDto userDto){
        String user_email = userDto.getUser_email();
        String user_password = userDto.getUser_password();
        if(user_email.isBlank() || user_password.isBlank()){
            return Result.paraError(); //预先判断参数是否为空
        }
        return userService.login(userDto);
    }

    @PostMapping("/register")
    public Result signUp(@RequestBody User user){
        String user_name = user.getUser_name();
        String user_email = user.getUser_email();
        String user_password = user.getUser_password();
        if(user_email.isBlank() || user_name.isBlank()){
            return Result.paraError();
        }
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id){
        return userService.delete(id);
    }

    @GetMapping("/page")
    public Map<String, Object> findByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
        //分页查询
        int start = (pageNumber - 1) * pageSize;
        int userCount = userMapper.count();
        List<User> result = userMapper.getUsersByPage(start, pageSize);
        Map<String, Object> response = new HashMap<>();
        response.put("total", userCount);
        response.put("result", result);
        return response;
    }

    @GetMapping("/personal")
    public Result getUserById(@RequestParam String user_email){
        return userService.getUserByEmail(user_email);
    }

    @GetMapping("/test")
    public User test(@RequestParam String id){
        return userService.getUserById(id);
    }
}
