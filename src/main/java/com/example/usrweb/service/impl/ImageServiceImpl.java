/**
 * @filename:ImageServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.example.usrweb.entity.Image;
import com.example.usrweb.dao.ImageDao;
import com.example.usrweb.service.ImageService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 图片服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class ImageServiceImpl  extends ServiceImpl<ImageDao, Image> implements ImageService  {


}