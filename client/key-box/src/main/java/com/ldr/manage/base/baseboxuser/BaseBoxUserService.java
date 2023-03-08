package com.ldr.manage.base.baseboxuser;

import com.ldr.common.base.Page;
import com.ldr.manage.base.basepermission.vo.Auth;
import com.ldr.manage.sys.user.User;
import com.ldr.manage.sys.user.UserCond;
import com.ldr.manage.sys.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @类说明 【钥匙柜用户关联】业务逻辑层
 * @author 杨来富
 * @date 2022-11-01 09:50:05
 **/
//@Slf4j
@Service
public class BaseBoxUserService {
	@Autowired
	private BaseBoxUserDao baseBoxUserDao; // 注入【钥匙柜用户关联】数据访问层
	@Autowired
	private UserDao userDao;

	public Auth auth(BaseBoxUserCond cond) {
		List<BaseBoxUser> users = baseBoxUserDao.list(BaseBoxUserCond.builder().boxId(cond.getBoxId()).build());
		List<User> list = userDao.list(UserCond.builder().deptName(cond.getDeptName()).name(cond.getName()).build());
		return Auth.builder().userList(list).ids(users.stream().map(i -> i.getUserId()).toList()).build();
	}
	/**
	 * 增加或删除柜子的关联用户
	 * @param userIds
	 * @param boxId
	 */
	public void insertBatch(List<Long> userIds, Long boxId) {
		baseBoxUserDao.delete(BaseBoxUserCond.builder().boxId(boxId).build());
		baseBoxUserDao.saveBatch(userIds.stream().map(u -> new BaseBoxUser(u, boxId)).toList());
	}

	/**
	 * @方法说明 【钥匙柜用户关联】新增并反回主键
	 */
	// @Transactional
	public Long save(BaseBoxUser baseBoxUser) {
		return baseBoxUserDao.save(baseBoxUser).getUserBoxId();
	}

	/**
	 * @方法说明 【钥匙柜用户关联】删除
	 */
	public int delete(Object[] ids) {
		return baseBoxUserDao.delete(ids);
	}

	/**
	 * @方法说明 【钥匙柜用户关联】修改
	 */
	public int update(BaseBoxUser baseBoxUser) {
		return baseBoxUserDao.update(baseBoxUser);
	}

	/**
	 * @方法说明 【钥匙柜用户关联】分页列表
	 */
	public Page<BaseBoxUser> page(BaseBoxUserCond cond) {
		return baseBoxUserDao.page(cond);
	}

	/**
	 * @方法说明 【钥匙柜用户关联】列表
	 */
	public List<BaseBoxUser> list(BaseBoxUserCond cond) {
		return baseBoxUserDao.list(cond);
	}

	/**
	 * @方法说明 【钥匙柜用户关联】按主键查
	 */
	public BaseBoxUser findById(Long id) {
		return baseBoxUserDao.findById(id);
	}

	/**
	 * @方法说明 【钥匙柜用户关联】个数
	 */
	public int count(BaseBoxUserCond cond) {
		return baseBoxUserDao.count(cond);
	}
	/**
	 * @方法说明 【钥匙柜用户关联】批量保存与更新
	 */
	public void saveBatch(List<BaseBoxUser> baseBoxUsers) {
		baseBoxUserDao.saveBatch(baseBoxUsers);
	}
}