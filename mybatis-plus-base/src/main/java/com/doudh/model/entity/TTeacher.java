package com.doudh.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * @desc 
 * @author doudh
 * @time 2019-07-11
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_teacher")
@ApiModel(value="TTeacher对象", description="")
public class TTeacher implements Serializable {


    private static final long serialVersionUID = 1L;

    @TableId("id")
    private long id;

    private String name;

    private Integer age;

    private String subject;

}
