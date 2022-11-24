package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.dto.UserRespDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserService {
    /**
     * 根据token 查询用户信息
     **/
    @ApiOperation("get请求")
    @GetMapping("/getUserInfo")
   BaseResponse<UserRespDto> getUserInfoByToken(String token);
}
