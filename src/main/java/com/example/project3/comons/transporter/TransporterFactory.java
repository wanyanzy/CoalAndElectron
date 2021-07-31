package com.example.project3.comons.transporter;

/**
 * @author 橙鼠鼠
 */
public abstract class TransporterFactory {
	protected static final Integer DEFAULT_SIZE = 4;

	/**
	 * @param msg:msg只能使用基本类型来写入,作为指示.
	 * @return 返回初步封装完成的deliver
	 */
	abstract Transporter getDeliverPackage (String msg) throws CloneNotSupportedException;
}
