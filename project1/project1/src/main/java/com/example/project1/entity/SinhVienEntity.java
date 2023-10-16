package com.example.project1.entity;

import jakarta.persistence.*;

@Entity
public class SinhVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Column(name = "Name",length = 50)
    private String name;
    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Column(name="Description",length=100)
    private String Description;
    public void setDescription(String Description){
        this.Description=Description;
    }

    public String getDescription() {
        return Description;
    }
}
