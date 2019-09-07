/**
 * @filename:UserHasHandbook 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.entity.mapEntiry;
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
 * <p>说明： 用户手册关联实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserHasHandbook extends Model<UserHasHandbook> {

	private static final long serialVersionUID = 1567821403461L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "id")
	private Long id;
	@ApiModelProperty(name = "userId" , value = "用户id")
	private String userId;
	@ApiModelProperty(name = "handbookId" , value = "手册id")
	private Integer handbookId;
	@ApiModelProperty(name = "creator" , value = "")
	private String creator;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "createTime" , value = "")
	private Date createTime;
	@ApiModelProperty(name = "modifier" , value = "")
	private String modifier;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "modifyTime" , value = "")
	private Date modifyTime;
	@ApiModelProperty(name = "deleteFlag" , value = "")
	private Integer deleteFlag;
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
