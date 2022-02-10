package com.te.librarymanagement.service;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.te.librarymanagement.bean.Author;
import com.te.librarymanagement.bean.LibraryBooks;
import com.te.librarymanagement.dao.DaoLayer;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private DaoLayer dao;

	public Author authenticate(int id, String name) {
		if (id <= 0) {
			return null;
		}
		return dao.authenticate(id, name);
	}

	@Override
	public boolean addData(Author details) {

		return dao.addData(details);
	}

	@Override
	public boolean addBook(LibraryBooks book, Author author) {
		return dao.addBook(book, author);
	}

	@Override
	public boolean deleteData(int id,String authorName) {
		if (id <= 0) {
			return false;
		}
		return dao.deleteData(id,authorName);
	}

	@Override
	public LibraryBooks showData(int id) {
		if (id <= 0) {
			return null;
		}
		return dao.showData(id);
	}

	@Override
	public List<LibraryBooks> showDataAll() {
		return dao.showDataAll();
	}

	@Override
	public List<LibraryBooks> showDataAll(String aName) {
		return dao.showDataAll(aName);
	}

	@Override
	public boolean update(LibraryBooks book, Author author) {
		return dao.update(book, author);
	}

	@Override
	public boolean changePassword(String password, int id) {
		return dao.changePassword(password, id);
	}
}

