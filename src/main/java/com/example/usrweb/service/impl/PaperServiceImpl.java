/**
 * @filename:PaperServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.csvreader.CsvReader;
import com.example.usrweb.entity.Paper;
import com.example.usrweb.dao.PaperDao;
import com.example.usrweb.service.PaperService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 论文服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class PaperServiceImpl  extends ServiceImpl<PaperDao, Paper> implements PaperService  {

    @Autowired
    PaperDao paperDao;

    public String importPaper(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String parentPath = "E:/浏览器下载/document";
        String excelPath = parentPath + "/" + fileName;
        // 创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        if (fileName.endsWith("xls")){
            workbook = new HSSFWorkbook(multipartFile.getInputStream());
        }else if (fileName.endsWith("xlsx")){
            workbook = new XSSFWorkbook(multipartFile.getInputStream());
        }else {
            // 第一参数：文件路径 第二个参数：分隔符 第三个参数：字符集
            CsvReader csvReader = new CsvReader(excelPath, ',', Charset.forName("UTF-8"));
            // 过滤表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                Paper paper = new Paper();
                String title = csvReader.get(2);

                paper.setTitle(title);
                paperDao.insert(paper);
            }
        }
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        if (rows == 0){
            return "no data in document";
        }
        for (int i = 0; i <= rows; i++) {
            Paper paper = new Paper();
            Row row = sheet.getRow(i);
            if (row != null){
                String title = row.getCell(2).toString();

                paper.setTitle(title);
                paperDao.insert(paper);
            }
        }

        return "success";
    }
}