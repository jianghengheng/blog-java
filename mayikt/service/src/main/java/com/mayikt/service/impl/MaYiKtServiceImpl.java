package com.mayikt.service.impl;

import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.MaYiKtService;
import org.springframework.web.bind.annotation.RestController;

@RestController
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


}
