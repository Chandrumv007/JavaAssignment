package com.te.securewithspringsecurity.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.securewithspringsecurity.dto.User;

public interface UserDao extends CrudRepository<User, Integer> {
	public User findByUserName(String name);
	public User findByUserId(int id);
}
