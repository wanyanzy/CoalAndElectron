package com.example.project3.comons.exception;

/**
 * @author 橙鼠鼠
 */
public class ProjectException extends RuntimeException{
	private final Integer errorCode;

	/**
	 * Constructs a new runtime exception with {@code null} as its
	 * detail message.  The cause is not initialized, and may subsequently be
	 * initialized by a call to {@link #initCause}.
	 */
	public ProjectException (Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getErrorCode () {
		return errorCode;
	}
}
