package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface MaYiKtService {
    @GetMapping("/GetName")
    BaseResponse getMaYiKt(String regionId);

}
