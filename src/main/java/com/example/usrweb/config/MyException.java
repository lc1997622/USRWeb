package com.example.usrweb.config;

import lombok.Data;

/**
 * @author ：LiChao
 * @date ：Created in 2019/9/3 19:09
 * @description：对于 RuntimeException 异常才会进行事务回滚
 * @modified By：
 * @version: 1.0$
 */
@Data
public class MyException extends RuntimeException {

    private Integer code;
    private Exception exception;

    public MyException(Integer code,Exception exception){
        this.code = code;
        this.exception = exception;
    }
}
