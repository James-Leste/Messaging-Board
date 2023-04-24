package com.example.ForumServer.mapper;

import com.example.ForumServer.pojo.posts.Post;


import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;


@Mapper
public interface PostMapper {

    @Select("select * from user where post_id = #{post_id};")
    List<Post> get(@Param("post_id") String post_id);

    @Select("select * from post;")
    List<Post> getAll();

    @Insert("insert into post (user_id, title, content_mark) values (#{user_id}, #{title}, #{content_mark})")
    int insert(Post post);

    int update(Post post);

    @Select("select * from post limit #{start}, #{pageSize}")
    List<Post> getPostsByPage(@Param("start") int start, @Param("pageSize") int pageSize);

    @Select("Select * from post where post_id = #{post_id}")
    List<Post> getPostsById(@Param("post_id")BigInteger post_id);

    @Select("select count(*) from post")
    int count();

    @Delete("")
    Post delete(int id);
}
