package com.example.roomdatabase26112019.model.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sinhvien")
public class Sinhvien {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String ten;
    private Integer namsinh;
    private String quequan;

    public Sinhvien() {

    }
    public Sinhvien(String ten, Integer namsinh, String quequan) {
        this.ten = ten;
        this.namsinh = namsinh;
        this.quequan = quequan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(Integer namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
}
