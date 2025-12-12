package com.example.deMau1.controller;

import com.example.deMau1.model.SinhVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienServletTest {
    private SinhVienServlet svServlet;
    private SinhVien sv;

    @BeforeEach
    public void setUp() {
        sv = new SinhVien("SV01", "A", 17, 5, 4, "CNTT");
        svServlet = new SinhVienServlet();
    }

    // ----------------------------------HOP LE----------------------------------

    // BVA
    // Biên dưới hợp lệ (min = 0)
    @Test
    public void SuaDiemBien_0_HopLe() {
        assertTrue(svServlet.suaSinhVien(sv, "A", 17, 0, 4, "CNTT"));
    }

    // Biên min + 1
    @Test
    public void SuaDiemBien_1_HopLe() {
        assertTrue(svServlet.suaSinhVien(sv, "A", 17, 1, 4, "CNTT"));
    }

    // Biên max − 1
    @Test
    public void SuaDiemBien_9_HopLe() {
        assertTrue(svServlet.suaSinhVien(sv, "A", 17, 9, 4, "CNTT"));
    }

    @Test
    public void SuaDiemBien_10_HopLe() {
        assertTrue(svServlet.suaSinhVien(sv, "A", 17, 10, 4, "CNTT"));
    }

    // EP
    // Giá trị bất kỳ trong khoảng 0 < diem < 10
    @Test
    public void SuaDiemTrongKhoangHopLe() {
        assertTrue(svServlet.suaSinhVien(sv, "A", 17, 7, 4, "CNTT"));
    }

    // ----------------------------------KHONG HOP LE----------------------------------

    // BVA
    // Điểm < 0
    @Test
    void testSua_Diem_NhoHon0() {
        assertThrows(IllegalArgumentException.class,
                () -> svServlet.suaSinhVien(sv, "A", 17, -10, 4, "CNTT"));
    }

    // Điểm > 10
    @Test
    void testSua_Diem_LonHon10() {
        assertThrows(IllegalArgumentException.class,
                () -> svServlet.suaSinhVien(sv, "A", 17, 11, 4, "CNTT"));
    }

    // EP
    // Tên rỗng
    @Test
    void testSua_TenTrong() {
        assertThrows(IllegalArgumentException.class,
                () -> svServlet.suaSinhVien(sv, "", 17, 8, 4, "CNTT"));
    }

    // Chuyên ngành null
    @Test
    void testSua_ChuyenNganhNull() {
        assertThrows(IllegalArgumentException.class,
                () -> svServlet.suaSinhVien(sv, "A", 17, 8, 4, null));
    }

    // Đối tượng sinh viên null
    @Test
    void testSua_SinhVienNull() {
        assertThrows(IllegalArgumentException.class,
                () -> svServlet.suaSinhVien(null, "A", 17, 8, 4, "CNTT"));
    }
}
