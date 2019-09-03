/**
 * @filename:CourseHasStudentController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller.mapController;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.mapEntiry.CourseHasStudent;
import com.example.usrweb.service.mapService.CourseHasStudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 学生课程关联API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "学生课程关联",value="学生课程关联" )
@RestController
@RequestMapping("/courseHasStudent")
public class CourseHasStudentController extends AbstractController<CourseHasStudentService,CourseHasStudent>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}