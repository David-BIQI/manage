package com.biqi.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

//	@Autowired
//	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() throws Exception {

		// 保存字符串
		stringRedisTemplate.opsForValue().set("626111", "626111");
		Assert.assertEquals("626111", stringRedisTemplate.opsForValue().get("aaa"));

//		// 保存对象
//		User user = new User("超人2", 20);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//
//		user = new User("蝙蝠侠2", 30);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//
//		user = new User("蜘蛛侠2", 40);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//
//		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
//		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

	}

}
