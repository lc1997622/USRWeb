/**
 * @filename:Paper 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * <p>说明： 论文实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Paper extends Model<Paper> {

	private static final long serialVersionUID = 1567339186333L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "论文id")
	private Integer id;
	@ApiModelProperty(name = "paperFlag" , value = "0：教学，1：科研")
	private Integer paperFlag;
	@ApiModelProperty(name = "type" , value = "论文类型。0：期刊，1：会议")
	private Integer type;
	@ApiModelProperty(name = "title" , value = "论文标题")
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "year" , value = "发表年份")
	private Date year;
	@ApiModelProperty(name = "journal" , value = "期刊/会议名称")
	private String journal;
	@ApiModelProperty(name = "number" , value = "刊号")
	private String number;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@ApiModelProperty(name = "date" , value = "会议时间")
	private Date date;
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
