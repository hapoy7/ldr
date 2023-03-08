package com.ldr.manage.base.basekey;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldr.common.base.Page;
/**
 * @类说明 【钥匙】业务逻辑层
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@Service
public class BaseKeyService {

	@Autowired
	private BaseKeyDao baseKeyDao; // 注入【钥匙】数据访问层

	/**
	 * @方法说明 【钥匙】新增并反回主键
	 */
	// @Transactional
	public Long save(BaseKey baseKey) {
		return baseKeyDao.save(baseKey).getId();
	}

	/**
	 * @方法说明 【钥匙】删除
	 */
	public int delete(Object[] ids) {
		return baseKeyDao.delete(ids);
	}

	/**
	 * @方法说明 【钥匙】修改
	 */
	public int update(BaseKey baseKey) {
		return baseKeyDao.update(baseKey);
	}

	/**
	 * @方法说明 【钥匙】分页列表
	 */
	public Page<BaseKey> page(BaseKeyCond cond) {
		Page<BaseKey> page = baseKeyDao.page(cond);
		return page;
	}

	/**
	 * @方法说明 【钥匙】列表
	 */
	public List<BaseKey> list(BaseKeyCond cond) {
		return baseKeyDao.list(cond);
	}

	/**
	 * @方法说明 【钥匙】按主键查
	 */
	public BaseKey findById(Long id) {
		return baseKeyDao.findById(id);
	}

	/**
	 * @方法说明 【钥匙】个数
	 */
	public int count(BaseKeyCond cond) {
		return baseKeyDao.count(cond);
	}
	/**
	 * @方法说明 【钥匙】批量保存与更新
	 */
	public void saveBatch(List<BaseKey> baseKeys) {
		baseKeyDao.saveBatch(baseKeys);
	}	
}