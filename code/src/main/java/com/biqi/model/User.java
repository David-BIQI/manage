package com.biqi.model;
/**   
 * Description: 用户表
 * @Package com.biqi.model 
 * @author  xiebq @date    2018年6月6日 下午10:52:00 
 */

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name = "User")
@Api(value="用户表")
public class User {
	
	public static final int SEX_MALE =1;
	public static final int SEX_FEMALE =0;
	
	
	@Id
	private Integer id;

    @ApiModelProperty(value = "用户名",required = true)
	private String name;

    @ApiModelProperty(value = "密码", required = true)
	private String password;

    @ApiModelProperty(value = "电话")
	private String phone;

    @ApiModelProperty(value = "1代表男，0代表女")
	private Integer sex;

	private Date created;

	private Integer createby;

	private Date updated;

	private Integer updateby;

}
