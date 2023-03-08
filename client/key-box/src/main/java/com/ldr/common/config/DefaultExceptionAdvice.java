package com.ldr.common.config;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import lombok.extern.slf4j.Slf4j;

/**
 * @summary【全局异常】处理
 * @author 高振中
 * @date 2021-02-01 20:20:20
 **/
@Slf4j
@ResponseBody
@ControllerAdvice
public class DefaultExceptionAdvice {
	@Value(value = "${spring.servlet.multipart.max-file-size}")
	private String maxSize;// 配置中的单个文件大小

	/**
	 * 【参数校验异常】
	 **/
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result<String> valid(MethodArgumentNotValidException ex) {
//		log.error(ex.getMessage(), ex);
		return Result.error(ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList().toString());
	}

	@ExceptionHandler(SQLException.class)
	public Result<String> sql(SQLException ex) {
		log.error(ex.getMessage(), ex);
		return Result.error(ex.getMessage());
	}

	@ExceptionHandler(IOException.class)
	public Result<String> io(IOException ex) {
		log.error(ex.getMessage(), ex);
		return Result.error(ex.getMessage());
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public Result<String> io(MaxUploadSizeExceededException ex) {
		log.error(ex.getMessage(), ex);
		return Result.error("超过文件最大尺寸," + maxSize + ".");
	}

	@ExceptionHandler(RuntimeException.class)
	public Result<String> runtime(RuntimeException ex) {
		log.error(ex.getMessage(), ex);
		return Result.error(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public Result<String> ex(Exception ex) {
		log.error(ex.getMessage(), ex);
		return Result.error(ex.getMessage());
	}
}
