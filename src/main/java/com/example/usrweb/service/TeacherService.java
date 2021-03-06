/**
 * @filename:TeacherService 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service;

import com.example.usrweb.dao.TeacherDao;
import com.example.usrweb.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 教师服务层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
public interface TeacherService extends IService<Teacher> {
    public List<Teacher> getTeacherInfo();
}