/**
 * @filename:Recruit 2019年9月1日
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
 * <p>说明： 招生信息实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Recruit extends Model<Recruit> {

	private static final long serialVersionUID = 1567339186433L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "招生信息id")
	private Integer id;
	@ApiModelProperty(name = "type" , value = "0：本科生，1：硕士生，2：博士生，3：留学生")
	private Integer type;
	@ApiModelProperty(name = "requirement" , value = "500字以内")
	private String requirement;
	@ApiModelProperty(name = "workTime" , value = "工作时间（100字以内）")
	private String workTime;
	@ApiModelProperty(name = "others" , value = "其他要求，500字以内")
	private String others;
	@ApiModelProperty(name = "contact" , value = "联系人")
	private String contact;
	@ApiModelProperty(name = "contactWay" , value = "联系方式")
	private String contactWay;
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
