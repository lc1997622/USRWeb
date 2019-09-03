/**
 * @filename:UserHasDocumentController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller.mapController;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.mapEntiry.UserHasDocument;
import com.example.usrweb.service.mapService.UserHasDocumentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户资料关联API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "用户资料关联",value="用户资料关联" )
@RestController
@RequestMapping("/userHasDocument")
public class UserHasDocumentController extends AbstractController<UserHasDocumentService,UserHasDocument>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}