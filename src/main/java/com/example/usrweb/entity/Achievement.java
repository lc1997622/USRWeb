/**
 * @filename:Achievement 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 成果实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Achievement extends Model<Achievement> {

	private static final long serialVersionUID = 1567498641733L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "成果id")
	private Integer id;
	@ApiModelProperty(name = "achievementFlag" , value = "0：教学，1：科研")
	private Integer achievementFlag;
	@ApiModelProperty(name = "name" , value = "成果名")
	private String name;
	@ApiModelProperty(name = "type" , value = "层级。0：校级，1：省级，2：国家级")
	private Integer type;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "year" , value = "发表年份")
	private Date year;
	@ApiModelProperty(required = false, hidden = true)
	private String creator;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(required = false, hidden = true)
	private Date createTime;
	@ApiModelProperty(required = false, hidden = true)
	private String modifier;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(required = false, hidden = true)
	private Date modifyTime;
	@ApiModelProperty(required = false, hidden = true)
	private Integer deleteFlag;
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
