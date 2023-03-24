package com.example.ForumServer.mapper;


import com.example.ForumServer.pojo.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user;")
    List<User> findAll();

    @Select("select * from user where user_email = #{user_email};")
    List<User> findUserByEmail(@Param("user_email") String user_email);

    @Insert("Insert into user (user_name, user_email, user_password) values (#{user_name}, #{user_email}, #{user_password})")
    int insert(User user);

}
