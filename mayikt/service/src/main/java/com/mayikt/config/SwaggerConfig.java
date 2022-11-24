package com.mayikt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.Contact;
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    private static final String VERSION = "0.0.1";
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("分组名称")
                .apiInfo(apiInfo())
                .select()
                //要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.mayikt"))
                .paths(PathSelectors.any())
                .build();
}
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置标题
                .title("文档标题")
                //联系人
                .contact(contact())
                //描述
                .description("xxx文档")
                //服务
                .termsOfServiceUrl("https://spring.io/")
                //许可证
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version(VERSION)
                .build();
    }
    private Contact contact (){
        return new Contact("SpringBoot", "https://spring.io/", "email");
    }
}
