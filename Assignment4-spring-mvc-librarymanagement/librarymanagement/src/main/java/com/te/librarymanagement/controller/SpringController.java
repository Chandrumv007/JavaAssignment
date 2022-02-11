package com.te.librarymanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.librarymanagement.bean.Author;
import com.te.librarymanagement.bean.LibraryBooks;
import com.te.librarymanagement.service.AuthorService;

@Controller
public class SpringController {
	@Autowired
	private AuthorService service;

	@GetMapping("/login")
	public String login() {
		return "loginform";
	}

	@PostMapping("/home")
	public String home(int id, String password, ModelMap map, HttpServletRequest request) {

		Author author = service.authenticate(id, password);
		HttpSession session = request.getSession();
		session.setAttribute("loggedIn", author);
		if (author != null) {
			map.addAttribute("data", author.getName());
			return "welcome";
		} else {
			map.addAttribute("err", "Invalid author");
			return "loginform";
		}

	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/Home")
	public String signup(Author author, ModelMap map, HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.setAttribute("loggedIn", author);

		if (service.addData(author)) {
			map.addAttribute("data", author.getName());
			return "welcome";
		} else {
			map.addAttribute("err", "Please Enter Correct author ");
			return "signup";
		}

	}

	@GetMapping("/add")
	public String addForm(@SessionAttribute(name = "loggedIn", required = false) Author author,
			ModelMap map) {
		if (author != null) {
			map.addAttribute("author", author);
			return "addDetails";
			
		} else {
			map.addAttribute("err", "please login first!");
			return "loginform";

		}

	}

	@PostMapping("/add")
	public String addData(LibraryBooks book, ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) Author author) {
		if (author != null) {
			if (service.addBook(book, author)) {
				map.addAttribute("msg", "Data Inserted Successfully!");
				map.addAttribute("author", author);
			} else {
				map.addAttribute("err", "Something Went Wrong!");
				map.addAttribute("author", author);
			}
			return "addDetails";
		} else {
			map.addAttribute("err", "please login first!");
			return "loginform";

		}

	}

	@GetMapping("/delete")
	public String deleteData(@SessionAttribute(name = "loggedIn", required = false) Author author,
			ModelMap map) {
		if (author != null) {
			return "deleteForm";
		} else {
			map.addAttribute("err", "please login first!");
			return "loginform";
		}
	}

	@PostMapping("/delete")
	public String deleteData(int id, @SessionAttribute(name = "loggedIn", required = false) Author author,
			ModelMap map) {

		if (author != null) {
			if (service.deleteData(id,author.getName())) {
				map.addAttribute("msg", "data deleted successfully!");
			} else {
				map.addAttribute("msg", "Sorry! Failed to Delete.., You Are Not the Owner of the Book!..");
			}
			return "deleteForm";

		} else {
			map.addAttribute("err", "please login first!");
			return "loginform";
		}
	}

	@GetMapping("/showdata")
	public String showData(@SessionAttribute(name = "loggedIn", required = false) Author author,
			ModelMap map) {
		if (author != null) {
			return "showdata";
		} else {
			map.addAttribute("err", "please login first!");
			return "loginform";
		}
	}

	@PostMapping("/showdata")
	public String showData(@SessionAttribute(name = "loggedIn", required = false) Author author, ModelMap map,
			int id) {
		if (author != null) {
			LibraryBooks book = service.showData(id);
			if (book != null) {
				map.addAttribute("data", book);
			} else {
				map.addAttribute("err", "Data not found for id:" + id);
			}
			return "showdata";
		} else {
			map.addAttribute("err", "please login first!");
			return "loginform";
		}
	}

	@GetMapping("/showall")
	public String showDataAll(@SessionAttribute(name = "loggedIn", required = false) Author author,
			ModelMap map) {
		if (author != null) {
			List<LibraryBooks> books = service.showDataAll();
			if (books != null) {
				map.addAttribute("data", books);
			} else {
				map.addAttribute("err", "Data not found ");
			}
			return "showall";
		} else {
			map.addAttribute("err", "please login first!");
			return "loginform";
		}
	}

	@GetMapping("/update")
	public String update(@SessionAttribute(name = "loggedIn", required = false) Author author, ModelMap map) {
		if (author != null) {
			List<LibraryBooks> books = service.showDataAll(author.getName());
			map.addAttribute("author", author);
			map.addAttribute("books", books);
			return "update";
		} else {
			map.addAttribute("err", "please login first!");
			return "loginform";
		}
	}

	@PostMapping("/update")
	public String update(LibraryBooks book,
			@SessionAttribute(name = "loggedIn", required = false) Author author, ModelMap map) {
		if (author != null) {
			List<LibraryBooks> books = service.showDataAll(author.getName());
			if (service.update(book, author)) {
				map.addAttribute("msg", "data Updated Successfully");
				map.addAttribute("author", author);
				map.addAttribute("books", books);

			} else {
				map.addAttribute("msg", "something went wrong!");
				map.addAttribute("author", author);
				map.addAttribute("books", books);
			}
			return "update";
		} else

		{
			map.addAttribute("err", "please login first!");
			return "loginform";
		}
	}
	@GetMapping("/forgotpass")
	public String forgotPass(ModelMap map) {
		map.addAttribute("msg", false);
		return "forgotpass";
		
	}

	@PostMapping("/forgotpass")
	public String forgotPass(String password,int id,ModelMap map) {
		if (service.changePassword(password, id)) {
			map.addAttribute("msg", true);
		}else {
			map.addAttribute("err1", "Id not found!...");
			map.addAttribute("msg", false);
		}
		return "forgotpass";

	}

	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("err", "Logged Out Successfully");
		return "loginform";
	}

}
