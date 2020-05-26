package com.example.demo.config;

import com.example.demo.config.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//扩展springmvc的配置
public class MyMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
////        super.addViewControllers(registry);
//        registry.addViewController("/ingram").setViewName("login-page");
//    }
//    @Bean
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
//        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("").setViewName("login-page");
//            }
//        };
//        return adapter;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login-page", "/register","/css/**","/js/**","/fonts/**","/icons/**","/image/**","/pages/**","/plugins/**","/sass/**","/login","/addAcount-page","/addUser","/mini/**","/upload/**","/swagger-ui.html","/static/**","/webjars/**");
    }
}
