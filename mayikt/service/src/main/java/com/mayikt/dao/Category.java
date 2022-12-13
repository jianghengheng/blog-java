package com.mayikt.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("category")
@ApiModel(value = "响应的VO对象",description = "封装接口返回给前端的数据")
public class Category implements Serializable {
    /**
     * 分类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类",dataType = "string")
    private String category;
    /**
     * 分类数量
     */
    private Integer num;
}
