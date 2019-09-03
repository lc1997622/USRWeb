/**
 * @filename:Teacher 2019年9月1日
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
 * <p>说明： 教师实体类</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teacher extends Model<Teacher> {

	private static final long serialVersionUID = 1567498642159L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "")
	private Integer id;
	@ApiModelProperty(name = "teacherId" , value = "老师工号。共10位，校内事业编制全职教师以61201开头；校内校聘非事业编制全职教师以72201开头；校内院聘非事业编制全职教师以74201开头；兼职教师没有工号")
	private String teacherId;
	@ApiModelProperty(name = "chineseName" , value = "中文名")
	private String chineseName;
	@ApiModelProperty(name = "englishFirstname" , value = "中国老师填汉语拼音")
	private String englishFirstname;
	@ApiModelProperty(name = "englishLastname" , value = "中国老师填汉语拼音")
	private String englishLastname;
	@ApiModelProperty(name = "sex" , value = "1：男，0：女")
	private Integer sex;
	@ApiModelProperty(name = "type" , value = "老师类型。1：专职，0：兼职")
	private Integer type;
	@ApiModelProperty(name = "nationality" , value = "国籍")
	private String nationality;
	@ApiModelProperty(name = "departmentType" , value = "单位类型id，与字典类型表对应，默认为1")
	private Integer departmentType;
	@ApiModelProperty(name = "departmentItem" , value = "所属单位（学院）,与字典项目表对应")
	private Integer departmentItem;
	@ApiModelProperty(name = "title" , value = "职称。4：正高，3：副高，2：中级，1：初级，0：无")
	private Integer title;
	@ApiModelProperty(name = "tutorQualification" , value = "导师资格。2：博导，1：硕导，0：无")
	private Integer tutorQualification;
	@ApiModelProperty(name = "labJob" , value = "实验室职务")
	private String labJob;
	@ApiModelProperty(name = "instituteJob" , value = "学院行政职务")
	private String instituteJob;
	@ApiModelProperty(name = "parttimeJob" , value = "兼职职务")
	private String parttimeJob;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@ApiModelProperty(name = "birthday" , value = "生日")
	private Date birthday;
	@ApiModelProperty(name = "email" , value = "邮箱")
	private String email;
	@ApiModelProperty(name = "mobliePhone" , value = "手机电话，11位。考虑到后期扩展，建议添加国家代码并考虑到各国移动电话的不同编码方式")
	private String mobliePhone;
	@ApiModelProperty(name = "officePhone" , value = "办公电话，3（区号）、8（号码），11位。考虑到后期扩展，建议添加国家代码并考虑到各国、各地区固定电话的不同编码方式")
	private String officePhone;
	@ApiModelProperty(name = "comment" , value = "备注（100字符以内）")
	private String comment;
	@ApiModelProperty(name = "imageId" , value = "照片，2M限制")
	private Integer imageId;
	@ApiModelProperty(name = "credit" , value = "未按时还书的次数，默认为0")
	private Integer credit;
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
