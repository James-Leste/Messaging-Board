package com.example.ForumServer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;

public class JwtUtils {
    //expire time
    private static long expire = 604800;

    private static long key;

    //生成Java Web Token
    public static String genToken(String user_id, String sign){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, 2);
        return JWT.create().withAudience(user_id)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(sign));
    }
}
