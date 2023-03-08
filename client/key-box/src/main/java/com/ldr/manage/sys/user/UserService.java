package com.ldr.manage.sys.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.ldr.common.base.Page;

/**
 * @类说明 【用户】业务逻辑层
 * @author 高振中
 * @date 2020-11-17 01:42:03
 **/
@Service
public class UserService {

	@Autowired
	private UserDao userDao; // 注入【用户】数据访问层
	@Value(value = "${spring.rooturl}")
	private String rootUrl;

	/**
	 * @方法说明 【用户】新增
	 */
	public Long save(User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		return userDao.save(user).getUserId();
	}

	/**
	 * @方法说明 【用户】删除
	 */
	public int delete(Object[] ids) {
		return userDao.delete(ids);
	}

	/**
	 * @方法说明 【用户】更新
	 */
	public int update(User user) {
		return userDao.update(user);
	}

	/**
	 * @方法说明 【用户】分页列表
	 */
	public Page<User> page(UserCond cond) {
		cond.setOrders("user_id DESC");
		Page<User> page = userDao.page(cond);
		page.getDataList().forEach(i -> i.setAvatarUrl(rootUrl + i.getAvatar()));
		return page;
	}

	/**
	 * @方法说明 【用户】列表
	 */
	public List<User> list(UserCond cond) {
		cond.setOrders("t.user_id DESC");
		List<User> users = userDao.list(cond);
		users.forEach(i -> i.setAvatarUrl(rootUrl + i.getAvatar()));
		return users;
	}

	/**
	 * @方法说明 【用户】个数
	 */
	public int count(UserCond cond) {
		return userDao.count(cond);
	}
}