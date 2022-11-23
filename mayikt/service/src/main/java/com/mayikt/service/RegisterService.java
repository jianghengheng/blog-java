package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;


public interface RegisterService {

    /**
     * 用户注册
     * @param phoneNumber
     * @param password
     * **/
    @PostMapping("/register")
    BaseResponse RegisterUser(String phoneNumber ,String password);


}
