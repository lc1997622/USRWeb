/**
 * @filename:User 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.entity;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.usrweb.aid.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends AbstractEntity<User> {

	private static final long serialVersionUID = 1567498643171L;

	@ApiModelProperty(name = "userId" , value = "用户id，10位")
	private String userId;

	@ApiModelProperty(name = "password" , value = "密码，20位以内")
	private String password;

	@ApiModelProperty(name = "userFlag" , value = "0：管理员，1：学生，2：老师，3：办公室主任，4：资料管理员")
	private Integer userFlag;

	@ApiModelProperty(name = "borrowTimes" , value = "借阅次数，默认为0，系统限制为2")
	private Integer borrowTimes;

}
