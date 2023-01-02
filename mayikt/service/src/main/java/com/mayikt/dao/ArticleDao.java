package com.mayikt.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("table_article")
public class ArticleDao implements Serializable {
    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文件id
     */
    private Integer fileId;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类id
     */
    private Integer categoryId;

    private  String creatTime;
}
