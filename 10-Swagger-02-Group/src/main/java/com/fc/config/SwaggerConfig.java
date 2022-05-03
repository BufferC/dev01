package com.fc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
// 开启Swagger自动装配
@EnableSwagger2WebMvc
public class SwaggerConfig {
    // 装配Swagger的Bean对象：Docket
    @Bean
    public Docket docket_BufferC() {
        // 创建对象，使用Swagger作为文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                // 添加API信息
                .apiInfo(apiInfo_BufferC())
                .groupName("BufferC")
                // 全局操作参数
                .globalOperationParameters(token())
                // 允许查看所有的API信息
                .select()
                // 指定生成文档的路径
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                // 指定请求url的匹配规则
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }

    @Bean
    public Docket docket_Nixl() {
        // 创建对象，使用Swagger作为文档类型
        return new Docket(DocumentationType.SWAGGER_2)
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

    // 设置的全局参数
    private List<Parameter> token() {
        // 参数建造器
        ParameterBuilder parameterBuilder = new ParameterBuilder();

        ArrayList<Parameter> parameters = new ArrayList<>();

        // 参数名
        parameterBuilder.name("Authorization")
                .description("jwt令牌")
                // 声明参数的数据类型
                .modelRef(new ModelRef("string"))
                // 参数的类型
                .parameterType("header")
                // 默认值的提示语
                .defaultValue("issue token")
                // 添加示例
                .scalarExample("header.payload.signature")
                // 是否必须
                .required(true);

        // 构建出来一个参数放到集合中
        parameters.add(parameterBuilder.build());

        return parameters;
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
