package com.example.ForumServer.pojo.posts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private BigInteger post_id;
    @NonNull private BigInteger user_id;
    @NonNull private String content_mark;
    @NonNull private String content_rend;
    private int comment_count;
    private int vote_up_count;
    private int vote_down_count;
    private Timestamp create_time;
    private Timestamp update_time;
}
