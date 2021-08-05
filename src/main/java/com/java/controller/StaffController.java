package com.java.controller;

import com.java.dao.StaffDao;
import com.java.entity.Staffs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class StaffController {

    private final StaffDao staffDao;

    @RequestMapping("staff/")
    public String userList(Model model) {
        model.addAttribute("users", staffDao.findAll());
        model.addAttribute("form", new Staffs());
        return "user/staff/staffList";
    }
}
