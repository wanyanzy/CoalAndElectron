package com.example.project3.comons.transporter;

import com.example.project3.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author 橙鼠鼠
 */
@Component
public class FailFactory extends TransporterFactory {
	private static final String ERROR_MESSAGE_LIST = "error_message_list";
	private static final String FAIL_MESSAGE = "failure_message";
	private RedisUtils redisUtils;

	@Autowired
	public FailFactory setRedisUtils (RedisUtils redisUtils) {
		this.redisUtils = redisUtils;
		return this;
	}

	/**
	 * msg只能使用基本类型来写入,作为指示符
	 *
	 * @param msg:错误代码
	 */
	@Override
	public Transporter getDeliverPackage (String msg) throws CloneNotSupportedException {
		Integer failCode = Integer.parseInt(msg);
		Transporter trans = new Transporter();
		trans.setDataList(new HashMap<>(DEFAULT_SIZE));
		trans.setCode(failCode);
		trans.getDataList().put(FAIL_MESSAGE, redisUtils.hGet(ERROR_MESSAGE_LIST, msg));
		return trans;
	}
}
