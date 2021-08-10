package com.java.controller;

import com.java.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.java.dao.UserDao;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
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
    public String userSave(ModelMap model, @Valid @ModelAttribute("form") Users user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if(dao.existsById(user.getUsername())) {
                model.addAttribute("mega", "user đã tồn tại!");
            }else {
                dao.save(user);
                model.addAttribute("mega", "Thêm thành công");
            }


        } else {
            model.addAttribute("form", user);
            model.addAttribute("mega", "Thêm thất bại");
        }
        model.addAttribute("users", dao.findAll());
        return "user/userList";
    }

    @GetMapping("user/delete/{username}")
    public String delete(Model model, @PathVariable(name = "username") String username) {
        Optional<Users> option = dao.findById(username);
        if(!dao.existsById(username)) {
            model.addAttribute("mega", "user tồn tại!");
        } else {
            dao.deleteById(username);
            model.addAttribute("mega", "Xóa thành công!");
        }
        model.addAttribute("users", dao.findAll());
        return "user/userList";

    }

    @GetMapping(value = "user/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Users edit(Model model, @PathVariable("id") String username) {
        Optional<Users> usersOptional = dao.findById(username);
        return usersOptional.orElse(null);
    }

    @PostMapping("user/update")
    public String updateUserProfile(Model model, @ModelAttribute("editUser") Users user) {
        if(!dao.existsById(user.getUsername())) {
            model.addAttribute("mega", "user không tồn tại!");
        }else {
            dao.save(user);
            model.addAttribute("mega", "Cập nhật thành công!");
        }
        model.addAttribute("users", dao.findAll());
        return "user/userList";
    }

    @ModelAttribute(name = "users")
    public List<Users> getAllUsers() {
        return dao.findAll();
    }

    @ModelAttribute(name = "editUser")
    public Users initEditUser() {
        return new Users();
    }

    @ModelAttribute(name = "form")
    public Users initUser() {
        return new Users();
    }


}
