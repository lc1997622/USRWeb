/**
 * @filename:Project 2019年9月1日
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
 * <p>说明： 项目实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Project extends Model<Project> {

	private static final long serialVersionUID = 1567339186072L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "科研项目id")
	private Integer id;
	@ApiModelProperty(name = "name" , value = "项目名")
	private String name;
	@ApiModelProperty(name = "type" , value = "项目性质，需求中未具体说明")
	private Integer type;
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}