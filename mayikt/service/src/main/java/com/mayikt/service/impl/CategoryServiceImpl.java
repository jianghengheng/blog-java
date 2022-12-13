package com.mayikt.service.impl;

import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.dao.Category;
import com.mayikt.mapper.CategoryMapper;
import com.mayikt.mapper.SysUserMapper;
import com.mayikt.service.CategoryService;
import com.mayikt.service.dto.UserRespDto;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@Service
@RestController
@Api("博客")
public class CategoryServiceImpl extends BaseApiService implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public BaseResponse<UserRespDto> getCategoryList() {
      List<Category> category= categoryMapper.selectList(null);
        return setResultSuccessData(category);
    }
}
