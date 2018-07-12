package com.common.onlineUser;

import java.util.List;

import com.biqi.dto.UserOnline;

/**   
 * Description: TODO
 * @Package com.common.onlineUser 
 * @author  xiebq @date    2018年6月29日 上午12:02:31 
 */
public class RedisOnlineUsers implements OnlineUserInterFace {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public UserOnline getUserOnline(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUser(UserOnline user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countUsers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserOnline> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
