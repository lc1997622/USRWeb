/**
 * @filename:BorrowServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.usrweb.entity.Borrow;
import com.example.usrweb.dao.BorrowDao;
import com.example.usrweb.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 借阅服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class BorrowServiceImpl  extends ServiceImpl<BorrowDao, Borrow> implements BorrowService  {

    @Autowired
    BorrowDao borrowDao;

    public List<Borrow> selectPageWP(String studentID, Integer pageNum, Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        QueryWrapper<Borrow> queryWrapper = new QueryWrapper<Borrow>();
        Page<Borrow> page = new Page<>(pageNum, pageSize);
        List<Borrow> borrowList;
//        queryWrapper.setEntity(student);
        queryWrapper.eq("user_id",studentID).ne("flag","1");
        IPage<Borrow> iPage = borrowDao.selectPage(page, queryWrapper);
        borrowList = iPage.getRecords();
        borrowList.forEach(System.out::println);

        return borrowList;
    }
}