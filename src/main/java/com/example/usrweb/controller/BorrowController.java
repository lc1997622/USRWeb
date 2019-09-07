/**
 * @filename:BorrowController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.config.ResponseFormat;
import com.example.usrweb.entity.Borrow;
import com.example.usrweb.entity.Student;
import com.example.usrweb.service.BorrowService;
import com.example.usrweb.service.impl.BorrowServiceImpl;
import com.example.usrweb.service.impl.StudentServiceImpl;
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
 * <p>说明： 借阅API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "借阅",value="借阅" )
@RestController
@RequestMapping("/borrow")
public class BorrowController extends AbstractController<BorrowService,Borrow>{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BorrowServiceImpl borrowService;

	@ApiOperation(value = "分页查询学生带参数", notes = "作者：ZhuDengji")
	@PostMapping("/selectPageWP")
	public Object selectPageWP(String studentID, @RequestParam(required = false) @ApiParam(value = "页数") Integer pageNum, @RequestParam(required = false) @ApiParam(value = "每页大小") Integer pageSize){
		List<Borrow> borrowList;
		try {
			borrowList = borrowService.selectPageWP(studentID, pageNum, pageSize);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200, borrowList);
	}
}