package com.te.librarymanagement.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class LibraryBooks implements Serializable {
	@Id
	@Column(name = "b_id")
	private int id;
	@Column(name = "b_name")
	private String name;
	@Column(name = "b_author")
	private String authorname;
	@Column(name = "b_price")
	private int price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="a_fk")
	private Author author;
	

}
