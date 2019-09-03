/**
 * @filename:ProjectController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.Project;
import com.example.usrweb.service.ProjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 项目API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "项目",value="项目" )
@RestController
@RequestMapping("/project")
public class ProjectController extends AbstractController<ProjectService,Project>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}