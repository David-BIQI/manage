package com.biqi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biqi.model.User;
import com.biqi.service.UserService;
import com.common.result.ResultDto;

/**   
 * Description: TODO
 * @Package com.biqi.web 
 * @author  xiebq @date    2018年6月6日 下午10:56:24 
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/User/getUserByid")
	public ResultDto<User> getUserByid(@RequestParam Integer id){
		ResultDto<User> resultDto = new ResultDto<>();
		resultDto.setData(userService.getUserByid(id));
		return resultDto;
	}
	

}
