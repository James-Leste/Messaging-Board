package com.example.ForumServer.mapper;

import com.example.ForumServer.pojo.posts.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select * from user where user_id = #{user_id};")
    List<Post> findPostByUser(@Param("user_id") String user_id);

    @Select("select * from post;")
    List<Post> findAllPosts();

    @Insert("insert into post (user_id, content_mark, content_rend) values (#{user_id}, #{content_mark}, #{content_rend})")
    int insert(Post post);
}
