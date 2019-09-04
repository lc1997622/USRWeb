/**
 * @filename:BookController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.config.MsgType;
import com.example.usrweb.config.ResponseFormat;
import com.example.usrweb.dao.BookDao;
import com.example.usrweb.entity.Book;
import com.example.usrweb.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Max;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 图书API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "图书",value="图书" )
@RestController
@RequestMapping("/book")
public class BookController extends AbstractController<BookService,Book>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	BookDao bookDao;

	@PostMapping("/insertBook")
	@ApiOperation(value = "添加", notes = "作者：LiChao")
	public Object Insert(Book book){
		try {
			int rows = bookDao.insert(book);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000,null);

		}
	    return ResponseFormat.retParam(200,null);
	}
	
}