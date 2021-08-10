package com.java.controller;

import com.java.dao.DepartDao;
import com.java.dao.RecordsDao;
import com.java.entity.Departs;
import com.java.entity.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class RecordsController {
    @Autowired
    RecordsDao dao;

    @GetMapping("user/records")
    public String departList(Model model) {
        model.addAttribute("form", new Records());
        model.addAttribute("records",dao.findAll());
        return "records/recordsList";
    }

    @ModelAttribute(name = "records")
    public List<Records> getAllRecord() {
        return dao.findAll();
    }
}
