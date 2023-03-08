package com.ldr.keyboxserver.token;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录参数")
public class TokenParam {
	@ApiModelProperty("帐号")
	private String name; // 帐号
	@ApiModelProperty("密码")
	private String password; // 密码
}
