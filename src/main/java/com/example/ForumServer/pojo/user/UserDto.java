package com.example.ForumServer.pojo.user;

import lombok.Data;

@Data
public class UserDto {
    String user_email;
    String user_password;
    String user_avatar;
    String user_name;
    String token;
}
