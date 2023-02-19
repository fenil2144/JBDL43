package com.example.minorProject2.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class CacheConfig {
	
	@Bean
	public LettuceConnectionFactory getConnectionFactory() {
		
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
				"redis-11918.c264.ap-south-1-1.ec2.cloud.redislabs.com",11918);
		redisStandaloneConfiguration.setPassword("S5WEmF0RxQWFby9sRsz9sDcUsG55gQ3m");
		
		return new LettuceConnectionFactory(redisStandaloneConfiguration);

	}
	
	@Bean
	public RedisTemplate<String, Object> getTemplate(){
		
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getConnectionFactory());
		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
		
		return redisTemplate;
	}
	
	@Bean 
	public ObjectMapper getMapper() {
		return new ObjectMapper();
	}

}
