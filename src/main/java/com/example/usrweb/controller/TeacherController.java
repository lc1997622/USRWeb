/**
 * @filename:TeacherController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.config.ResponseFormat;
import com.example.usrweb.entity.Teacher;
import com.example.usrweb.service.TeacherService;
import com.example.usrweb.service.impl.TeacherServiceImpl;
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
 * <p>说明： 教师API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "教师",value="教师" )
@RestController
@RequestMapping("/teacher")
public class TeacherController extends AbstractController<TeacherService,Teacher>{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TeacherServiceImpl teacherService;
	@Autowired
	UserServiceImpl userService;

	@GetMapping("/getTeacherInfo")
	@DS("slave")
	public Object getTeacherInfo(){
		List<Teacher> teacherList;
		try{
			teacherList = teacherService.getTeacherInfo();
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,teacherList);
	}

	@ApiOperation(value = "插入老师记录", notes = "作者：ZhuDengji")
	@PostMapping("/insertTeacher")
	public Object insertTeacher(Teacher teacher){
		Integer i;
		try {
			i = teacherService.insertTeacher(teacher);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,i);
	}

	@ApiOperation(value = "更改老师记录", notes = "作者：ZhuDengji")
	@PostMapping("/updateTeacher")
	@DS("slave")
	public Object updateTeacher(Teacher teacher){
		Teacher teacher1;
		try {
			teacher1 = teacherService.updateTeacher(teacher);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,teacher1);
	}

	@ApiOperation(value = "根据id查询老师信息", notes = "作者：ZhuDengji")
	@GetMapping("/getTeacherById")
	@DS("slave")
	public Object getTeacherById(@RequestParam @ApiParam(value = "老师id") Long id){
		Teacher teacher;
		try {
			teacher = teacherService.getTeacherById(id);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200,teacher);
	}

	@ApiOperation(value = "上传图片", notes = "作者：ZhuDengji")
	@PostMapping("/uploadImage")
	@DS("slave")
	public Object uploadImage(@RequestParam("data") @ApiParam(value = "图片") MultipartFile multipartFile){
		boolean result;
		String parentPath = "E:/学习/软件工程专业实训/project/USRWeb/src/main/resources/static/images/teacher";
		try {
			result = userService.uploadFile(multipartFile, parentPath);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000, null);
		}
		return ResponseFormat.retParam(200, result);
	}

    @ApiOperation(value = "根据id删除老师信息", notes = "作者：ZhuDengji")
    @PostMapping("/deleteTeacherById")
    @DS("slave")
    public Object deleteTeacherById(@RequestParam @ApiParam(value = "老师id") Long id){
        Integer i;
        try {
            i = teacherService.deleteTeacherById(id);
        }catch (Exception e){
            System.out.println(e);
            return ResponseFormat.retParam(1000, null);
        }
        return ResponseFormat.retParam(200, i);
    }
}