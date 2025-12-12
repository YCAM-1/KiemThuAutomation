package com.example.deMau1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tinhTongTest {
    private tinhTong tt;
    @BeforeEach
    public void setUp(){
        tt = new tinhTong();
    }
    // Kỹ thuật vùng biên có 6 testcase (BVA) - 4 test hợp lệ (min, min+1, max-1, max) - 2 test không hợp lệ (min-1, max+1)
    // Phân vùng tương đương có 3 testcase (EP) - 1 test hợp lệ (chọn 1 giá trị trong khoảng min-max) - 2 test không hợp lệ (< min , > max)
    // ----------------------------------HOP LE----------------------------------
    @Test // BVA
    public void tinhTongVoiBienMin(){
        int thucTe = tt.tinhTong(1, 1); // Khai báo biến thực tế để nhận kết quả truyền vào
        int mongMuon = 2; // Khai báo biến mong muốn để lấy kết quả trả ra
        assertEquals(mongMuon, thucTe); // Truyền 2 biến khai báo ở trên vào
    }

    @Test // BVA
    public void tinhTongVoiBienMinCong1(){
        int thucTe = tt.tinhTong(2, 2);
        int mongMuon = 4;
        assertEquals(mongMuon, thucTe);
    }

    @Test // BVA
    public void tinhTongVoiBienMaxTru1(){
        int thucTe = tt.tinhTong(999, 999);
        int mongMuon = 1998;
        assertEquals(mongMuon, thucTe);
    }

    @Test // BVA
    public void tinhTongVoiBienMax(){
        int thucTe = tt.tinhTong(1000, 1000);
        int mongMuon = 2000;
        assertEquals(mongMuon, thucTe);
    }

    @Test // EP
    public void tinhTongHopLe_EP(){
        int thucTe = tt.tinhTong(500, 300); // Giá trị nằm trong khoảng hợp lệ
        int mongMuon = 800;
        assertEquals(mongMuon, thucTe);
    }

    // ----------------------------------KHONG HOP LE----------------------------------
    @Test // BVA
    public void tinhTongKhongHopLeVoiBienMinTru1(){
        assertThrows(IllegalArgumentException.class, () -> {tt.tinhTong(0,1);});
    }

    @Test // BVA
    public void tinhTongKhongHopLeVoiBienMaxCong1(){
        assertThrows(IllegalArgumentException.class, () -> {tt.tinhTong(1,1001);});
    }

    @Test // EP < min
    public void tinhTongKhongHopLe_EP_NhoHonMin(){
        assertThrows(IllegalArgumentException.class, () -> {
            tt.tinhTong(-1000, 500);
        });
    }

    @Test // EP  > max
    public void tinhTongKhongHopLe_EP_LonHonMax(){
        assertThrows(IllegalArgumentException.class, () -> {
            tt.tinhTong(2000, 10);
        });
    }
}