package com.example.ForumServer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;

public class JwtUtils {
    /**
     * @description generate token based on user's information
     * @param user_id user's id
     * @param sign user's String(password, email...)
     * @return token
     */
    public static String genToken(String user_id, String sign){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, 24);
        return JWT.create().withAudience(user_id) //用户ID作为载荷
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(sign)); //用户的一个字段作为载荷
    }
}
