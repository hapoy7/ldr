package com.ldr.landwell.api.base.keys;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class KeyInfo {
    public String  keyID ;   //钥匙ID
    public Integer terminalNumber ;   //终端机编号
    public Integer boxNumber ;    //钥匙柜编号
    public Integer ueyNumber ;    //钥匙编号
    public String keyName ;   //钥匙名称
    public String keyCard ;   //钥匙卡号
    public Integer keyGroupNumber ;   //钥匙分组
    public Integer KeyState ;     //钥匙在位状态 0：未注册，1：在位，2：不在位，3：错位，4：超时状态-超时未归还
    public Integer UseTime ;   //使用时间类型（0：不限制，1：使用时长，2：使用时间）
    public String UseTimeValue ;   // UseTime=1为使用时长（分钟）     UseTime=2为使用时间    格式：07:00-11:00;12:12-18:00;20:00-22:00         		    
    public Integer KeyType ;   //钥匙类型（0：无，1：钥匙栓，2：仅小柜门，3：钥匙栓和小柜门）
    public String TakeTime ;   //钥匙取走的时间
    public String TakeUserID ;   //取走人员ID
    public String BaseModifyTime ;   //修改时间
    public String BaseModifierId ;   //修改人员ID
    public String DepartmentId ;      //部门id  
}
