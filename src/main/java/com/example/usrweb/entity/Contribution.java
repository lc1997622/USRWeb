/**
 * @filename:Contribution 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
import java.util.List;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 稿件实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Contribution extends AbstractEntity<Contribution> {

	private static final long serialVersionUID = 1567498642104L;

	@ApiModelProperty(name = "type" , value = "0：新闻动态，1：通知通告，2：学术活动")
	private Integer type;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "time" , value = "发稿时间")
	private Date time;
	@ApiModelProperty(name = "userId" , value = "用户id")
	private String userId;
	@ApiModelProperty(name = "userName" , value = "用户姓名")
	@TableField(exist = false)
	private String userName;
	@ApiModelProperty(name = "title" , value = "标题")
	private String title;
	@ApiModelProperty(name = "content" , value = "内容")
	private String content;
	@TableField(exist = false)
	private List<String> imagePathList;
}
