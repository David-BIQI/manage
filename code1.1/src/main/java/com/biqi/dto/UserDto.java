package com.biqi.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**   
 * Description: TODO
 * @Package com.biqi.dto 
 * @author  xiebq @date    2018年6月16日 下午5:06:59 
 */
@Data
@ToString
@Api(value="用户登陆以后的Dto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{

	private static final long serialVersionUID = -1L;
	
    @ApiModelProperty(value = "用户id")
	private Integer id;
	
	@ApiModelProperty(value = "用户名")
	private String name;
	
    @ApiModelProperty(value = "电话")
	private String phone;
    
    @ApiModelProperty(value = "token")
	private String token;

	
}
