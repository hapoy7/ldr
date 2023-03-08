package com.ldr.manage.base.baseuser;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldr.common.base.Page;
/**
 * @类说明 【用户】业务逻辑层
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@Service
public class BaseUserService {

	@Autowired
	private BaseUserDao baseUserDao; // 注入【用户】数据访问层

	/**
	 * @方法说明 【用户】新增并反回主键
	 */
	// @Transactional
	public Long save(BaseUser baseUser) {
		baseUser.setFingerprintCount(Byte.valueOf("0"));
		return baseUserDao.save(baseUser).getId();
	}

	/**
	 * @方法说明 【用户】删除
	 */
	public int delete(Object[] ids) {
		return baseUserDao.delete(ids);
	}

	/**
	 * @方法说明 【用户】修改
	 */
	public int update(BaseUser baseUser) {
		return baseUserDao.update(baseUser);
	}

	/**
	 * @方法说明 【用户】分页列表
	 */
	public Page<BaseUser> page(BaseUserCond cond) {
		return baseUserDao.page(cond);
	}

	/**
	 * @方法说明 【用户】列表
	 */
	public List<BaseUser> list(BaseUserCond cond) {
		return baseUserDao.list(cond);
	}

	/**
	 * @方法说明 【用户】按主键查
	 */
	public BaseUser findById(Long id) {
		return baseUserDao.findById(id);
	}

	/**
	 * @方法说明 【用户】个数
	 */
	public int count(BaseUserCond cond) {
		return baseUserDao.count(cond);
	}
	/**
	 * @方法说明 【用户】批量保存与更新
	 */
	public void saveBatch(List<BaseUser> baseUsers) {
		baseUserDao.saveBatch(baseUsers);
	}	
}