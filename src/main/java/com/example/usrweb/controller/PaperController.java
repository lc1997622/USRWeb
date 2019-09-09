/**
 * @filename:PaperController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.config.ResponseFormat;
import com.example.usrweb.entity.Paper;
import com.example.usrweb.service.PaperService;
import com.example.usrweb.service.UserService;
import com.example.usrweb.service.impl.PaperServiceImpl;
import com.example.usrweb.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 论文API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "论文",value="论文" )
@RestController
@RequestMapping("/paper")
public class PaperController extends AbstractController<PaperService,Paper>{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PaperServiceImpl paperService;
	@Autowired
	UserServiceImpl userService;

	@ApiOperation(value = "导入论文", notes = "作者：ZhuDengji")
	@GetMapping("/importPaper")
	@DS("slave")
	public Object importPaper(@RequestParam @ApiParam(value = "文件") MultipartFile multipartFile){
		String result = null;
		String parentPath = "E:/学习/软件工程专业实训/project/USRWeb/src/main/resources/static/images/paper";
		try {
			if (userService.uploadFile(multipartFile, parentPath)){
				result = paperService.importPaper(multipartFile);
			}
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);
		}
		return ResponseFormat.retParam(200, result);
	}
	
}