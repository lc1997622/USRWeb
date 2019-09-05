package com.example.usrweb.compotent;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ：LiChao
 * @date ：Created in 2019/9/3 23:08
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject){
        boolean hasSetter = metaObject.hasSetter("createTime");
        if (hasSetter){
            setInsertFieldValByName("createTime", new Date(),metaObject);
        }
    }
    @Override
    public void updateFill(MetaObject metaObject){
        Object val = getFieldValByName("updateTime",metaObject);
        if (val == null){
            this.setUpdateFieldValByName("updateTime",new Date(),metaObject);
        }
    }
}
