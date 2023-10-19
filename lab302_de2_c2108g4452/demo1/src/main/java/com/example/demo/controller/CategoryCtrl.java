package com.example.demo.controller;

import com.example.demo.entity.Category;
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

@Controller
public class CategoryCtrl {
   @Autowired private
   CategoryRepo categoryRepo;
   @Autowired private ProductRepo productRepo;
    @GetMapping("Category")
    public String testDB(Model model) {
        List<Category> category = categoryRepo.findAll();
        model.addAttribute("category",category);
        return "Category" ;
    }
    @GetMapping("Category/{id}")
    public  String GetProductid(@PathVariable("id") int idprd,Model model){
        List<Product> product= productRepo.findAllByCategoryid(idprd);
        model.addAttribute("product",product);
       return "Productlist";
    }


}
