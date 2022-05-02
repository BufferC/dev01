package com.fc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User", description = "用户实体类")
public class User {
    @ApiModelProperty("用户编号")
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;
}
