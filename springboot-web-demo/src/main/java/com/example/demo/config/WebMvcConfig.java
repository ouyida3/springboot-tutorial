package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/static/swagger/");
//    }

//        @Bean
//    public HttpParamsInterceptor httpParamsInterceptor() {
//        return new HttpParamsInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(httpParamsInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);

//        registry.addInterceptor(getInterfaceAuthCheckInterceptor()).addPathPatterns("/**")
////这个是为了swagger做的过滤
//                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/*.html", "/**/*.html", "/swagger-resources/**")

    }

}
