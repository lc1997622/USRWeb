/**
 * @filename:TeacherServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.usrweb.dao.ImageDao;
import com.example.usrweb.entity.Image;
import com.example.usrweb.entity.Student;
import com.example.usrweb.entity.Teacher;
import com.example.usrweb.dao.TeacherDao;
import com.example.usrweb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 教师服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class TeacherServiceImpl  extends ServiceImpl<TeacherDao, Teacher> implements TeacherService  {

    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ImageDao imageDao;

    public List<Teacher> getTeacherInfo(){
        QueryWrapper<Teacher> teacherQueryWrapper= new QueryWrapper<Teacher>();
        List<Teacher> teacherList = teacherDao.selectList(teacherQueryWrapper);
        for (Teacher teacher:teacherList){
            Long imgId = teacher.getImageId();
            String imgPath = imageDao.selectById(imgId).getPath();
            teacher.setImagePath(imgPath);
        }
        return teacherList;
    }

    public Integer insertTeacher(Teacher teacher){
        Image image = new Image();
        image.setPath(teacher.getImagePath());
        imageDao.insert(image);
        Long imagId = image.getId();
        teacher.setImageId(imagId);
        teacherDao.insert(teacher);
        return 1;
    }

    public Teacher updateTeacher(Teacher teacher){
        Image image = imageDao.selectById(teacher.getImageId());
        if (image.getPath() != teacher.getImagePath()){
            Image image1 = new Image();
            image1.setPath(teacher.getImagePath());
            imageDao.insert(image1);
            teacher.setImageId(image1.getId());
        }
        teacherDao.updateById(teacher);
        return teacher;
    }

    public Teacher getTeacherById(Long id){
        Teacher teacher = teacherDao.selectById(id);
        Image image = imageDao.selectById(teacher.getImageId());
        teacher.setImagePath(image.getPath());
        return teacher;
    }
}