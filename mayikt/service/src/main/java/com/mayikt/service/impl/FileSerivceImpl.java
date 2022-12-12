package com.mayikt.service.impl;

import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.entity.SysUser;
import com.mayikt.mapper.FileMapper;
import com.mayikt.service.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
@RestController
public class FileSerivceImpl extends BaseApiService implements FileService {
    @Value("${file-save-path}")
    private String fileSavePath;
    @Resource
    private FileMapper fileMapper;

    @Override
    public String upload(MultipartFile phone) throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datepath = sdf.format(date);
        String uploadPath = fileSavePath + '/' + datepath + '/';
        File path = new File(uploadPath);
        if (!path.exists()) {//如果当前目录不存在
            path.mkdir();
        }
        File file = new File(uploadPath + phone.getOriginalFilename());

        phone.transferTo(file);//将此图像保存到file本地
        com.mayikt.dao.File fileInfo = new com.mayikt.dao.File();
        fileInfo.setFileName(file.getName());
        fileInfo.setSize((int) phone.getSize());
        fileInfo.setPath(uploadPath);

        fileMapper.insert(fileInfo);

     String id= String.valueOf(fileInfo.getId());


        return id;
    }

    @Override
    public BaseResponse getFile(Integer id, HttpServletResponse response) {
        com.mayikt.dao.File fileInfo =   fileMapper.selectById(id);
        if (fileInfo == null) {
            return setResultError("该用户已存在!!!");
        }
        //读取文件
        File file = new File(fileInfo.getPath(), fileInfo.getFileName());
        //获取文件输入流
        try {
            FileInputStream is = new FileInputStream(file);
            response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(fileInfo.getFileName(), "UTF-8"));
            /** * 设置强制下载不打开 */
            response.setContentType("application/force-download");// 设置强制下载不打开
            //获取响应输出流
            ServletOutputStream os = response.getOutputStream();
            //文件拷贝
            IOUtils.copy(is,os);

            //关流方式(优雅)
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
