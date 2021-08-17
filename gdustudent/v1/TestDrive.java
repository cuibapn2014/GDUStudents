package com.gdustudent.v1;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class TestDrive {
	public static Scanner sc = new Scanner(System.in);
	static TaiKhoan admin = new TaiKhoan();

	public static void main(String[] args) {
		ConNguoi ng = new SinhVien(1911040021, "K13DCPM01", "Nguyen Manh Tuan Tuan", 18, true, "27/5/2001",
				"Ho Chi Minh", "0388794195", "lop truong", "VietNam", "Khong");
		ConNguoi ng1 = new SinhVien(1911040017, "K13DCPM01", "Nguyen Trung That", 18, true, "22/12/2001", "Ho Chi Minh",
				"0388794195", null, "VietNam", null);
		try {
			admin.dangNhap();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		ng.hienThiTT();
		ng1.hienThiTT();

	}
}