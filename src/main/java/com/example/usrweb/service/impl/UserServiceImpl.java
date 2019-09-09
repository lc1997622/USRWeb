/**
 * @filename:UserServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.example.usrweb.entity.User;
import com.example.usrweb.dao.UserDao;
import com.example.usrweb.service.UserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Field;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 用户服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserDao, User> implements UserService  {

    public boolean uploadExcel(MultipartFile multipartFile) throws Exception{
        if (multipartFile.isEmpty()){
            return false;
        }
        // 得到文件在客户机的文件名
        String fileName = multipartFile.getOriginalFilename();
        String parentPath = "E:/学习/软件工程专业实训/project/USRWeb/src/main/resources/static/images/news";
        String excelPath = parentPath + "/" + fileName;
        File file = new File(excelPath);
        // 文件父目录
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        // 转存文件，把MultipartFile转换成File
        multipartFile.transferTo(file);
        return true;
    }
}