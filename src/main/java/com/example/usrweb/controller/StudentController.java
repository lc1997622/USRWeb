/**
 * @filename:StudentController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.config.ResponseFormat;
import com.example.usrweb.entity.Student;
import com.example.usrweb.service.StudentService;
import com.example.usrweb.service.impl.StudentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	@ApiOperation(value = "根据id查询学生信息", notes = "作者：ZhuDengji")
	@GetMapping("/getStudentById")
	public Object getStudentById(@RequestParam @ApiParam(value = "学生Id") Long id){
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
		try {
			Integer i = studentService.insertStudent(student);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,null);
	}

	@ApiOperation(value = "分页查询学生带参数", notes = "作者：ZhuDengji")
	@PostMapping("/selectPageWP")
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
}