package com.ldr.manage.base.terbox.vo;

import com.ldr.manage.base.basebox.BaseBox;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @类说明 【授权信息】
 * @author 高振中
 * @date 2022-10-10 01:42:03
 **/
@Setter
@Getter
@Builder
public class Auth {
	private List<BaseBox> boxList;// 全部钥匙柜
	private List<Long> ids;// 已关联的钥匙柜id
}
