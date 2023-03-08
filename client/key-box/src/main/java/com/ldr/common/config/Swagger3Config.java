package com.ldr.common.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @summary【Swagger3】配置类
 * @author 高振中
 * @date 2021-02-01 20:20:20
 **/
@Configuration
@EnableSwagger2
public class Swagger3Config {
	public final static String TOKEN = "token";

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("平台接口文档V1.0").description("彪悍的代码也需要注释！！！！")//
//				.termsOfServiceUrl("NO terms of service(高振中)")//
				.version("1.0").description("后台API接口")//
				.contact(new Contact("高振中团队", "https://www.jianshu.com/u/3bd57d5f1074", "gzz_gzz@163.com"))//
//				.license("The Apache License, Version 2.0")//
				.licenseUrl("https://www.jianshu.com/u/3bd57d5f1074").build();//
	}

	@Bean
	public Docket sys() {
		return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())//
				.select()//
//				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//
//				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//
				.apis(RequestHandlerSelectors.basePackage("com.ldr.manage.sys")).paths(PathSelectors.any())//
				.build().groupName("系统管理").pathMapping("/")//
				.securitySchemes(securitySchemes()).securityContexts(securityContexts());
	}

	@Bean
	public Docket base() {
		return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())//
				.select()
				// .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//
				// .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//
				.apis(RequestHandlerSelectors.basePackage("com.ldr.manage.base")).paths(PathSelectors.any())//
				.build().groupName("基础信息").pathMapping("/")//
				.securitySchemes(securitySchemes()).securityContexts(securityContexts());
	}

	@Bean
	public Docket bus() {
		return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())//
				.select()
				// .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//
				// .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//
				.apis(RequestHandlerSelectors.basePackage("com.ldr.manage.bus")).paths(PathSelectors.any())//
				.build().groupName("营业日期").pathMapping("/")//
				.securitySchemes(securitySchemes()).securityContexts(securityContexts());
	}

	private List<SecurityScheme> securitySchemes() {
		return List.of(new ApiKey(TOKEN, TOKEN, In.HEADER.toValue()));
	}

	private List<SecurityContext> securityContexts() {
		return List.of(SecurityContext.builder()//
				.securityReferences(List.of(new SecurityReference(TOKEN, new AuthorizationScope[] { new AuthorizationScope("global", "accessEverything") })))//
				.operationSelector(o -> o.requestMappingPattern().matches("^(?!auth).*$")).build());
	}

}
