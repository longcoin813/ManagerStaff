package com.java.controller;

import com.java.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.java.dao.UserDao;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

	@Autowired
	private UserDao dao;

	@RequestMapping("user/user")
	public String userList(Model model) {
		model.addAttribute("form", new Users());
		return "user/userList";
	}

	@RequestMapping("user/create")
	public String userSave(Model model, Users user) {
		dao.save(user);
		model.addAttribute("form", new Users());
		return "user/userList";
	}

	@GetMapping("user/delete/{username}")
	public RedirectView delete(Model model, @PathVariable(name = "username") String username) {
		dao.deleteById(username);
		return new RedirectView("/user/user");
	}

	@GetMapping(value = "user/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Users edit(Model model, @PathVariable("id") String username) {
		Optional<Users> usersOptional = dao.findById(username);
		return usersOptional.orElse(null);
	}

	@PostMapping("user/update")
	public RedirectView updateUserProfile(Model model, @ModelAttribute("editUser") Users user) {
		dao.save(user);
		return new RedirectView("/user/user");
	}

	@ModelAttribute(name = "users")
	public List<Users> getAllUsers(){
		return dao.findAll();
	}

	@ModelAttribute(name = "editUser")
	public Users initEditUser(){
		return new Users();
	}

}
