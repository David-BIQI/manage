package com.biqi.service;

import com.biqi.dao.UserDao;
import com.biqi.dto.UserDto;
import com.biqi.model.User;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import static com.common.check.CheckUtil.notNull;

@Service
@Slf4j
public class RedisTestService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, UserDto> redisTemplate;


    public String saveAndGet(String name) {
        stringRedisTemplate.opsForValue().set(name, name);
		String temp = stringRedisTemplate.opsForValue().get(name);
        return temp;
    }

    public Boolean saveUserByJson(Integer id) {
        User user = userService.getUserByid(id);
        notNull(user,"用户信息不存在");
        JSONObject json = JSONObject.fromObject(user);
        JSONArray array=JSONArray.fromObject(user);
        String strJson=json.toString();
        String strArray=array.toString();
        log.info("strJson:{}",strJson);
        log.info("strArray:{}",strArray);
        stringRedisTemplate.opsForValue().set("id:"+user.getId()+user.getName(), strJson);
        return true;
    }

    public Boolean saveUserBySerializer(Integer id) {
        User user = userService.getUserByid(id);
        notNull(user,"用户信息不存在");
        UserDto temp = new UserDto();
        temp.setName(user.getName());
        temp.setPhone(user.getPhone());
        redisTemplate.opsForValue().set(user.getName(), temp);

        return true;
    }

    public UserDto getUserBySerializer(String name) {
        UserDto temp = redisTemplate.opsForValue().get(name);
        log.info("UserDto:{}",temp.toString());
        return temp;
    }
}
