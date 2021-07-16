package com.example.project3.comons.exception;

import com.example.project3.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 橙鼠鼠
 */
@Component
@Order(1)
public class ExceptionDataInit implements CommandLineRunner {
	private RedisUtils redisUtils;
	private static final String ERROR_MESSAGE_LIST="location_of_error";

	@Autowired
	public ExceptionDataInit setRedisUtils (RedisUtils redisUtils) {
		this.redisUtils = redisUtils;
		return this;
	}

	@Override
	public void run (String... args) throws Exception {
		initialize();
	}

	public void initialize(){
		redisUtils.hPutIfAbsent(ERROR_MESSAGE_LIST,Integer.toString(666),"未定义内部错误");
	}
}
