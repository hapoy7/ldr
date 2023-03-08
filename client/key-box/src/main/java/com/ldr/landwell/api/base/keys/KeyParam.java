package com.ldr.landwell.api.base.keys;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class KeyParam {
    public String departmentId;
    public String  keyID ;   //钥匙ID
    //public Integer terminalNumber ;   //终端机编号
    //public Integer BoxNumber ;    //钥匙柜编号
    //public Integer keyNumber ;    //钥匙编号
    //public String keyName ;   //钥匙名称
    //public String ueyCard ;   //钥匙卡号
    //public Integer keyGroupNumber ;   //钥匙分组
    //public String uepartmentId ;      //部门id (必填)
    //public Integer pageIndex ;     //当前页数(必填)
    //public Integer pageSize ;     //每页条数(必填)
    //public String baseModifyTime ;   //修改时间(必填)
    //public String baseModifierId ;   //修改人员ID(必填)
    //public Integer userNumber;          //人员编号（8位以内纯数字）
}
