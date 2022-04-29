package com.fc.vo;

import com.fc.entity.TbNote;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NoteVO extends TbNote {
    // 日记类型id
    private Integer typeId;
    // 日记类型名称
    private String typeName;
    // 日记的数量
    private Integer noteCount;
    // 分组的名称
    private String groupName;
}
