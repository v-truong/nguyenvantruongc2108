package com.example.demo.controller;

import com.example.demo.entity.SinhVien;
import com.example.demo.repository.SinhVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/sinhvien")
public class SinhVienCtrl {
    @Autowired private
    SinhVienRepo sinhVienRepo;

    @GetMapping("test")
    public String testDB(Model model) {
         List<SinhVien> ll = sinhVienRepo.findAll() ;
        model.addAttribute("sinhVien",ll);
        return "test" ;
    }

    @PostMapping("form")
    public void CreateSinhVien  (
                                    @RequestParam("description") String Description,
                                    @RequestParam("name") String name,
                                    Model model){
        SinhVien sinhVien = new SinhVien();

        sinhVien.setDescription(Description);
        sinhVien.setName(name);
        // Lưu sinhVien vào cơ sở dữ liệu
        sinhVienRepo.save(sinhVien);
    }
    @GetMapping("/form")
    public String hienthi(){
        return "form";
    }

}
