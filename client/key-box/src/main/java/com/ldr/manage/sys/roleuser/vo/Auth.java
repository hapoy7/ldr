package com.ldr.manage.sys.roleuser.vo;

import java.util.List;

import com.ldr.manage.sys.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【授权信息】
 * @author 高振中
 * @date 2022-10-10 01:42:03
 **/
@Setter
@Getter
@Builder
public class Auth {
	private List<User> userList;// 全部用户
	private List<Long> ids;// 已授权用户ID
}
