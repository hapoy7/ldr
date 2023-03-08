package com.ldr.manage.base.basepermission.vo;

import com.ldr.manage.base.basekey.BaseKey;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 钥匙授权
 */
@Setter
@Getter
@Builder
public class KeyAuth {
    private List<BaseKey> keyList;// 全部钥匙
    private List<Long> ids;// 已关联的钥匙
}
