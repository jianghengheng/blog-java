package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.dto.UserRespDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    /**
     * 根据token 查询用户信息
     **/
    @ApiOperation("get请求")
    @GetMapping("/getUserInfo")
   BaseResponse<UserRespDto> getUserInfoByToken(String token);
//    @ApiOperation("上传文件;")
//@PostMapping("/Upload")
//
// String upload(MultipartFile file) throws IOException;


}
