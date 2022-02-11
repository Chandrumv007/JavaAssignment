package com.te.securewithspringsecurity.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class User implements Serializable {
	@Id
	private int userId;
	private String userRealName;
	private int userAge;
	private String userAddress;
	private String userName;
	private String userPassword;
	private String userRole;

}
