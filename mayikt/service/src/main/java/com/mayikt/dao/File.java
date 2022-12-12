package com.mayikt.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("table_file")
public class File {
    /**
     * 文件id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文件名称名称
     */
    private String fileName;
    /**
     * 文件大小
     */
    private Integer size;
    /**
     * 路径
     */
    private String path;
}
