package com.example.project3.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 橙鼠鼠
 * @apiNote :开启sa-token全域注解
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors (InterceptorRegistry registry) {
		registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
	}
}
