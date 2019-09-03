/**
 * @filename:CourseHasStudent 2019年9月1日
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
 * <p>说明： 学生课程关联实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseHasStudent extends Model<CourseHasStudent> {

	private static final long serialVersionUID = 1567498746040L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "id")
	private Integer id;
	@ApiModelProperty(name = "studentId" , value = "学生学号")
	private String studentId;
	@ApiModelProperty(name = "courseId" , value = "课程编号")
	private String courseId;
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
