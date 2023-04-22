package com.example.ForumServer.pojo.user;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserDto {
    BigInteger id;
    String user_email;
    String user_password;
    String user_avatar;
    String user_name;
    String user_bio;
    String token;
}
