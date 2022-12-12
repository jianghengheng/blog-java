package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.dto.UserRespDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FileService {
    @ApiOperation("上传文件")
    @PostMapping("/Upload")

    String upload(MultipartFile file) throws IOException;
    @ApiOperation("下载文件")
    @GetMapping("/download/{id}")
    BaseResponse  getFile (@PathVariable("id") Integer id, HttpServletResponse response);
}
