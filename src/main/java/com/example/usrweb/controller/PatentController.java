/**
 * @filename:PatentController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.Patent;
import com.example.usrweb.service.PatentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 专利API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "专利",value="专利" )
@RestController
@RequestMapping("/patent")
public class PatentController extends AbstractController<PatentService,Patent>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}