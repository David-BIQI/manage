package com.biqi.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biqi.dao.UserDao;
import com.biqi.model.User;
import com.common.result.PageDto;
import com.google.common.base.Suppliers;

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

	public PageDto<User> testList() {
		List<User> list = userDao.selectAll();
		log.debug("java8 Stream 流过滤数据 输出");
		list.stream().filter(user->user.getName().equals("SuperUser")).forEach(user->System.out.println(user.toString()));
		log.info("java8 Stream 流过统计数据{}",list.stream().filter(user->user.getId()<10).count());
		log.info("java8 Stream 流过滤数据 然后返回流");
		List<User> list2 = list.stream().filter(user->user.getId()>23).collect(Collectors.toList());
		PageDto<User> data = new PageDto<>(list2, list2.size());
		return data;
	}

	
	public PageDto<User> testparalle() {
		Random random = new Random();
		Stream<String> parallel = Stream.generate(() -> random.nextInt()).limit(20).map(i -> "" + i)
				// 第1个无状态操作
				.peek(s -> log.debug("peek: " + s))
				// 第2个无状态操作
				.filter(s -> {
					log.debug("filter: " + s);
					return s.startsWith("1");
				})
				// 有状态操作
				.sorted((i1, i2) -> {
					log.debug("排序: " + i1 + ", " + i2);
					return i1.compareTo(i2);
				})
				// 又一个无状态操作
				.peek(s -> {
					log.debug("peek2: " + s);
				}).parallel();
		parallel.count();
		
		List<User> list = userDao.selectAll();
		PageDto<User> data = new PageDto<>(list, list.size());
		return data;
	}

}
