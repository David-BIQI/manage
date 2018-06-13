package com.biqi.web;

import java.util.List;
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
import com.biqi.model.validate.Save;
import com.biqi.model.validate.Update;
import com.biqi.service.UserService;
import com.common.constant.ReCode;
import com.common.result.PageDto;
import com.common.result.ResultDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**   
 * Description: 用户管理的基础类
 * @Package com.biqi.web 
 * @author  xiebq @date    2018年6月6日 下午10:56:24 
 */
@RestController
@Slf4j
@Api(value="用户管理的基础类Api文档")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/save")
    @ApiOperation(value = "保存用户,使用@Validated分组{save}校验数据", notes="保存用户,使用@Validated分组{save}校验数据")
	public ResultDto<Integer> saveUser(@RequestBody @Validated(value={Save.class})User user,BindingResult bindingResult){
		ResultDto<Integer> resultDto = new ResultDto<>();
		//分组数据校验校验处理，返回的处理
        StringBuilder sb = new StringBuilder();  
        if(bindingResult.hasErrors()) {  
            List<ObjectError> errors = bindingResult.getAllErrors();  
            errors.forEach(item->sb.append(item.getDefaultMessage()+";"));
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
    @ApiOperation(value = "更新用户,使用@Validated分组{update}校验数据")
	public ResultDto<Boolean> updateUser(@RequestBody @Validated(value={Update.class})User user,BindingResult bindingResult){
		ResultDto<Boolean> resultDto = new ResultDto<>();
		//分组校验处理，返回的处理
        StringBuilder sb = new StringBuilder();  
        if(bindingResult.hasErrors()) {  
            List<ObjectError> errors = bindingResult.getAllErrors();  
            errors.forEach(item->sb.append(item.getDefaultMessage()+";")); 
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
	
	@GetMapping("/user/listPage")
    @ApiOperation(value = "获得用户列表")
	public ResultDto<PageDto<User>> listPage(@RequestParam Integer page,@RequestParam Integer size){
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.listPage(page,size));
		return resultDto;
	}
	
	@GetMapping("/user/countUser")
    @ApiOperation(value = "获得用户总数，在dao接口中写sql")
	public ResultDto<Integer> countUser(){
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setData(userService.countUser());
		return resultDto;
	}
	
	@GetMapping("/user/countUser2")
    @ApiOperation(value = "获得用户总数，在xml文件中写sql")
	public ResultDto<Integer> countUser2(){
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setData(userService.countUser2());
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
    @ApiOperation(value = "后台测试log级别的")
	public ResultDto<Boolean> testLog(){
		log.info("info ....");
		log.debug("debug ...");
		ResultDto<Boolean> resultDto = new ResultDto<>();
		return resultDto;
	}

}
