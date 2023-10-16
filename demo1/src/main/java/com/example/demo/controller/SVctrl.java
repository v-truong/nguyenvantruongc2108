package com.example.demo.controller;

import com.example.demo.entity.SinhVien;
import com.example.demo.repository.SinhVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sv")
@RestController
public class SVctrl {
    @Autowired private SinhVienRepo sinhVienRepo;
    @GetMapping
    public List<SinhVien> getsv(){
        List<SinhVien> sinhViens= sinhVienRepo.findAll();
        return sinhViens;
    }
    @PostMapping
    public boolean create(@RequestBody SinhVien sinhVien){
        sinhVienRepo.save(sinhVien);
        return true;
    }
}
