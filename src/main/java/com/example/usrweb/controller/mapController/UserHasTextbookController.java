/**
 * @filename:UserHasTextbookController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller.mapController;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.mapEntiry.UserHasTextbook;
import com.example.usrweb.service.mapService.UserHasTextbookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户教材管理API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "用户教材管理",value="用户教材管理" )
@RestController
@RequestMapping("/userHasTextbook")
public class UserHasTextbookController extends AbstractController<UserHasTextbookService,UserHasTextbook>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}