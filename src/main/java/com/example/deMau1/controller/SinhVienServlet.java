package com.example.deMau1.controller;

import com.example.deMau1.model.SinhVien;

public class SinhVienServlet {
   public boolean suaSinhVien(SinhVien sv, String ten, int tuoi, float diemTrungBinh, int kyHoc, String chuyenNganh){
       if (sv == null) {
           throw new IllegalArgumentException("Sinh vien khong ton tai"); // Dòng để check sinh viên có tồn tại để sửa hay không
       }

       if (ten == null || ten.trim().isEmpty()){
           throw new IllegalArgumentException("Ten khong duoc de trong");
       }

       if (chuyenNganh == null || chuyenNganh.trim().isEmpty()){
           throw new IllegalArgumentException("Chuyen nganh khong duoc de trong");
       }

       if (diemTrungBinh < 0 || diemTrungBinh > 10){
           throw new IllegalArgumentException("Diem trung binh phai tu 1 den 10");
       }

       sv.setTen(ten);
       sv.setTuoi(tuoi);
       sv.setDiemTrungBinh(diemTrungBinh);
       sv.setKyHoc(kyHoc);
       sv.setChuyenNganh(chuyenNganh);
       return true;
   }
}
