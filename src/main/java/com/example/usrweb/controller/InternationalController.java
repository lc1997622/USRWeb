/**
 * @filename:InternationalController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.International;
import com.example.usrweb.service.InternationalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 国际交流信息API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "国际交流信息",value="国际交流信息" )
@RestController
@RequestMapping("/international")
public class InternationalController extends AbstractController<InternationalService,International>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}