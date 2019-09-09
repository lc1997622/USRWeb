/**
 * @filename:StudentController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.config.ResponseFormat;
import com.example.usrweb.entity.Student;
import com.example.usrweb.service.StudentService;
import com.example.usrweb.service.impl.StudentServiceImpl;
import com.example.usrweb.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 学生API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "学生",value="学生" )
@RestController
@RequestMapping("/student")
public class StudentController extends AbstractController<StudentService,Student>{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentServiceImpl studentService;
	@Autowired
	UserServiceImpl userService;

	@ApiOperation(value = "根据id查询学生信息", notes = "作者：ZhuDengji")
	@GetMapping("/getStudentById")
	@DS("slave")
	public Object getStudentById(@RequestParam @ApiParam(value = "学生id") Long id){
		Student student;
		try {
			student = studentService.getStudentById(id);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,student);
	}

	@ApiOperation(value = "插入学生记录", notes = "作者：ZhuDengji")
	@PostMapping("/insertStudent")
	public Object insertStudent(Student student){
		Integer i;
		try {
			i = studentService.insertStudent(student);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,i);
	}

	@ApiOperation(value = "更改学生记录", notes = "作者：ZhuDengji")
	@PostMapping("/updateStudent")
	@DS("slave")
	public Object updateStudent(Student student){
		Student student1;
		try {
			student1 = studentService.updateStudent(student);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,student1);
	}

	@ApiOperation(value = "分页查询学生带参数", notes = "作者：ZhuDengji")
	@PostMapping("/selectPageWP")
	@DS("slave")
	public Object selectPageWP(Student student, @RequestParam(required = false) @ApiParam(value = "页数") Integer pageNum, @RequestParam(required = false) @ApiParam(value = "每页大小") Integer pageSize){
		List<Student> studentList;
		try {
			studentList = studentService.selectPageWP(student, pageNum, pageSize);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200, studentList);
	}

	@ApiOperation(value = "导入学生信息", notes = "作者：ZhuDengji")
	@GetMapping("/importStudent")
	@DS("slave")
	public Object importStudent(@RequestParam @ApiParam(value = "文件") MultipartFile multipartFile){
		String result = null;
		String parentPath = "E:/学习/软件工程专业实训/project/USRWeb/src/main/resources/static/images/excel";
		try {
			if (userService.uploadFile(multipartFile, parentPath)){
				result = studentService.importStudent(multipartFile);
			}
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200, result);
	}

	@ApiOperation(value = "根据学号查询学生信息", notes = "作者：SuPeisen")
	@GetMapping("/getStudentByXuehao")
	public Object getStudentByXuehao(@RequestParam @ApiParam(value = "学生学号") String studentID){
		Student student;
		try {
			student = studentService.getStudentByXuehao(studentID);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,student);
	}

	@ApiOperation(value = "上传图片", notes = "作者：ZhuDengji")
	@PostMapping("/uploadImage")
	@DS("slave")
	public Object uploadImage(@RequestParam("data") @ApiParam(value = "图片") MultipartFile multipartFile){
		boolean result;
		String parentPath = "E:/学习/软件工程专业实训/project/USRWeb/src/main/resources/static/images/student";
		try {
			result = userService.uploadFile(multipartFile, parentPath);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000, null);
		}
		return ResponseFormat.retParam(200, result);
	}
}