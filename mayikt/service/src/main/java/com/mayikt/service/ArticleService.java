package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.dao.ArticleDao;
import com.mayikt.service.dto.UserRespDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ArticleService {
    @ApiOperation("添加文章")
    @PostMapping("/addArticle")
    BaseResponse<UserRespDto> addArticle(@RequestBody ArticleDao articleDao);
}
