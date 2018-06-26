package com.biqi.web;

import com.biqi.dto.LoginDto;
import com.biqi.dto.UserDto;
import com.biqi.model.validate.Login;
import com.biqi.service.LoginService;
import com.common.constant.ReCode;
import com.common.result.ResultDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**   
 * @Package com.biqi.web 
 * @author  xiebq @date    2018年6月16日 下午5:03:26 
 */
@RestController
@Api(tags = {"用户登陆Api文档"})
public class LoginConTroller {
	
	@Autowired
	private LoginService loginService;
	
	public ResultDto<UserDto> login(@RequestBody @Validated(value = { Login.class }) LoginDto loginDto,
									BindingResult bindingResult) {
		ResultDto<UserDto> resultDto = new ResultDto<>();
		StringBuilder sb = new StringBuilder();
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			errors.forEach(item -> sb.append(item.getDefaultMessage() + ";"));
			resultDto.setMsg(sb.toString());
			resultDto.setCode(ReCode.FAIL_PARAMETER_ERROR.getCode());
			resultDto.setData(null);
			return resultDto;
		}
		resultDto.setData(loginService.login(loginDto));
		return resultDto;
	}
	

}
