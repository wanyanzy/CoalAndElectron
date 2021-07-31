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
				.title("国煤系统")
				.description("数据返回有任何问题微信/QQ喊我" + "\n本次服务器开启时间: " + LocalDateTime.now().format(new DateTimeFormatterFactory("yyyy年MM月dd日 HH:mm:ss").createDateTimeFormatter()))
				.version("1.0")
				.build();
	}
}
