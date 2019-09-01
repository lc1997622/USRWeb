/**
 * @filename:BookServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.example.usrweb.entity.Book;
import com.example.usrweb.dao.BookDao;
import com.example.usrweb.service.BookService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 图书服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class BookServiceImpl  extends ServiceImpl<BookDao, Book> implements BookService  {
	
}