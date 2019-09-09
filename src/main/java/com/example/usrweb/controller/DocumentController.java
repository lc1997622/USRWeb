/**
 * @filename:DocumentController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.dao.DocumentDao;
import com.example.usrweb.entity.Document;
import com.example.usrweb.service.DocumentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 资料API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "资料",value="资料" )
@RestController
@RequestMapping("/document")

public class DocumentController extends AbstractController<DocumentService,Document>{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DocumentDao documentDao;

	@ApiOperation(value = "下载文件", notes = "作者：SuPeisen")
	@GetMapping("/download")
	public String downLoad(HttpServletResponse response, String filePath) throws UnsupportedEncodingException {
//		filePath = "D:/download" ;
		File file = new File(filePath);
		if(file.exists()){ //判断文件父目录是否存在

			String filename = file.getName();
			// 配置文件下载

			response.setHeader("content-type", "application/octet-stream");
			response.setContentType("application/octet-stream");
//			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//			response.setCharacterEncoding("UTF-8");
			// 下载文件能正常显示中文
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));


			byte[] buffer = new byte[1024];
			FileInputStream fis = null; //文件输入流
			BufferedInputStream bis = null;

			OutputStream os = null; //输出流
			try {
				os = response.getOutputStream();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				int i = bis.read(buffer);
				while(i != -1){
					os.write(buffer);
					i = bis.read(buffer);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("----------file download---" + filename);
			System.out.println("----------file download---" + filePath);
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@ApiOperation(value = "上传文件", notes = "作者：SuPeisen")
	@PostMapping("/fileUpload")
	public String fileUpload(@RequestParam("fileName") MultipartFile file, @RequestParam @ApiParam(value = "资料类型") Integer type){
		if(file.isEmpty()){
			return "false";
		}
		String fileName = file.getOriginalFilename();
		int size = (int) file.getSize();
		System.out.println(fileName + "-->" + size);

		String path = "/Users/apple/tempFIle";
		File dest = new File(path + "/" + fileName);
		if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest); //保存文件
			Document document = new Document();
			document.setPath(dest.getPath());
			document.setType(type);
			documentDao.insert(document);

			return "true";
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
	}
}