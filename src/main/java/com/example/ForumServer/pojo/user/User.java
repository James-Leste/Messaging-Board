package com.example.ForumServer.pojo.user;

import lombok.*;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Bean: User
 * Properties: id, username, email address
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private BigInteger id;
    @NonNull private String user_name;
    @NonNull private String user_email;
    private String user_avatar;
    @NonNull private String user_password;
    private Timestamp user_create_time;
    private Timestamp user_update_time;
    private Integer user_post_count;
    private Integer user_answer_count;
    private String user_bio;
}
