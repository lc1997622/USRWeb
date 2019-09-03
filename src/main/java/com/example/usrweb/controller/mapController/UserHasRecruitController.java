/**
 * @filename:UserHasRecruitController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller.mapController;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.mapEntiry.UserHasRecruit;
import com.example.usrweb.service.mapService.UserHasRecruitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户招生信息关联API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "用户招生信息关联",value="用户招生信息关联" )
@RestController
@RequestMapping("/userHasRecruit")
public class UserHasRecruitController extends AbstractController<UserHasRecruitService,UserHasRecruit>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}