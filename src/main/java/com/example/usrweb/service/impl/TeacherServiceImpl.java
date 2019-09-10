/**
 * @filename:TeacherServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.usrweb.dao.ImageDao;
import com.example.usrweb.dao.UserDao;
import com.example.usrweb.entity.Image;
import com.example.usrweb.entity.Student;
import com.example.usrweb.entity.Teacher;
import com.example.usrweb.dao.TeacherDao;
import com.example.usrweb.entity.User;
import com.example.usrweb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.DigestUtils;

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
    @Autowired
    UserDao userDao;

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
        String imagePath = teacher.getImagePath();
        if (imagePath!=null){
            String parentPath = "../images/teacher";
            String [] path = imagePath.split("/");
            String path0 = parentPath + '/' + path[path.length-1];
            Image image = new Image();
            image.setPath(path0);
            imageDao.insert(image);
            Long imagId = image.getId();
            teacher.setImageId(imagId);
        }
        // user表
        String teacherId = teacher.getTeacherId();
        System.out.println("---------------------------------------------"+teacherId);
        User user = new User();
        user.setUserId(teacherId);
        user.setPassword(DigestUtils.md5DigestAsHex(teacherId.getBytes()));
        user.setUserFlag(teacher.getUserFlag());
        userDao.insert(user);
        teacherDao.insert(teacher);

        return 1;
    }

    public Teacher updateTeacher(Teacher teacher){
        // 更新图片表
        Image image = imageDao.selectById(teacher.getImageId());
        if (!image.getPath().equals(teacher.getImagePath())){
            Image image1 = new Image();
            image1.setPath(teacher.getImagePath());
            imageDao.insert(image1);
            teacher.setImageId(image1.getId());
        }
        // 更新用户表
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", teacher.getTeacherId());
        User user = userDao.selectOne(queryWrapper);
        user.setPassword(teacher.getPassword());
        user.setUserFlag(teacher.getUserFlag());
        user.setBorrowTimes(teacher.getBorrowTimes());
        user.setCredit(teacher.getCredit());
        userDao.updateById(user);

        teacherDao.updateById(teacher);
        return teacher;
    }

    public Teacher getTeacherById(Long id){
        Teacher teacher = teacherDao.selectById(id);
        Image image = imageDao.selectById(teacher.getImageId());
        teacher.setImagePath(image.getPath());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", teacher.getTeacherId());
        User user = userDao.selectOne(queryWrapper);
        teacher.setPassword(user.getPassword());
        teacher.setBorrowTimes(user.getBorrowTimes());
        teacher.setCredit(user.getCredit());
        teacher.setUserFlag(user.getUserFlag());

        return teacher;
    }

    public Integer deleteTeacherById(Long id){
        QueryWrapper<Teacher> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("teacher_id", id);
        Teacher teacher = teacherDao.selectOne(queryWrapper1);
        imageDao.deleteById(teacher.getImageId());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", teacher.getTeacherId());
        User user = userDao.selectOne(queryWrapper);
        userDao.deleteById(user);
        teacherDao.deleteById(teacher.getId());

        return 1;
    }
}