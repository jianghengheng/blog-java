package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.dao.ArticleDao;
import com.mayikt.service.dto.UserRespDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ArticleService {
    @ApiOperation("添加文章")
    @PostMapping("/addArticle")
    BaseResponse<UserRespDto> addArticle(@RequestBody ArticleDao articleDao);
    @ApiOperation("获取文章")
    @GetMapping("/getArticle")
    BaseResponse<UserRespDto> addArticle( );
    @ApiOperation("通过id获取文章")
    @GetMapping("/getArticleById/{id}")
    BaseResponse<UserRespDto> getArticleById(@PathVariable("id") Integer id);
    @ApiOperation("通过分类id获取文章")
    @GetMapping("/getArticleByCategoryId/{id}")
    BaseResponse<UserRespDto> getArticleByCategoryId(@PathVariable("id") Integer id);
    @ApiOperation("ss")
    @GetMapping("/getArticleByCategoryId")
    BaseResponse<UserRespDto> getArticleByCategoryId();
}
