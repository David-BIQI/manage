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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.biqi.model.validate.Create;
import com.biqi.model.validate.Update;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@Table(name = "User")
@Api(value="用户表")
@ToString
public class User {
	
	public static final int SEX_MALE =1;
	public static final int SEX_FEMALE =0;
	
	
	@Id
	@NotNull(message="用户的更新必须传入id",groups={Update.class})
	private Integer id;

    @ApiModelProperty(value = "用户名",required = true)
    @Size(min = 2, max = 8,message="名字长度不必须是2-8个字符",groups = {Create.class, Update.class})
	private String name;

    @ApiModelProperty(value = "密码")
    @Size(min = 6, max = 8,message="用户的新建密码长度为6-8",groups={Create.class})
    @Size(min = 8, max = 10,message="用户的更新密码长度为8-10",groups={Update.class})
	private String password;

    @ApiModelProperty(value = "电话")
	@Pattern(regexp="^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$",message="电话号码格式不正确",groups = {Create.class, Update.class})
	private String phone;

    @ApiModelProperty(value = "1代表男，0代表女")
	private Integer sex;

	private Date created;

	private Integer createby;

	private Date updated;

	private Integer updateby;

}
