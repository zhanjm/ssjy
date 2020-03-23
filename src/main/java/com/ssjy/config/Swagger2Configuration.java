package com.ssjy.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    public static final String SWAGGER_SCAN_BASE_PACKAGE="com.ssj.controller";

    public static final String VERSION= "1.0.0";

    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("")
                .apiInfo(apiInfo()).select()
                // 扫描的包所在位置
                .apis(RequestHandlerSelectors.basePackage("com.csg.jghdz")) // 注意修改
                // 扫描的 URL 规则
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        // 联系信息
        Contact contact = new Contact("zjm", "",
                "zhanjm614@qq.com");
        return new ApiInfoBuilder()
                // 大标题
                .title("结构化地址微服务接口")
                // 描述
                .description("结构化地址微服务接口，不包括系统支撑、权限管理")
                // 服务条款 URL
                .termsOfServiceUrl("").contact(contact)
                // 版本
                .version(VERSION).build();

    }
}
