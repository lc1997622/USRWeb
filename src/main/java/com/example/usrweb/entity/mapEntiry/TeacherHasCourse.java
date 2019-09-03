/**
 * @filename:TeacherHasCourse 2019年9月1日
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
 * <p>说明： 老师课程关联实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TeacherHasCourse extends Model<TeacherHasCourse> {

	private static final long serialVersionUID = 1567498746894L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "id")
	private Integer id;
	@ApiModelProperty(name = "teacherId" , value = "教师工号")
	private String teacherId;
	@ApiModelProperty(name = "courseId" , value = "课程编号")
	private String courseId;
	@ApiModelProperty(name = "creator" , value = "创建者")
	private String creator;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "createTime" , value = "创建时间")
	private Date createTime;
	@ApiModelProperty(name = "modifier" , value = "修改者")
	private String modifier;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "modifyTime" , value = "修改时间")
	private Date modifyTime;
	@ApiModelProperty(name = "deleteFlag" , value = "删除标记，默认为0。0：未删除，1：已删除")
	private Integer deleteFlag;
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
