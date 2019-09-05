/**
 * @filename:Course 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * <p>说明： 课程实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Course extends AbstractEntity<Course> {

	private static final long serialVersionUID = 1567498642646L;

	@ApiModelProperty(name = "courseId" , value = "课程编号")
	private String courseId;
	@ApiModelProperty(name = "name" , value = "课程名")
	private String name;
	@ApiModelProperty(name = "type" , value = "课程性质。1：必修，0：选修")
	private Integer type;
	@ApiModelProperty(name = "studentType" , value = "学生性质。0：本科生，1：硕士研究生，2：博士研究生")
	private Integer studentType;
	@ApiModelProperty(name = "courseTime" , value = "上课时间（100字符以内）")
	private String courseTime;
	@ApiModelProperty(name = "comment" , value = "备注（100字符以内）")
	private String comment;
	@ApiModelProperty(required = false, hidden = true)
	private String coursecol;
}
