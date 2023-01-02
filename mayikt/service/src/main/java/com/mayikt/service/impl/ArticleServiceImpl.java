package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datepath = sdf.format(date);
        articleDao.setCreatTime(datepath);
        Integer categoryId = articleDao.getCategoryId();
        Category category = categoryMapper.selectById(categoryId);
        category.setNum(category.getNum() + 1);
        categoryMapper.updateById(category);
        articleMapper.insert(articleDao);
        return setResultSuccess();
    }

    @Override
    public BaseResponse<UserRespDto> addArticle() {
        List<ArticleDao> articleDaoList = articleMapper.selectList(null);
        return setResultSuccessData(articleDaoList);
    }

    @Override
    public BaseResponse<UserRespDto> getArticleById(Integer id) {
        ArticleDao articleDao = articleMapper.selectById(id);
        return setResultSuccessData(articleDao);
    }

    @Override
    public BaseResponse<UserRespDto> getArticleByCategoryId(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("category_id", id);
        List<ArticleDao> articleDaoList = articleMapper.selectList(wrapper);
        return setResultSuccessData(articleDaoList);
    }

    @Override
    public BaseResponse<UserRespDto> getArticleByCategoryId() {
        return null;
    }
}
