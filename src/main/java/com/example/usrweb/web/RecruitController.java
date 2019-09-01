/**
 * @filename:RecruitController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.web;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.Recruit;
import com.example.usrweb.service.RecruitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 招生信息API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "招生信息",value="招生信息" )
@RestController
@RequestMapping("/recruit")
public class RecruitController extends AbstractController<RecruitService,Recruit>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}