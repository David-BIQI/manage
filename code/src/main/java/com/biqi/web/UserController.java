package com.biqi.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biqi.model.User;
import com.biqi.model.validate.Create;
import com.biqi.model.validate.Update;
import com.biqi.service.UserService;
import com.common.constant.ReCode;
import com.common.result.PageDto;
import com.common.result.ResultDto;
import com.mysql.jdbc.log.Log;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**   
 * Description: 用户管理的基础类
 * @Package com.biqi.web 
 * @author  xiebq @date    2018年6月6日 下午10:56:24 
 */
@RestController
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/save")
    @ApiOperation(value = "保存用户")
	public ResultDto<Integer> saveUser(@RequestBody @Validated(value={Create.class})User user,BindingResult bindingResult){
		ResultDto<Integer> resultDto = new ResultDto<>();
		//分组校验处理，返回的处理
        StringBuilder sb = new StringBuilder();  
        if(bindingResult.hasErrors()) {  
            List<ObjectError> errors = bindingResult.getAllErrors();  
            for (ObjectError err : errors) {  
                sb.append(err.getDefaultMessage()+" ;");  
            }  
            resultDto.setMsg(sb.toString());
            resultDto.setCode(ReCode.FAIL_PARAMETER_ERROR.getCode());
            return resultDto;  
        } 
		
		
		resultDto.setData(userService.saveUser(user));
		return resultDto;
	}
	
	
	@PostMapping("/user/delete")
    @ApiOperation(value = "删除用户")
	public ResultDto<Boolean> deleteUser(@RequestParam Integer id){
		ResultDto<Boolean> resultDto = new ResultDto<>();
		resultDto.setData(userService.deleteUser(id));
		return resultDto;
	}
	
	
	@PostMapping("/user/update")
    @ApiOperation(value = "更新用户")
	public ResultDto<Boolean> updateUser(@RequestBody @Validated(value={Update.class})User user,BindingResult bindingResult){
		ResultDto<Boolean> resultDto = new ResultDto<>();
		//分组校验处理，返回的处理
        StringBuilder sb = new StringBuilder();  
        if(bindingResult.hasErrors()) {  
            List<ObjectError> errors = bindingResult.getAllErrors();  
            for (ObjectError err : errors) {  
                sb.append(err.getDefaultMessage()+";");  
            }  
            resultDto.setMsg(sb.toString());
            resultDto.setCode(ReCode.FAIL_PARAMETER_ERROR.getCode());
            return resultDto;  
        }  
		
		resultDto.setData(userService.updateUser(user));
		return resultDto;
	}
	
	
	
	@GetMapping("/user/getUserByid")
    @ApiOperation(value = "根据id查询用户")
	public ResultDto<User> getUserByid(@RequestParam Integer id){
		ResultDto<User> resultDto = new ResultDto<>();
		resultDto.setData(userService.getUserByid(id));
		return resultDto;
	}
	
	
	@GetMapping("/user/list")
    @ApiOperation(value = "获得用户列表")
	public ResultDto<PageDto<User>> listUser(){
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.listUser());
		return resultDto;
	}
	
	
	@GetMapping("/user/testList")
    @ApiOperation(value = "后台处理数据使用到流")
	public ResultDto<PageDto<User>> testList(){
		
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.testList());
		return resultDto;
	}
	
	@GetMapping("/user/testparalle")
    @ApiOperation(value = "测试并行流")
	public ResultDto<PageDto<User>> testparalle(){
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.testparalle());
		return resultDto;
	}
	
	@GetMapping("/user/testLog")
    @ApiOperation(value = "测试并行流")
	public ResultDto<Boolean> testLog(){
		log.info("info ....");
		log.debug("debug ...");
		
		
		ResultDto<Boolean> resultDto = new ResultDto<>();
		return resultDto;
	}

}
