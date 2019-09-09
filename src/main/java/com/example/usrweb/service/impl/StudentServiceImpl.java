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
import com.csvreader.CsvReader;
import com.example.usrweb.dao.ImageDao;
import com.example.usrweb.entity.Book;
import com.example.usrweb.entity.Image;
import com.example.usrweb.entity.Paper;
import com.example.usrweb.entity.Student;
import com.example.usrweb.dao.StudentDao;
import com.example.usrweb.service.StudentService;
import com.github.flying.cattle.mdg.aid.PageParam;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
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

    public Student getStudentById(Long id){

        Student student = studentDao.selectById(id);
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

    public String importStudent(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String parentPath = "E:/浏览器下载/document";
        String excelPath = parentPath + "/" + fileName;
        // 创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;



        if (fileName.endsWith("xls")){
            workbook = new HSSFWorkbook(multipartFile.getInputStream());
        }else if (fileName.endsWith("xlsx")){
            workbook = new XSSFWorkbook(multipartFile.getInputStream());
        }else {
            // 第一参数：文件路径 第二个参数：分隔符 第三个参数：字符集
            CsvReader csvReader = new CsvReader(excelPath, ',', Charset.forName("UTF-8"));
            // 过滤表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                Student student = new Student();
                String id = csvReader.get(1);
                student.setStudentId(id);
                String name = csvReader.get(2);

                student.setChineseName(name);



                studentDao.insert(student);
            }
        }
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        if (rows == 0){
            return "no data in document";
        }
        for (int i = 0; i <= rows; i++) {
            Student student = new Student();
            Row row = sheet.getRow(i);
            if (row != null){
                String title = row.getCell(2).toString();


                studentDao.insert(student);
            }
        }

        return "success";
    }

    public Student getStudentByXuehao(String studentID){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper.eq("student_id",studentID);
        Student student = studentDao.selectOne(queryWrapper);
        Long imgId = student.getImageId();
        String imgPath = imageDao.selectById(imgId).getPath();
        student.setImagePath(imgPath);

        return student;
    }
}