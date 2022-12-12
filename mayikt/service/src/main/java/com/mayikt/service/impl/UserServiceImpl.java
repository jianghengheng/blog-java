package com.mayikt.service.impl;

import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.entity.SysUser;
import com.mayikt.entity.utils.DoToDto;
import com.mayikt.entity.utils.RedisUtil;
import com.mayikt.mapper.SysUserMapper;
import com.mayikt.service.UserService;
import com.mayikt.service.dto.UserRespDto;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
@Service
@RestController
public class UserServiceImpl extends BaseApiService implements UserService {
    @Value("${file-save-path}")
    private String fileSavePath;
    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public BaseResponse<UserRespDto> getUserInfoByToken(String token) {
        //验证参数
        if (StringUtils.isEmpty(token)) {
            return setResultError("token is null");
        }
        //通过redis 获取id
        String userId = RedisUtil.getString(token);
        if (StringUtils.isEmpty(userId)) {
            return setResultError("token is worry");
        }
        Integer id = Integer.parseInt(userId);
//        if (StringUtils.isEmpty(id)) {
//            return setResultError("token is worry");
//        }
// 通过id 查询参数
  SysUser sysUser= sysUserMapper.selectById(id);
UserRespDto userRespDto= (UserRespDto) new DoToDto.MeiteBeanUtils().doToDto(sysUser,UserRespDto.class);
        return setResultSuccessData(userRespDto);
    }

  

}
