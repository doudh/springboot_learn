//package com.demo.resource;
//
//import com.senyint.common.utils.Result;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ExceptionHandlerAdvice {
//	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
//
//	/**
//	 * 处理运行异常
//	 */
//	@ExceptionHandler(RuntimeException.class)
//	public Result handleRuntimeException(RuntimeException ex) {
//		logger.error("",ex);
//		return Result.error();
//	}
//
//}
