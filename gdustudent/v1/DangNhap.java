package com.gdustudent.v1;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DangNhap {
	private String taiKhoan;
	private String matKhau;

	public DangNhap() {
	}

	public DangNhap(String taiKhoan, String matKhau) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	protected String getTaiKhoan() {
		return taiKhoan;
	}

	protected void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	protected String getMatKhau() {
		return matKhau;
	}

	protected void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public void dangNhap() throws SQLException {
		System.out.println("-----------Chào mừng bạn đến với GDUStudents-----------");
		System.out.println("___________________ ĐĂNG NHẬP___________________");
		System.out.println("- Tên Tài Khoản: ");
		this.taiKhoan = nhap.nextLine();
		System.out.println("- Mật Khẩu: ");
		this.matKhau = nhap.nextLine();
	}

}
