package com.java.controller;

import com.java.dao.StaffDao;
import com.java.entity.Staffs;
import com.java.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StaffController {

    @Autowired
    private StaffDao dao;

    @GetMapping("user/staff")
    public String userList(Model model) {
        model.addAttribute("form", new Staffs());
        return "staff/staffList";
    }


    @RequestMapping("staff/create")
    public String userSave(ModelMap model, @Valid @ModelAttribute("form") Staffs staff, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if(dao.existsById(staff.getStaffid())) {
                model.addAttribute("mega", "Mã nhân viên đã tồn tại!");
            }else {
                dao.save(staff);
                model.addAttribute("mega", "Thêm thành công");
            }
        } else {
            model.addAttribute("mega", "Thêm không thành công");
            model.addAttribute("form", staff);
        }
        model.addAttribute("staff", dao.findAll());
        return "staff/staffList";
    }

    @GetMapping("staff/delete/{staffid}")
    public String delete(Model model, @PathVariable(name = "staffid") String staffid) {
        Optional<Staffs> option = dao.findById(staffid);
        if(!dao.existsById(staffid)) {
            model.addAttribute("mega", "Nhân viên không tồn tại!");
        } else {
            dao.deleteById(staffid);
            model.addAttribute("mega", "Xóa thành công!");
        }
        model.addAttribute("staff", dao.findAll());
        return "staff/staffList";

    }

    @GetMapping(value = "staff/edit/{staffid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Staffs edit(Model model, @PathVariable("staffid") String staffId) {
        Optional<Staffs> staffOptional = dao.findById(staffId);
        return staffOptional.orElse(null);
    }

    @PostMapping("staff/update")
    public String updateStaffProfile(Model model, @ModelAttribute("editStaff") Staffs staff) {
        if(!dao.existsById(staff.getStaffid())) {
            model.addAttribute("mega", "Mã nhân viên không tồn tại!");
        }else {
            dao.save(staff);
            model.addAttribute("mega", "Cập nhật thành công!");
        }
        model.addAttribute("staff", dao.findAll());
        return "staff/staffList";
    }



    @ModelAttribute(name = "staffs")
    public List<Staffs> getAllStaffs() {
        return dao.findAll();
    }

    @ModelAttribute(name = "editStaff")
    public Staffs initEditStaff() {
        return new Staffs();
    }

    @ModelAttribute(name = "form")
    public Staffs initStaff() {
        return new Staffs();
    }
}
