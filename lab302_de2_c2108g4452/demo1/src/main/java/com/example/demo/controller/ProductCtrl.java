package com.example.demo.controller;

import com.example.demo.entity.Product;

import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductCtrl {
    @Autowired
    private
    ProductRepo productRepo;
    @GetMapping("Product")
    public String upd(Model model) {
        return "assign";
    }
    @PostMapping("updProduct/{id}")
        public String update(@PathVariable("id") int id,Model model) {
            Optional<Product> product =productRepo.findById(id);

            return "assign";
        }


}
