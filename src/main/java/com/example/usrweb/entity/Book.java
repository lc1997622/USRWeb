/**
 * @filename:Book 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.usrweb.aid.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * <p>说明： 图书实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Book extends AbstractEntity<Book> {

	private static final long serialVersionUID = 1567498641920L;

	@ApiModelProperty(name = "bookId" , value = "图书编号，7位数字")
	private String bookId;
	@ApiModelProperty(name = "name" , value = "书名")
	private String name;
	@ApiModelProperty(name = "author" , value = "作者")
	private String author;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@ApiModelProperty(name = "publicationYear" , value = "出版年份")
	private Date publicationYear;
	@ApiModelProperty(name = "location" , value = "存放地点")
	private String location;
	@ApiModelProperty(name = "borrowFlag" , value = "1：已被借出，0：未被借出")
	private Integer borrowFlag;
	@ApiModelProperty(name = "genreType" , value = "图书类型id，与字典类型表对应，默认为2")
	private Integer genreType;
	@ApiModelProperty(name = "genreItem" , value = "所属类别，与字典项目表对应")
	private Integer genreItem;
}
