package com.example.ForumServer.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.ForumServer.Common.Constants;
import com.example.ForumServer.Exceptions.ServiceException;
import com.example.ForumServer.pojo.user.User;
import com.example.ForumServer.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    /**
     * @description
     * @param request 请求
     * @param response 响应体
     * @param handler 映射的方法
     * @return 是否放行
     * @throws Exception token 解析失败异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的token
        String token = request.getHeader("token");
        //如果不是映射到方法则直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //执行认证
        //判断token是否为空字符串
        if(token.isBlank()){
            throw new ServiceException(Constants.code_401, "获取token失败");
        }
        //判断当前用户id是否和解码后对应
        String user_id;
        try{
            user_id = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j){
            throw new ServiceException(Constants.code_401, "token验证失败");
        }
        //判断通过id能否获取到用户信息
        User user = userService.getUserById(user_id);
        System.out.println("\n用户进行了一次操作."+user.toString());
        if(user == null){
            throw new ServiceException(Constants.code_401, "用户不存在, 请重新获取token");
        }
        //用户邮箱加签验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUser_create_time().toString())).build();
        try{
            jwtVerifier.verify(token);
        }catch (JWTVerificationException jv){
            throw new ServiceException(Constants.code_401, "token 验证失败");
        }
        return true;
    }
}
