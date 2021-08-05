package com.java.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.java.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dao.UserDao;
import com.java.service.CookieService;
import com.java.service.JsonUtils;
import com.java.service.SessionService;
import com.java.service.StrUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class LoginController {

    final UserDao dao;
    final SessionService session;
    final CookieService cookie;

    @Autowired
    public LoginController(UserDao dao, SessionService session, CookieService cookie) {
        this.dao = dao;
        this.session = session;
        this.cookie = cookie;
    }

    @GetMapping("/signin")
    public String login(Model model) {

        String value = cookie.getValue("user", "");
        if (value.length() > 0) {
            String json = StrUtils.decode64(value);
            model.addAttribute("map", JsonUtils.toObject(json, Map.class));
        } else {
            model.addAttribute("map", null);
        }
        return "account/signin";
    }

    @PostMapping("/signin")
    public String login(Model model,
                        RedirectAttributes redirectAttr,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(name = "remember", defaultValue = "false") boolean remember) {

        Optional<Users> userOptional = dao.findById(username);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            if (!user.getPassword().equals(password)) {
                model.addAttribute("message", "Sai username or pass");
            } else {
                session.addUser(user);
                model.addAttribute("message", "Đăng nhập thành công");

                if (remember) {
                    Map<String, String> map = new HashMap<String, String>() {
                        {
                            put("username", user.getUsername());
                            put("password", user.getPassword());
                        }
                    };
                    String json = JsonUtils.fromObject(map);
                    cookie.create("user", StrUtils.encode64(json), 30);
                } else {
                    cookie.delete("user");
                }
                String uri = session.getSecurityUrl();
                if (uri != null) {
                    return "redirect:" + uri;
                }
                return "redirect:/user/user";
            }
        }
        model.addAttribute("message", "Sai username or pass");
        return "account/signin";
    }

    @GetMapping("/signout")
    public String logoff() {
        session.clear();
        return "redirect:/signin";
    }

    @PostMapping("/register")
    public RedirectView register(Model model,
                           @ModelAttribute("userSignUp") Users user
    ) {
        System.out.println("User: " + user);
        dao.save(user);
        return new RedirectView("/user/user");
    }

    @ModelAttribute(name = "userSignUp")
    public Users createUserAttr() {
        return new Users();
    }


}