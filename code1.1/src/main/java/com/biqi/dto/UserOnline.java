package com.biqi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 在线用户的信息
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserOnline implements Serializable {

    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "用户id")
	private Integer id;
    
    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "登录ip")
    private String loginIp;

    @ApiModelProperty(value = "用户角色")
    private Integer nameRole;


}
