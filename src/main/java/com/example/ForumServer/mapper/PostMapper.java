package com.example.ForumServer.mapper;

import com.example.ForumServer.pojo.posts.Post;

import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface PostMapper {

    @Select("select * from user where post_id = #{post_id};")
    List<Post> get(@Param("post_id") String post_id);

    @Select("select * from post;")
    List<Post> getAll();

    @Insert("insert into post (user_id, content_mark, content_rend) values (#{user_id}, #{content_mark}, #{content_rend})")
    int insert(Post post);

    @Delete("")
    Post delete(int id);
}
