package com.ldr.manage.sys.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录参数")
public class LoginParam {
	@ApiModelProperty("帐号")
	private String name; // 帐号
	@ApiModelProperty("密码")
	private String password; // 密码
}
