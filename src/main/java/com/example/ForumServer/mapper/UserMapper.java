package com.example.ForumServer.mapper;


import com.example.ForumServer.pojo.posts.Post;
import com.example.ForumServer.pojo.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id};")
    List<User> getUserById(@Param("id") String id);

    @Select("Select * from user where user_email = #{user_email};")
    List<User> getUserByEmail(@Param("user_email") String user_email);

    @Select("select * from user;")
    List<User> getAll();

    @Select("select * from user limit #{start}, #{pageSize}")
    List<User> getUsersByPage(@Param("start") int start, @Param("pageSize") int pageSize);

    @Select("select count(*) from user")
    int count();

    //@Insert("insert into user (user_name, user_email, user_password) values (#{user_name}, #{user_email}, #{user_password});")
    int insert(User user);

    @Delete("Delete from user where id = #{id};")
    int delete(@Param("id") int id);


    int update(User user);
}
