package com.example.project3.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDateTime;

/**
 * @author 橙鼠鼠
 */
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket createRestApi () {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo () {
		return new ApiInfoBuilder()
				.title("国煤系统 成都信息工程大学27组服务端Api")
				.termsOfServiceUrl("https://github.com/MrCh1ppy/CoalAndElectron")
				.description(
						"\n服务条款为为github仓库网址"+
						"\n组员:陈靖珏,汪宗远,王嘉琪,雷美莹,曾懿宁,王梦秋,罗健静"+
						"\n本次服务器开启时间: " + LocalDateTime.now().format(new DateTimeFormatterFactory("yyyy年MM月dd日 HH:mm:ss").createDateTimeFormatter()))
				.version("1.7")
				.build();
	}
}
