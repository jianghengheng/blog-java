package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;

public interface LoginService {
    /**
     * 用户注册
     * @param phoneNumber
     * @param password
     * **/
    @PostMapping("/login")
    BaseResponse Login(String phoneNumber , String password);
}
