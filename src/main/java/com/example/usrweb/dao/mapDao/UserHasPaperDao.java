/**
 * @filename:UserHasPaperDao 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.dao.mapDao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.usrweb.entity.mapEntiry.UserHasPaper;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户论文关联数据访问层</p>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Mapper
public interface UserHasPaperDao extends BaseMapper<UserHasPaper> {
	
}
