package com.biqi.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biqi.dao.UserDao;
import com.biqi.model.User;
import com.common.result.PageDto;

import lombok.extern.slf4j.Slf4j;

/**   
 * @Package com.biqi.service 
 * @author  xiebq @date    2018年6月6日 下午11:17:48 
 */
@Service
@Slf4j
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserByid(Integer id) {
		User user = userDao.selectByPrimaryKey(id);
		return user;
	}

	public Integer saveUser(User user) {
		user.setId(null);
		userDao.insertUseGeneratedKeys(user);
		return user.getId();
	}

	public Boolean deleteUser(Integer id) {
		User temp = userDao.selectByPrimaryKey(id);
		if (null != temp) {
			userDao.deleteByPrimaryKey(id);
		}
		return true;
	}

	public Boolean updateUser(User user) {
		User temp = userDao.selectByPrimaryKey(user.getId());
		if (null != temp) {
			userDao.updateByPrimaryKeySelective(user);
		}
		return true;
	}

	public PageDto<User> listUser() {
		List<User> list = userDao.selectAll();
		PageDto<User> data = new PageDto<>(list, list.size());
		return data;
	}


}
