package com.gdustudent.v1;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class TestDrive {
	public static Scanner sc = new Scanner(System.in);
	static DangNhap admin = new DangNhap();

	public static void main(String[] args) {
		ConNguoi ng = new SinhVien(1911040021, "K13DCPM01", "CNTT", "Nguyen Manh Tuan Tuan", true, "27/5/2001",
				"Ho Chi Minh", "0388794195", "lop truong", "VietNam", "Khong");
		ConNguoi ng1 = new SinhVien(1911040017, "K13DCPM01", "CNTT", "Nguyen Trung That", true, "22/12/2001",
				"Ho Chi Minh", "0388794195", null, "VietNam", null);
		TaiKhoan tk = new TaiKhoan();
		QuanLyTaiKhoan tkk = new QuanLyTaiKhoan();
		tkk.them(tk);
//		try {
//			admin.dangNhap();
//			// tk.tao();
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
		
		ng.hienThiTT();
		ng1.hienThiTT();

	}
}