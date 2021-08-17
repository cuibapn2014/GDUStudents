package com.gdustudent.v1;

import java.sql.SQLException;

public class DangNhap {
	private String taiKhoan;
	private String matKhau;
	private boolean trangThai = false;
	private TaiKhoan tk;

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

	public boolean getTrangThai() {
		return this.trangThai;
	}

	public TaiKhoan getTk() {
		return this.tk;
	}

	public void dangNhap() throws SQLException {
		System.out.println("-----------Chào mừng bạn đến với GDUStudents-----------");
		System.out.println("___________________ ĐĂNG NHẬP___________________");
		System.out.println("- Tên Tài Khoản: ");
		this.taiKhoan = TestDrive.sc.nextLine();
		System.out.println("- Mật Khẩu: ");
		this.matKhau = TestDrive.sc.nextLine();
		if (tk.xacThuc(taiKhoan, matKhau)) {
			this.trangThai = true;
			System.out.println("Đăng nhập thành công");
		} else {
			this.trangThai = false;
			System.out.println("Đăng nhập thất bại");
		}
	}

	public void dangXuat() {
		this.trangThai = false;
	}

}
