package com.example.project1.repository;
import com.example.project1.entity.*;
import com.example.project1.controller.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinhVienRepository extends JpaRepository<SinhVienEntity, Integer> {
}
