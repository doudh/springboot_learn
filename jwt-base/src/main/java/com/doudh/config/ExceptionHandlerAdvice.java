package com.doudh.config;

import com.doudh.exception.TokenException;
import com.doudh.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	/**
	 * 处理运行异常
	 */
	@ExceptionHandler(value = RuntimeException.class)
	public Object handleRuntimeException(Exception ex) {
		if (ex instanceof TokenException){
			return Result.error(((TokenException) ex).getCode(),((TokenException) ex).getMsg());
		}
		logger.error(ex.getMessage(),ex);
		return Result.error(ex.getMessage());
	}

}
