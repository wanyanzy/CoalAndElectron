package com.example.project3.comons.handler;

import com.example.project3.comons.transporter.FailFactory;
import com.example.project3.comons.transporter.Transporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 橙鼠鼠
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final String ERROR_LOCATION = "location_of_error";
	private FailFactory failFactory;

	@Autowired
	public GlobalExceptionHandler setFailFactory (FailFactory failFactory) {
		this.failFactory = failFactory;
		return this;
	}

	@ExceptionHandler(Exception.class)
	public Transporter exceptionHandler (Exception e) throws CloneNotSupportedException {
		var errorPosition = getErrorPosition(e);
		var deliverPackage = failFactory.getDeliverPackage(Integer.toString(666));
		return deliverPackage.addData(ERROR_LOCATION, errorPosition);
	}

	/**
	 * 解析异常栈以获取异常信息
	 */
	private String getErrorPosition (Exception e) {
		if (e.getStackTrace().length > 0) {
			//第一行是错误文件的位置
			//获取错误文件的名字
			final var element = e.getStackTrace()[0];
			String fileName = element.getFileName() == null ? "Error file not found" : element.getFileName();
			final var lineNumber = element.getLineNumber();
			//获取行号
			return fileName + ":" + lineNumber;
		} else {
			return "";
		}
	}
}
