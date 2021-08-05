package com.java.service;

import javax.servlet.http.HttpSession;

import com.java.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
	@Autowired
	HttpSession session;

	public Users getUser() {
		return (Users) session.getAttribute("user");
	}

	public void addUser(Users user) {
		session.setAttribute("user", user);
	}

	public void removeUser() {
		session.removeAttribute("user");
	}

	public String getSecurityUrl() {
		return (String) session.getAttribute("security-url");
	}

	public void addSecurityUrl(String securityUrl) {
		session.setAttribute("security-url", securityUrl);
	}

	public void removeSecurityUrl() {
		session.removeAttribute("security-url");
	}

	public void clear() {
		session.invalidate();
	}

}
