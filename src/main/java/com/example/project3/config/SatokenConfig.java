package com.example.project3.config;

import cn.dev33.satoken.config.SaTokenConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author 橙鼠鼠
 * @apiNote sa-token的配置类
 */
@Configuration
public class SatokenConfig {

	@Primary
	@Bean(name = "SaTokenConfigure")
	public SaTokenConfig getSaTokenConfig () {
		var config = new SaTokenConfig();
		config.setTokenName("satoken");
		config.setTimeout(30 * 24 * 60 * 60);
		config.setActivityTimeout(-1);
		config.setIsConcurrent(true);
		config.setIsShare(false);
		config.setTokenStyle("uuid");
		config.setIsLog(true);
		config.setTokenStyle("uuid");
		return config;
	}
}
