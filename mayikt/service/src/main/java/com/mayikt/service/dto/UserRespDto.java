package com.mayikt.service.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class UserRespDto {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */

    private Integer id;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登陆名称
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;
    /**
     * 最后登录时间
     */
    private LocalDateTime loginDate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 备注
     */
    private String remark;

    /**
     * 版本
     */
    private Integer version;
}
