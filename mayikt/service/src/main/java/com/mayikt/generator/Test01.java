//package com.mayikt.generator;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.util.Collections;
//
///**
// * @author 余胜军
// * @ClassName Test01
// */
//public class Test01 {
//    public static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/sys_admin?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
//                        "jiangheng", "123456")
//                .globalConfig(builder -> {
//                    builder.author("mayikt") // 设置作者
////                    .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("D:\\data\\mybatis"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.mayikt.mapper") // 设置父包名
//                            //                            .moduleName("system") // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\data\\mybatis")); // 设置mapperXml生成路径
//                })
//                //                .strategyConfig(builder -> {
//                //                    builder.addInclude("t_simple") // 设置需要生成的表名
//                //                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
//                //                })
//                //                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
//    }
//}
