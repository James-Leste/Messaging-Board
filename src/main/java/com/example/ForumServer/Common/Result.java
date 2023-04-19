package com.example.ForumServer.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String message;
    private Object data;

    public static Result success(){
        return new Result(Constants.code_200, "", null);
    }

    public static Result success(Object object){
        return new Result(Constants.code_200, "", object);
    }

    public static Result success(String message, Object object){
        return new Result(Constants.code_200, message, object);
    }

    public static Result error(String code, String msg){return new Result(code, msg, false);}

    public static Result systemError(){
        return new Result(Constants.code_500, "系统错误", null);
    }

    public static Result paraError(){
        return new Result(Constants.code_400, "参数错误", null);
    }
}
