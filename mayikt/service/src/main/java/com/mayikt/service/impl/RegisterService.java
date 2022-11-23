package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;

import com.mayikt.entity.utils.MD5Utils;
import com.mayikt.entity.utils.SaltUtils;
import com.mayikt.entity.SysUser;
import com.mayikt.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class RegisterService extends BaseApiService implements com.mayikt.service.RegisterService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public BaseResponse RegisterUser(String phoneNumber, String password) {
        //验证参数
        System.out.println("111111"+sysUserMapper.selectById(3));
        if (StringUtils.isEmpty(phoneNumber)) {
            return setResultError("请输入手机号!!!");
        }
        if (StringUtils.isEmpty(password)) {
            return setResultError("请输入密码!!!");
        }
        //根据手机号码查询数据库
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.eq("phone_number", phoneNumber);
        SysUser sysDbUser = sysUserMapper.selectOne(userQueryWrapper);
        if (sysDbUser != null) {
            return setResultError("该用户已存在!!!");
        }
        //生成盐值
        String salt = SaltUtils.getSalt();
        SysUser sysUser = new SysUser(phoneNumber, password + salt, salt);
        //用户注册 将数据存放数据库
        return setResultDb(sysUserMapper.insert(sysUser));
    }


}
