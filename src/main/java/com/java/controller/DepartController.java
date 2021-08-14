package com.java.controller;

import com.java.dao.DepartDao;
import com.java.entity.Departs;
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
public class DepartController {

    @Autowired
    DepartDao dao;

    @GetMapping("/user/departs")
    public String departList(Model model) {
        model.addAttribute("form", new Departs());
        return "departs/departsList";
    }

    @RequestMapping("departs/create")
    public String userSave(ModelMap model, @Valid @ModelAttribute("form") Departs depart, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (dao.existsById(depart.getDepartid())) {
                model.addAttribute("mega", " ID đã tồn tại!");
            } else {
                dao.save(depart);
                model.addAttribute("mega", "Thêm thành công");
            }
        } else {
            model.addAttribute("form", depart);
            model.addAttribute("mega", "Thêm thất bại");
        }
        model.addAttribute("departs", dao.findAll());
        return "departs/departsList";
    }

    @GetMapping("departs/delete/{departid}")
    public String delete(Model model, @PathVariable(name = "departid") String departid) {
        try {
            Optional<Departs> option = dao.findById(departid);
            if (!dao.existsById(departid)) {
                model.addAttribute("mega", "ID không tồn tại!");
            } else {
                dao.deleteById(departid);
                model.addAttribute("mega", "Xóa thành công!");
            }
        }
        catch (Exception e){
            model.addAttribute("mega", "ID này đang được sử dụng");
        }
        model.addAttribute("departs", dao.findAll());
        return "departs/departsList";
    }


    @GetMapping(value = "/user/departs/edit/{departid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Departs edit(Model model, @PathVariable("departid") String departid) {
        Optional<Departs> departsOptional =null;
        try {
            departsOptional = dao.findById(departid);
//            return departsOptional.orElse(null);
        }catch (Exception e){
            model.addAttribute("mega", "ID đang được sử dụng!");
        }
        return departsOptional.orElse(null);

    }

    @PostMapping("departs/update")
    public String updateDepartProfile(Model model, @ModelAttribute("editDepart") Departs departs) {
        try {
            if (!dao.existsById(departs.getDepartid())) {
                model.addAttribute("mega", "ID không tồn tại!");
            } else {
                dao.save(departs);
                model.addAttribute("mega", "Cập nhật thành công!");
            }
        } catch (Exception e) {
            model.addAttribute("mega", "ID đang được sử dụng!");
        }
        model.addAttribute("departs", dao.findAll());
        return "departs/departsList";
    }


    @ModelAttribute(name = "departs")
    public List<Departs> getAllDepart() {
        return dao.findAll();
    }

    @ModelAttribute(name = "form")
    public Departs initDepart() {
        return new Departs();
    }

    @ModelAttribute(name = "editDepart")
    public Departs initEditDeparts() {
        return new Departs();
    }

}
