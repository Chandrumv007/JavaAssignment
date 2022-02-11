package com.te.librarymanagement.dao;

import java.util.List;

import com.te.librarymanagement.bean.Author;
import com.te.librarymanagement.bean.LibraryBooks;

public interface DaoLayer {
	Author authenticate(int id, String name);

	boolean addData(Author details);
	boolean addBook(LibraryBooks book,Author author);

	boolean deleteData(int id,String authorName);
	LibraryBooks showData(int id);
	List<LibraryBooks> showDataAll();
	List<LibraryBooks> showDataAll(String aName);


	boolean update(LibraryBooks book,Author author);
	boolean changePassword(String password,int id);


}
