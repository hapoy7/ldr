package com.ldr.keyboxserver.token;

import com.ldr.manage.sys.user.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenVO {
	private User user;// 用户信息
	private String token;// 令牌
}
