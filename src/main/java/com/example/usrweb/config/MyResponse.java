package com.example.usrweb.config;

import com.alibaba.fastjson.JSON;
import lombok.*;


import java.io.Serializable;
import java.util.Objects;

/**
 * @author ：LiChao
 * @date ：Created in 2019/9/3 18:35
 * @description：统一JSON返回类
 * @modified By：
 * @version: 1.0$
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyResponse implements Serializable {

    /**
     * 状态码
     */
    private int code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 业务数据
     */
    private Object datas;

    /**
     * 业务数据的处理
     */
    @Override
    public String toString(){
        if (Objects.isNull(this.datas)){
            this.setDatas(new Object());
        }
        return JSON.toJSONString(this);
    }
}
