package com.ldr.manage.base.keybox;

import com.ldr.manage.base.baseboxuser.BaseBoxUserCond;
import com.ldr.manage.base.basekey.BaseKey;
import com.ldr.manage.base.basekey.BaseKeyCond;
import com.ldr.manage.base.basekey.BaseKeyDao;
import com.ldr.manage.base.basepermission.vo.KeyAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @类说明 【钥匙柜钥匙关联】业务逻辑层
 * @author 杨来富
 * @date 2022-11-04 15:48:07
 **/
//@Slf4j
@Service
public class KeyBoxService {

	@Autowired
	private KeyBoxDao keyBoxDao; // 注入【钥匙柜钥匙关联】数据访问层

	@Autowired
	private BaseKeyDao keyDao;

	/**
	 * @方法说明 【钥匙列表与关联信息】
	 * @param cond
	 * @return
	 */
	public KeyAuth auth(KeyBoxCond cond) {
		List<KeyBox> keys = keyBoxDao.list(KeyBoxCond.builder().boxId(cond.getBoxId()).build());
		List<BaseKey> list = keyDao.list(BaseKeyCond.builder().name(cond.getKeyName()).number(cond.getKeyNumber()).build());
		return KeyAuth.builder().keyList(list).ids(keys.stream().map(i -> i.getKeyId()).toList()).build();
	}
	/**
	 * @方法说明 【钥匙列表与关联信息】批量插入
	 * @param keyIds
	 * @param boxId
	 */
	public void insertBatch(List<Long> keyIds, Long boxId) {
		keyBoxDao.delete(BaseBoxUserCond.builder().boxId(boxId).build());
		keyBoxDao.saveBatch(keyIds.stream().map(k -> new KeyBox(k, boxId)).toList());
	}
}