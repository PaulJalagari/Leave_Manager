package com.leave.controller;

import java.util.List;

import com.leave.dao.UserDAO;
import com.leave.dto.Users;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	private String name, password;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginAction() {
		userDao = new UserDAO();
	}

	public String execute() {
		if (userDao.find(getName(), getPassword()))
			return "success";
		else
			this.addActionError("Invalid username and password");
		return "error";
	}

}
