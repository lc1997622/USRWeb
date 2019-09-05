package com.example.usrweb.aid;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：LiChao
 * @date ：Created in 2019/9/4 13:47
 * @description：抽象实体接口
 * @modified By：
 * @version: 1$
 */
@Data
public class AbstractEntity<T> extends Model {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(name = "creator" , value = "创建者（新建时填充）")
    @TableField(fill = FieldFill.INSERT ,select = false)
    @JsonIgnore
    public String creator;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.INSERT,select = false)
    @JsonIgnore
    private Date createTime;

    @ApiModelProperty(name = "modifier" , value = "修改者（更新时填充）")
    @TableField(fill = FieldFill.UPDATE,select = false)
    @JsonIgnore
    private String modifier;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty( hidden = true)
    @TableField(fill = FieldFill.UPDATE,select = false)
    @JsonIgnore
    private Date modifyTime;

    @ApiModelProperty(hidden = true)
    @TableLogic
    @TableField(select = false)
    @JsonIgnore
    private Integer deleteFlag;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
