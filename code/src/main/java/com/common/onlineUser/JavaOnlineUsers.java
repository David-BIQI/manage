package com.common.onlineUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.biqi.dto.UserOnline;

/**   
 * Description: TODO
 * @Package com.common.onlineUser 
 * @author  xiebq @date    2018年6月29日 上午12:03:01 
 */
public class JavaOnlineUsers implements OnlineUserInterFace {
	
	
	public static final HashMap<String, UserOnline> list = new HashMap<>();

	@Override
	public void init() {

	}

	@Override
	public UserOnline getUserOnline(String token) {
		if (token == null) {
			return null;
		}
		return list.get(token);
	}

	@Override
	public String addUser(UserOnline user) {
		list.put(user.getToken(), user);
		return user.getToken();
	}

	@Override
	public boolean removeUser(String token) {
		list.remove(token);
		return false;
	}

	@Override
	public int countUsers() {
		return list.size();
	}

	@Override
	public List<UserOnline> list() {
		List<UserOnline> temp = new ArrayList<>(list.values().size());
		list.values().forEach(item->{
			temp.add(item);
		});
		return temp;
	}

}
