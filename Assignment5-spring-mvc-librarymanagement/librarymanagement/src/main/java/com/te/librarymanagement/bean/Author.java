package com.te.librarymanagement.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class Author implements Serializable{
	@Id
	@Column(name = "a_id")
	private int id;
	@Column(name = "a_name")
	private String name;
	@Column(name = "a_password")
	private String password;
	
	@javax.persistence.Transient
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<LibraryBooks> books;

}
