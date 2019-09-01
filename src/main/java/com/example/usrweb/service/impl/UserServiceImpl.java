/**
 * @filename:UserServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.example.usrweb.entity.User;
import com.example.usrweb.dao.UserDao;
import com.example.usrweb.service.UserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 用户服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserDao, User> implements UserService  {
	
}