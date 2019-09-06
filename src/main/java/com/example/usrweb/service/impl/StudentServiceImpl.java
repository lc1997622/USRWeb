/**
 * @filename:StudentServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.usrweb.dao.ImageDao;
import com.example.usrweb.entity.Book;
import com.example.usrweb.entity.Image;
import com.example.usrweb.entity.Student;
import com.example.usrweb.dao.StudentDao;
import com.example.usrweb.service.StudentService;
import com.github.flying.cattle.mdg.aid.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 学生服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class StudentServiceImpl  extends ServiceImpl<StudentDao, Student> implements StudentService  {

    @Autowired
    StudentDao studentDao;
    @Autowired
    ImageDao imageDao;

    public Student getStudentById(String id){

        Student student=studentDao.selectById(id);
        Long imgId = student.getImageId();
        String imgPath = imageDao.selectById(imgId).getPath();
        student.setImagePath(imgPath);

        return student;
    }

    public Integer insertStudent(Student student){
        Image image = new Image();
        image.setPath(student.getImagePath());
        imageDao.insert(image);
        Long imagId = image.getId();
        student.setImageId(imagId);
        studentDao.insert(student);
        return 1;
    }

    public List<Student> selectPageWP(Student student, Integer pageNum, Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        Page<Student> page = new Page<>(pageNum, pageSize);
        List<Student> studentList;
        queryWrapper.setEntity(student);
        IPage<Student> iPage = studentDao.selectPage(page, queryWrapper);
        studentList = iPage.getRecords();
        studentList.forEach(System.out::println);

        return studentList;
    }
}