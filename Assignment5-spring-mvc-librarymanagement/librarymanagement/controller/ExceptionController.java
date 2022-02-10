package com.te.librarymanagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.librarymanagement.exception.AuthorException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(AuthorException.class)
	public String loginException(HttpServletRequest request,AuthorException handler) {
		request.setAttribute("err", handler.getMessage());
		return "loginform";
	}
}
