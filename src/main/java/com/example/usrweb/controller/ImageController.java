/**
 * @filename:ImageController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.entity.Image;
import com.example.usrweb.service.ImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 图片API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "图片",value="图片" )
@RestController
@RequestMapping("/image")
public class ImageController extends AbstractController<ImageService,Image>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}