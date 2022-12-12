//package com.mayikt.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.mayikt.common.core.api.BaseApiService;
//
//import com.mayikt.common.core.api.BaseResponse;
//import com.mayikt.entity.SysUser;
//import com.mayikt.entity.utils.MD5Utils;
//import com.mayikt.entity.utils.RedisUtil;
//import com.mayikt.mapper.SysUserMapper;
//import com.mayikt.service.UserService;
//import com.mayikt.service.dto.UserRespDto;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.UUID;
//@Service
//@RestController
//public class LoginService extends BaseApiService implements com.mayikt.service.LoginService {
//    @Resource
//    private SysUserMapper sysUserMapper;
//
//@Resource
//private UserService userService;
//    @Override
//    public BaseResponse Login(String phoneNumber, String password) {
//
//        //判断输入的是否为空
//        if (StringUtils.isEmpty(phoneNumber)) {
//            return setResultError("phoneNumber is null");
//        }
//        if (StringUtils.isEmpty(password)) {
//            return setResultError("password is null");
//        }
//        //通过手机号查询用户是否存在
//        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
//        sysUserQueryWrapper.eq("phone_number", phoneNumber);
//        SysUser sysDBUser = sysUserMapper.selectOne(sysUserQueryWrapper);
//        if (sysDBUser == null) {
//            return setResultError("该手机号码不存在");
//        }
//
//        String dbPassword =MD5Utils.md5(sysDBUser.getPassword()) ;
//        String userPassword = MD5Utils.md5(password + sysDBUser.getSalt());
//        if(!dbPassword.equals(userPassword)){
//            return setResultError("密码错误!");
//        }
//        // 生成对应的用户令牌
//        String token = UUID.randomUUID().toString().replace("-", "");
//        Integer userId = sysDBUser.getId();
//        // 存入到redis中
//        RedisUtil.setString(token, userId + "");
////        HashMap<Object, Object> data = new HashMap<>();
////        data.put("token",MD5Utils.md5("jiangheng"));
////        data.put("userID",sysDBUser.getId());
//        UserRespDto userRespDto= userService.getUserInfoByToken(token).getData();
//        return setResultSuccessData(userRespDto);
//    }
//
//
//}
