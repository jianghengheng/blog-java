package com.mayikt.service.impl;

import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.MaYiKtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MaYiKtServiceImpl extends BaseApiService implements MaYiKtService {
    @Override
    public BaseResponse getMaYiKt(String regionId) {
        System.out.println("j".equals(regionId));
        if ("j".equals(regionId)) {

            return setResultSuccess();
        } else {
            return setResultError(400,"错误");
        }

    }

    @Override
    public BaseResponse getMaYiKt2(Integer age) {
        Integer j=1/age;
        return setResultSuccess();



    }


}
