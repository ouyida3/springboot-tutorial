package com.example.demo.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
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

/**
 * @since 2019.7
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        com.google.common.base.Predicate<RequestHandler> selector1 = RequestHandlerSelectors.basePackage("com.example.demo.swagger");
        com.google.common.base.Predicate<RequestHandler> selector2 = RequestHandlerSelectors.basePackage("com.example.demo.controller");

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))// 显示自己写的全部controller，不包含系统的
                .apis(Predicates.or(selector1,selector2))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Documentation")
                .description("Api Documentation")
                .termsOfServiceUrl("https://github.com")
                .contact(new Contact("danni", "https://github.com", "252283424@qq.com"))
                .version("1.0")
                .build();
    }

//    @Bean
//    public Docket createRestApi() {
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("token").description("Token").modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        pars.add(tokenPar.build());
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.swagger")).paths(PathSelectors.any())
//                .build().globalOperationParameters(pars);
//    }
//
//    private ApiInfo apiInfo() {
//        // 联系方式，点击name打开邮箱
//        Contact contact = new Contact("danni", "", "252283424@qq.com");
//        // title为大标题；description为小说明
//        return new ApiInfoBuilder()
//                .title("Api Documentation Title")
//                .description("Api Documentation Description")
//                .contact(contact)
//                .version("1.0")
//                .build();
//    }
}
