/**
 * @filename:DocumentServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.usrweb.dao.AttendanceDao;
import com.example.usrweb.entity.Attendance;
import com.example.usrweb.entity.Document;
import com.example.usrweb.dao.DocumentDao;
import com.example.usrweb.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 资料服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class DocumentServiceImpl  extends ServiceImpl<DocumentDao, Document> implements DocumentService  {
    @Autowired
    DocumentDao documentDao;

    public List<Document> selectPageWP(Document document, Integer pageNum, Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        QueryWrapper<Document> queryWrapper = new QueryWrapper<Document>();
        Page<Document> page = new Page<>(pageNum, pageSize);
        List<Document> documentList;
        queryWrapper.setEntity(document);
        IPage<Document> iPage = documentDao.selectPage(page, queryWrapper);
        documentList = iPage.getRecords();
        documentList.forEach(System.out::println);

        return documentList;
    }
}