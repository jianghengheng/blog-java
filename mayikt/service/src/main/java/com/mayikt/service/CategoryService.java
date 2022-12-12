package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.dto.UserRespDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

public interface CategoryService {
    @ApiOperation("获取分类数据")
    @GetMapping("/getCategoryList")
    BaseResponse<UserRespDto> getCategoryList();
}
