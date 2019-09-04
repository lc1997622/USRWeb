/**
 * @filename:Student 2019年9月1日
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
 * <p>说明： 学生实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Student extends AbstractEntity<Student> {

	private static final long serialVersionUID = 1567498641837L;

	@ApiModelProperty(name = "studentId" , value = "学生学号，10位")
	private String studentId;
	@ApiModelProperty(name = "level" , value = "学号第1位，学生层次。1：本科，2：硕士，3：博士")
	private Integer level;
	@ApiModelProperty(name = "training" , value = "学号第2位，培养类别。1：学术，2：专业，3：交换生，8：留学生")
	private String training;
	@ApiModelProperty(name = "chineseName" , value = "中文名")
	private String chineseName;
	@ApiModelProperty(name = "englishFirstname" , value = "中国学生填汉语拼音")
	private String englishFirstname;
	@ApiModelProperty(name = "englishLastname" , value = "中国学生填汉语拼音")
	private String englishLastname;
	@ApiModelProperty(name = "sex" , value = "1：男，0：女")
	private Integer sex;
	@ApiModelProperty(name = "type" , value = "学生类别。0：本科，1：学术硕士，2：专业硕士，3：学术博士，4：专业硕士")
	private Integer type;
	@ApiModelProperty(name = "nationality" , value = "国籍")
	private String nationality;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@ApiModelProperty(name = "enrollmentTime" , value = "入学时间。系统只需要年月，日期默认为1号")
	private Date enrollmentTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@ApiModelProperty(name = "graduationTime" , value = "毕业时间。系统只需要年月，日期默认为1号")
	private Date graduationTime;
	@ApiModelProperty(name = "tutor" , value = "导师")
	private String tutor;
	@ApiModelProperty(name = "viceTutor" , value = "副导师")
	private String viceTutor;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@ApiModelProperty(name = "birthday" , value = "生日")
	private Date birthday;
	@ApiModelProperty(name = "email" , value = "邮箱")
	private String email;
	@ApiModelProperty(name = "mobliePhone" , value = "手机电话，11位。考虑到后期扩展，建议添加国家代码并考虑到各国移动电话的不同编码方式")
	private String mobliePhone;
	@ApiModelProperty(name = "comment" , value = "备注（100字符以内）")
	private String comment;
	@ApiModelProperty(name = "imageId" , value = "照片，2M限制")
	private Integer imageId;
	@ApiModelProperty(name = "graduationFlag" , value = "0：未毕业，1：毕业")
	private Integer graduationFlag;
	@ApiModelProperty(name = "credit" , value = "未按时还书的次数，默认为0")
	private Integer credit;
	@ApiModelProperty(name = "firstCompany" , value = "初次就业单位")
	private String firstCompany;
}
