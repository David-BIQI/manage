package com.biqi.dto;

import java.util.Date;
import javax.validation.constraints.Size;
import com.biqi.model.validate.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**   
 * @Package com.biqi.dto
 * @author  xiebq @date    2018年6月16日 下午5:13:03 
 */
@Data
@ToString
@Api(value="用户登陆传入的对象")
public class LoginDto {
	
	@ApiModelProperty(value = "用户名")
    @Size(min = 1, max = 8,message="名字长度不必须是2-8个字符",groups = {Login.class})
	private String username;
	
	@ApiModelProperty(value = "密码")
    @Size(min = 1, max = 8,message="登陆密码输入长度错误",groups={Login.class})
	private String password;
	
//	@ApiModelProperty(value = "登陆时间")
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	private Date loginTime;
//
//	@ApiModelProperty(value = "签名证书")
//	private String sign;

}
