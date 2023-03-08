package com.ldr.common.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @summary【Jackson】返回long型属性的处理
 * @author 高振中
 * @date 2021-02-01 20:20:20
 **/
@Configuration
public class JacksonConfiguration {
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
		return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance).serializerByType(Long.TYPE, ToStringSerializer.instance);
	}
}
//js中的长整型（long）为53位，而JAVA中是64位（最大值263-1），所以，当数字值大于253时，末尾数字全部会变成0；
//解决方式一
//json注解
//public class ProductVo {
//    @JsonSerialize(using=ToStringSerializer.class)
//    private Long productId
//    private String productName;
//解决方式二(全局)
/* 这是一个共性问题，故采用全局处理方式 */
//删除与修改时利
//@Configuration
// public class JacksonConfiguration {
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance).serializerByType(Long.TYPE, ToStringSerializer.instance);
//    }
//}
//解决方式三(低效)
//将数据库中的long改为varchar()类型，java实体使用String类型