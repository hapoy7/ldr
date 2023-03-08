package com.ldr.manage.sys.common;

import java.util.List;
import java.util.Map;

import com.ldr.manage.sys.dictitem.DictVO;
import com.ldr.manage.sys.func.Func;
import com.ldr.manage.sys.user.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginVO {
	private User user;// 用户信息
	private String token;// 令牌
	private Map<String, List<DictVO>> dicts;// 字典数据
	private List<Func> menus;// 菜单
}
