package com.example.deMau1;

public class tinhTong {
    public int tinhTong (int a, int b){ // khai báo biến thực hiện test (tinhTong), khai báo các biến dữ liệu thực hiện test(a,b)
        // tu 1 den 1000
        if(a < 1 || a > 1000 || b < 1 || b > 1000){ // if - else la dieu kien
            throw new IllegalArgumentException("Nhap dung so di");
        }
        return a + b;

    }
}
