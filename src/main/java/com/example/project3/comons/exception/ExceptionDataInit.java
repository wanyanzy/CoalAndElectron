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
	private static final String ERROR_MESSAGE_LIST = "location_of_error";
	private RedisUtils redisUtils;

	@Autowired
	public ExceptionDataInit setRedisUtils (RedisUtils redisUtils) {
		this.redisUtils = redisUtils;
		return this;
	}

	@Override
	public void run (String... args) throws Exception {
		initialize();
		System.out.println(redisUtils.hGet(ERROR_MESSAGE_LIST,Integer.toString(0)));
	}

	public void initialize () {
		redisUtils.hPutIfAbsent(ERROR_MESSAGE_LIST, Integer.toString(0), "异常信息初始化完成");
		redisUtils.hPutIfAbsent(ERROR_MESSAGE_LIST, Integer.toString(666), "Undefined internal error");
	}
}
