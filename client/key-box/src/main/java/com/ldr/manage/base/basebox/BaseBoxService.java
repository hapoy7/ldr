package com.ldr.manage.base.basebox;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldr.common.base.Page;
import com.ldr.manage.base.basekey.BaseKeyCond;
import com.ldr.manage.base.basekey.BaseKeyDao;

/**
 * @类说明 【钥匙柜】业务逻辑层
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@Service
public class BaseBoxService {
	@Autowired
	private BaseKeyDao baseKeyDao; // 注入【钥匙】数据访问层
	@Autowired
	private BaseBoxDao baseBoxDao; // 注入【钥匙柜】数据访问层

	/**
	 * @方法说明 【钥匙柜】新增并反回主键
	 */
	// @Transactional
	public Long save(BaseBox baseBox) {
		return baseBoxDao.save(baseBox).getId();
	}

	/**
	 * @方法说明 【钥匙柜】删除
	 */
	public int delete(Object[] ids) {
		return baseBoxDao.delete(ids);
	}

	/**
	 * @方法说明 【钥匙柜】修改
	 */
	public int update(BaseBox baseBox) {
		return baseBoxDao.update(baseBox);
	}

	/**
	 * @方法说明 【钥匙柜】分页列表
	 */
	public Page<BaseBox> page(BaseBoxCond cond) {
		return baseBoxDao.page(cond);
	}

	/**
	 * @方法说明 【钥匙柜】列表
	 */
	public List<BaseBox> list(BaseBoxCond cond) {
		List<BaseBox> list = baseBoxDao.list(cond);
		list.forEach(i -> i.setKeys(baseKeyDao.list(BaseKeyCond.builder().boxId(i.getId()).build())));
		return list;
	}
}