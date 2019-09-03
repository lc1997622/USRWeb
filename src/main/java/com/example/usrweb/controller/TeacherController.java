/**
 * @filename:TeacherController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.Teacher;
import com.example.usrweb.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
}