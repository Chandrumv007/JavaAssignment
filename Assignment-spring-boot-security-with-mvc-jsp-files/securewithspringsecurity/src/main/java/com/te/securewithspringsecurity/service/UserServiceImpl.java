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
	public User getData(String name) {
		return dao.findByUserName(name);
		
	}
	public boolean deleteUser(int id) {
		User user = dao.findByUserId(id);
		if(user!=null) {
		 dao.deleteById(id);
		 return true;
		}
		else return false;
		
	}
	public User getByUserName(String name) {
		return dao.findByUserName(name);
		
	}
	public User saveData(User user) {
		return dao.save(user);

	}
	public boolean saveData1(User user) {
		User user1 = dao.save(user);
		if(user1!=null) {
			return true;
		}else return false;

	}


}
