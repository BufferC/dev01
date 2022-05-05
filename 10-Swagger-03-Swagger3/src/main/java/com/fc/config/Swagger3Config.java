package com.fc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class Swagger3Config {
    // 装配Swagger的Bean对象：Docket
    @Bean
    public Docket docket_BufferC() {
        // 创建对象，使用Swagger作为文档类型
        return new Docket(DocumentationType.OAS_30)
                // 添加API信息
                .apiInfo(apiInfo_BufferC())
                .groupName("BufferC")
                // 允许查看所有的API信息
                .select()
                // 指定生成文档的路径
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                // 指定请求url的匹配规则
                .paths(PathSelectors.ant("/user/**"))
                .build()
                // 安全环境
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }

    // 设置授权信息
    private List<SecurityScheme> securitySchemes() {
        ApiKey key = new ApiKey("token", "token", "header");

        return Collections.singletonList(key);
    }

    // 全局配置授权信息
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();

        securityContexts.add(getSecurityContext());

        return securityContexts;
    }

    // 安全环境设置
    private SecurityContext getSecurityContext() {
        List<SecurityReference> references = new ArrayList<>();

        AuthorizationScope authorizationScope = new AuthorizationScope("global", "参数的描述：token");

        AuthorizationScope[] scopes = new AuthorizationScope[1];

        scopes[0] = authorizationScope;

        references.add(new SecurityReference("token", scopes));

        return SecurityContext.builder()
                .securityReferences(references)
                .build();
    }

    @Bean
    public Docket docket_Nixl() {
        // 创建对象，使用Swagger作为文档类型
        return new Docket(DocumentationType.OAS_30)
                // 添加API信息
                .apiInfo(apiInfo_Nixl())
                .groupName("Nixl")
                // 允许查看所有的API信息
                .select()
                // 指定生成文档的路径
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                // 支持上面说的那个路径是满足条件的
                .paths(PathSelectors.ant("/login/**"))
                .build();
    }

    private ApiInfo apiInfo_BufferC() {
        return new ApiInfoBuilder()
                // 标题
                .title("BufferC的代码~")
                // 版本
                .version("3.1")
                // 描述
                .description("用户模块的相关内容")
                // 联系人相关
                .contact(new Contact("BufferC", "https://github.com/BufferC", "2937753364@qq.com"))
                // 许可证
                .license("Apache License, Version 2.0")
                // 服务条款
                .termsOfServiceUrl("https://swagger.io")
                .build();
    }

    private ApiInfo apiInfo_Nixl() {
        return new ApiInfoBuilder()
                // 标题
                .title("newL的代码")
                // 版本
                .version("2.0")
                // 描述
                .description("登录模块的相关内容")
                // 联系人相关
                .contact(new Contact("newL", "https://github.com/NIXL27", "2904937506@qq.com"))
                // 许可证
                .license("Apache License, Version 2.0")
                // 服务条款
                .termsOfServiceUrl("https://swagger.io")
                .build();
    }
}
