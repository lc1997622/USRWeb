/**
 * @filename:DocumentDao 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.usrweb.entity.Document;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 资料数据访问层</p>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Mapper
public interface DocumentDao extends BaseMapper<Document> {
	
}
