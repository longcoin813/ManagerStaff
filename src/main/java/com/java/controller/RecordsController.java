package com.java.controller;

import com.java.dao.DepartDao;
import com.java.dao.RecordsDao;
import com.java.entity.Departs;
import com.java.entity.Records;
import com.java.entity.Staffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    @RequestMapping("records/create")
    public String userRecord(ModelMap model, @Valid @ModelAttribute("form") Records records, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if(dao.existsById(records.getRecordid())) {
                model.addAttribute("mega", "Mã nhân viên đã tồn tại!");
            }else {
                dao.save(records);
                model.addAttribute("mega", "Thêm thành công");
            }
        } else {
            model.addAttribute("mega", "Thêm không thành công");
            model.addAttribute("form", records);
        }
        model.addAttribute("records", dao.findAll());
        return "records/recordsList";
    }

    @GetMapping("records/delete/{recordsid}")
    public String delete(Model model, @PathVariable(name = "recordsid") Integer recordsid) {
        Optional<Records> option = dao.findById(recordsid);
        if(!dao.existsById(recordsid)) {
            model.addAttribute("mega", "ID không tồn tại!");
        } else {
            dao.deleteById(recordsid);
            model.addAttribute("mega", "Xóa thành công!");
        }
        model.addAttribute("records", dao.findAll());
        return "records/recordsList";
    }


    @ModelAttribute(name = "records")
    public List<Records> getAllRecord() {
        return dao.findAll();
    }
    @ModelAttribute(name = "form")
    public Records initStaff() {
        return new Records();
    }


}
