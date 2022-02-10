package com.te.securewithspringsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.securewithspringsecurity.dao.UserDao;
import com.te.securewithspringsecurity.dto.MyUserDetails;
import com.te.securewithspringsecurity.dto.User;
@Service
public class UserServiceImpl implements UserDetailsService  {
	@Autowired
	private UserDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=dao.findByUserName(username);
		if(user!=null) {
			return new  MyUserDetails(user);
		}
		throw new UsernameNotFoundException(username);
	}
	
	public List<User> findAllUserDetails() {
		return (List<User>) dao.findAll();
		
	}
	public User getData(int id) {
		return dao.findByUserId(id);
		
	}
	public User saveData(User user) {
		return dao.save(user);

	}

}
