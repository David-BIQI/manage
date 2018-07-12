package com.common.onlineUser;

import org.springframework.beans.factory.annotation.Value;

/**   
 * Description: TODO 怎么控制一个类不被spring收回呢？
 * @Package com.common.onlineUser 
 * @author  xiebq @date    2018年6月29日 上午12:20:48 
 */
public class OnlineUser {
	
	/**
	 * 通过spring读取配置
	 */
	@Value("${mqtt.onlinetpye}")
	private String onlinetpye;
	
	private static volatile OnlineUserInterFace managerUsers;
	
	public OnlineUserInterFace getOnlineUser() {
		if (null == managerUsers) {
			if (onlinetpye.equals("java")) {
				managerUsers = new JavaOnlineUsers();
			}else {
				managerUsers = new RedisOnlineUsers();
			}
			return managerUsers;
		}
		else {
			return managerUsers;
		}
	}

}
