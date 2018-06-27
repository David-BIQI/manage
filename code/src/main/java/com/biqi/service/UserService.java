package com.biqi.service;

import static com.common.check.CheckUtil.notNull;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biqi.dao.UserDao;
import com.biqi.model.User;
import com.common.result.PageDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

/**   
 * @Package com.biqi.service 
 * @author  xiebq @date    2018年6月6日 下午11:17:48 
 */
@Service
@Slf4j
public class UserService {
	
	public static final Integer SUPER_USER_ID = 1;

	@Autowired
	private UserDao userDao;
	
	public User getUserByid(Integer id) {
		User user = userDao.selectByPrimaryKey(id);
		return user;
	}

	public Integer saveUser(User user) {
		user.setId(null);
		user.setCreateby(SUPER_USER_ID);
		user.setCreated(new Date());
		userDao.insertUseGeneratedKeys(user);
		return user.getId();
	}

	public Boolean deleteUser(Integer id) {
		User oldUser = userDao.selectByPrimaryKey(id);
		notNull(oldUser, "用户id:"+id+" 不存在");
		userDao.deleteByPrimaryKey(id);
		return true;
	}

	public Boolean updateUser(User user) {
		User oldUser = userDao.selectByPrimaryKey(user.getId());
		notNull(oldUser, "用户id:"+user.getId()+" 不存在");
		user.setUpdateby(SUPER_USER_ID);
		user.setUpdated(new Date());
		userDao.updateByPrimaryKeySelective(user);
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
		list.stream().filter(user->("SuperUser").equals(user.getName())).forEach(user->System.out.println(user.toString()));
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

	
	public PageDto<User> listPage(Integer page, Integer size) {
		//tk mybatis进行查询
        Example example = new Example(User.class);
        //分页查询
        PageHelper.startPage(page, size);
        //添加查询条件
        //example.createCriteria().andEqualTo("id",XX);
        example.orderBy("created").desc();
        List<User> list = userDao.selectByExample(example);
        //分页查询-->若凡在这里，不能进行分页 PageHelper.startPage(page, size);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
		return new PageDto<>(list, pageInfo.getTotal());
	}

	public Integer countUser() {
		return userDao.countUser();
//		return null;
	}

	public Integer countUser2() {
		return userDao.countUser2();
	}

}
