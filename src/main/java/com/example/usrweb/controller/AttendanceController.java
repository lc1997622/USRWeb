/**
 * @filename:AttendanceController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.config.ResponseFormat;
import com.example.usrweb.entity.Attendance;
import com.example.usrweb.service.AttendanceService;
import com.example.usrweb.service.impl.AttendanceServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 签到API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "签到",value="签到" )
@RestController
@RequestMapping("/attendance")
public class AttendanceController extends AbstractController<AttendanceService,Attendance>{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AttendanceServiceImpl attendanceService;

	@ApiOperation(value = "分页查询签到带参数", notes = "作者：SuPeisen")
	@PostMapping("/selectPageWP")
	public Object selectPageWP(Attendance attendance, @RequestParam(required = false) @ApiParam(value = "页数") Integer pageNum, @RequestParam(required = false) @ApiParam(value = "每页大小") Integer pageSize){
		List<Attendance> attendanceList;
		try {
			attendanceList = attendanceService.selectPageWP(attendance, pageNum, pageSize);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200, attendanceList);
	}
}