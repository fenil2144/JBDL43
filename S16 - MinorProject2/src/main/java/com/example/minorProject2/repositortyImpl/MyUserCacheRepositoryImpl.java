package com.example.minorProject2.repositortyImpl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.minorProject2.models.MyUser;
import com.example.minorProject2.repository.MyUserCacheRepositoryInterf;

@Repository
public class MyUserCacheRepositoryImpl implements MyUserCacheRepositoryInterf{
	
	private String USER_KEY_PREFIX = "usrDetails::";
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Override
	public void set(MyUser myUser) {
		String key = getKey(myUser.getUsername());
		redisTemplate.opsForValue().set(key, myUser,12,TimeUnit.HOURS);
	}

	@Override
	public MyUser get(String username) {
		return (MyUser) redisTemplate.opsForValue().get(getKey(username));
	}
	
	private String getKey(String username) {
		return USER_KEY_PREFIX+username;
	}
	
}
