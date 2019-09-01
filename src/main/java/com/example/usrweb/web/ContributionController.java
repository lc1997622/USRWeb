/**
 * @filename:ContributionController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.web;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.Contribution;
import com.example.usrweb.service.ContributionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 稿件API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "稿件",value="稿件" )
@RestController
@RequestMapping("/contribution")
public class ContributionController extends AbstractController<ContributionService,Contribution>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}