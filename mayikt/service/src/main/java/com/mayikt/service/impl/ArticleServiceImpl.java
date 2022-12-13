package com.mayikt.service.impl;

import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.dao.ArticleDao;
import com.mayikt.dao.Category;
import com.mayikt.dao.File;
import com.mayikt.mapper.ArticleMapper;
import com.mayikt.mapper.CategoryMapper;
import com.mayikt.mapper.FileMapper;
import com.mayikt.service.ArticleService;
import com.mayikt.service.dto.UserRespDto;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Service
@RestController
@Api("博客")
public class ArticleServiceImpl extends BaseApiService implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public BaseResponse<UserRespDto> addArticle(ArticleDao articleDao) {
        Integer categoryId = articleDao.getCategoryId();
        Category category = categoryMapper.selectById(categoryId);
        category.setNum(category.getNum() + 1);
        categoryMapper.updateById(category);
       articleMapper.insert(articleDao);
        return setResultSuccess();
    }
}
