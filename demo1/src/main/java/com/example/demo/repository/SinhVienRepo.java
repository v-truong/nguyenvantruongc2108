package com.example.demo.repository;

import com.example.demo.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepo extends JpaRepository<SinhVien,Integer> {
}
