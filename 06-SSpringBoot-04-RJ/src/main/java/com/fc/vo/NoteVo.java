package com.fc.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
// 主页上显示日记日期分类以及类别分类
//EqualsAndHashCode的属性callSuper的默认值为false。
// 值为TRUE时hashcode相同，但值有所不同时返回FALSE。
// 值为FALSE时hashcode相同，但子类值相同时返回TRUE。
//。。。百度为啥要重写equals和hashcode方法。。。
@EqualsAndHashCode(callSuper=true)
@Data
public class NoteVo extends ResultVo{
    // 日记类型id
    private Integer typeId;
    // 日记类型名称
    private String typeName;
    // 日记的数量
    private Integer noteCount;
    // 分组的名称
    private String groupName;
}
