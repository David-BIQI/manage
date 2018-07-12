package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.biqi.dto.UserDto;
import com.common.redis.RedisObjectSerializer;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/4/15 下午3:19.
 * @blog http://blog.didispace.com
 */
@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, UserDto> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, UserDto> template = new RedisTemplate<String, UserDto>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }


}
