package com.te.librarymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.te.librarymanagement.bean.Author;
import com.te.librarymanagement.bean.LibraryBooks;
import com.te.librarymanagement.exception.AuthorException;

@Repository
public class DaoLayerImpl implements DaoLayer {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public Author authenticate(int id, String name) {
		EntityManager manager = factory.createEntityManager();

		Author employee = manager.find(Author.class, id);
		if (employee != null) {
			if (employee.getPassword().equals(name)) {
				return employee;
			} else {
				throw new AuthorException("Invalid Password,Please check!");
			}
		} else {
			throw new AuthorException("Invalid ID");
		}
	}

	@Override
	public boolean addData(Author details) {
		EntityTransaction transaction = null;
		boolean result = false;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(details);
			transaction.commit();
			result = true;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addBook(LibraryBooks book, Author author) {
		EntityTransaction transaction = null;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			Author author2 = manager.find(Author.class, author.getId());
			if (author2 != null) {
				LibraryBooks book1 = new LibraryBooks();
				book1.setId(book.getId());
				book1.setName(book.getName());
				book1.setAuthorname(author2.getName());
				book1.setPrice(book.getPrice());

				List<LibraryBooks> books = new ArrayList<LibraryBooks>();
				books.add(book1);
				book1.setAuthor(author2);
				author2.setBooks(books);
				transaction.begin();
				manager.persist(author2);
				transaction.commit();
				return true;
			} else
				return false;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteData(int id, String authorName) {
		EntityTransaction transaction = null;
		boolean result = false;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
				String query1 = "delete from LibraryBooks where b_author=:name and b_id=:id";
				Query alldata1 = manager.createQuery(query1);
				alldata1.setParameter("name", authorName);
				alldata1.setParameter("id", id);
				transaction.begin();
				alldata1.executeUpdate();
				transaction.commit();
				result=true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public LibraryBooks showData(int id) {
		EntityManager manager = factory.createEntityManager();
		LibraryBooks book = manager.find(LibraryBooks.class, id);
		if (book != null) {
			return book;
		}

		return null;
	}

	@Override
	public List<LibraryBooks> showDataAll() {
		EntityManager manager = factory.createEntityManager();
		String query = "from LibraryBooks";
		Query alldata = manager.createQuery(query);
		List<LibraryBooks> book = alldata.getResultList();
		if (book != null) {
			return book;
		}

		return null;
	}

	@Override
	public List<LibraryBooks> showDataAll(String aName) {
		EntityManager manager = factory.createEntityManager();
		String query = "from LibraryBooks where b_author=:name";
		Query alldata = manager.createQuery(query);
		alldata.setParameter("name", aName);
		List<LibraryBooks> book = alldata.getResultList();
		if (book != null) {
			return book;
		}

		return null;
	}

	@Override
	public boolean update(LibraryBooks book, Author author) {
		EntityTransaction transaction = null;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String query = "from LibraryBooks where b_author=:name and b_id=:id";
			Query alldata = manager.createQuery(query);
			alldata.setParameter("name", author.getName());
			alldata.setParameter("id", book.getId());
			List<LibraryBooks> books = alldata.getResultList();
			if (books != null) {
				for(LibraryBooks list: books) {
					list.setName(book.getName());
					list.setPrice(book.getPrice());
					transaction.begin();
					manager.persist(list);
					transaction.commit();
				}

				return true;
			}
			return false;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean changePassword(String password, int id) {
		EntityTransaction transaction = null;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			Author author = manager.find(Author.class, id);
			if (author != null) {
				author.setPassword(password);

				transaction.begin();
				manager.persist(author);
				transaction.commit();
				return true;
			}
			return false;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

}
