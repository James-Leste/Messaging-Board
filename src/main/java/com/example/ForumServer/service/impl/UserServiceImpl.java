package com.example.ForumServer.service.impl;

import com.example.ForumServer.Common.Constants;
import com.example.ForumServer.Common.Result;
import com.example.ForumServer.mapper.UserMapper;
import com.example.ForumServer.pojo.user.UserDto;
import com.example.ForumServer.service.UserService;
import com.example.ForumServer.pojo.user.User;
import com.example.ForumServer.utils.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(UserDto userDto) {
        String user_email = userDto.getUser_email();
        String user_password = userDto.getUser_password();
        List<User> users = userMapper.getUserByEmail(user_email);
        if(users.size() == 1){
            User user = users.get(0);
            BeanUtils.copyProperties(user, userDto);
            userDto.setToken(JwtUtils.genToken(user.getId().toString(), user.getUser_password()));
            boolean isSuccess = user.getUser_password().equals(user_password);
            //登录成功返回success和用户对象, 失败返回401
            return isSuccess ? Result.success(userDto) : Result.error(Constants.code_401, "密码账号错误");
        } else{
            return Result.systemError();
        }

    }

    @Override
    public Result save(User user) {

        if(user.getId() == null){ // user 是新增的
            if(userMapper.getUserByEmail(user.getUser_email()).size() == 0){ //用户原本不存在
                userMapper.insert(user);
                return Result.success(user.getUser_name() + " 注册成功", user);
            }else{
                return Result.error(Constants.code_500, "注册失败, 邮箱已被占用");
            }
        } else{ //user 已经存在
            return Result.success(user.getUser_name() + " 修改成功", user);
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
