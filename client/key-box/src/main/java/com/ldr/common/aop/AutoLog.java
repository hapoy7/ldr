package com.ldr.common.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @summary 【日志记录】标记注解
 * @author 高振中
 * @date 2021-03-12
 */
@Target(ElementType.METHOD) // 作用到方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
public @interface AutoLog {
	String value() default "";// 日志标题
}