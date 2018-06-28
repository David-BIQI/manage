package com.common.onlineUser;

import java.util.List;

import com.biqi.dto.UserOnline;

/**   
 * Description: 在线用户接口
 * @Package com.common.onlineUser 
 * @author  xiebq @date    2018年6月28日 下午10:59:03 
 */
public interface OnlineUserInterFace {
	
	/**
	 * 在线用户初始化
	 */
	void init();
	
	
	/**
	 * 通过token获得在线用户信息
	 * @param token
	 * @return
	 */
	UserOnline getUserOnline(String token);
	
	/**
	 * 添加在线用户
	 * @param user
	 * @return
	 */
	String addUser(UserOnline user);
	
	
	
	/**
	 * 移除在线用户
	 * @param token
	 * @return
	 */
	boolean removeUser(String token);
	
	/**
	 * 在在线用户计数
	 * @return
	 */
	int countUsers();
	
	/**
	 * 在线用户列表
	 * @return
	 */
	List<UserOnline> list();
	
	
	
	
	

}
