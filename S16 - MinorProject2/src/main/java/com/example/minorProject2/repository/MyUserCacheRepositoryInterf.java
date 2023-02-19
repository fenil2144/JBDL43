package com.example.minorProject2.repository;

import com.example.minorProject2.models.MyUser;

public interface MyUserCacheRepositoryInterf {
	
	public void set(MyUser myUser);
	public MyUser get(String username);

}
