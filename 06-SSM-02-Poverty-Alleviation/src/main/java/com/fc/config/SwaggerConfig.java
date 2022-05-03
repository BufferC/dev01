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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(token())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fc.controller"))
                .paths(PathSelectors.any())
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
                .required(false);

        // 构建出来一个参数放到集合中
        parameters.add(parameterBuilder.build());

        return parameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("扶贫政策管理系统")
                .version("3.1.2")
                .license("Apache 2.0")
                .contact(new Contact("BufferC", "https://github.com/BufferC", "2937753364@qq.com"))
                .description("这是一个扶贫的项目，没了~")
                .build();
    }
}
