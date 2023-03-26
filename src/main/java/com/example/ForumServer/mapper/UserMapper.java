package com.example.ForumServer.mapper;


import com.example.ForumServer.pojo.posts.Post;
import com.example.ForumServer.pojo.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where user_id = #{user_id};")
    List<User> getUserById(@Param("user_id") String user_id);

    @Select("Select * from user where user_email = #{user_email};")
    List<User> getUserByEmail(@Param("user_email") String user_email);

    @Select("select * from user;")
    List<User> getAll();

    @Insert("insert into user (user_name, user_email, user_password) values (#{user_name}, #{user_email}, #{user_password})")
    int insert(User user);

    @Delete("")
    Post delete(int id);


    int update(User user);
}
