package com.example.ForumServer.mapper;


import com.example.ForumServer.pojo.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user;")
    List<User> findAll();

    @Insert("Insert into user (user_name, user_email, user_password) values (#{user_name}, #{user_email}, #{user_password})")
    int insert(User user);

}
