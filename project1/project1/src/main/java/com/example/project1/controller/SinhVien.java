package com.example.project1.controller;
import com.example.project1.entity.SinhVienEntity;
import com.example.project1.repository.SinhVienRepository;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SinhVien {
    @Autowired
    SinhVienRepository sinhVienRepository;



    @GetMapping("test")
    public String testDB(Model model) {
        List<SinhVienEntity> ll = sinhVienRepository.findAll() ;
        for (com.example.project1.entity.SinhVienEntity v : ll ) {
            System.out.println( " === hien thi : " + v.getId() + ",Name:" + v.getName()+",des" + v.getDescription());
        }
        model.addAttribute("name", "ahihi");
        return "test" ;
    }

    @PostMapping("form")
    public String CreateSinhVien  (
                                    @RequestParam("description") String Description,
                                    @RequestParam("name") String name,
                                    Model model){
        SinhVienEntity sinhVien = new SinhVienEntity();

        sinhVien.setDescription(Description);
        sinhVien.setName(name);
        // Lưu sinhVien vào cơ sở dữ liệu
        sinhVienRepository.save(sinhVien);
        List<SinhVienEntity> ll = sinhVienRepository.findAll() ;
        model.addAttribute("sinhVien",ll);
        return "/test";

    }
    @GetMapping("/form")
    public String hienthi(){
        return "form";
    }
}

