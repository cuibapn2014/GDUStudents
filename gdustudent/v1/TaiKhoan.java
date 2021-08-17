package com.gdustudent.v1;

import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class TaiKhoan {
	static Scanner nhap = new Scanner(System.in);
	private String taiKhoan;
	private String matKhau;
	private ConNguoi hoSo;
	private KetNoiCSDL data;

	public TaiKhoan() {

	}

	public TaiKhoan(String taiKhoan, String matKhau, ConNguoi hoSo) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.hoSo = hoSo;
	}

	public boolean xacThuc(String taiKhoan, String matKhau) throws SQLException {
		try {
			this.data = new KetNoiCSDL();
			this.data.kiemTraKetNoi();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		ResultSet rs = data.getSt()
				.executeQuery("SELECT * FROM taiKhoan WHERE taiKhoan='" + taiKhoan + "' AND matKhau='" + matKhau + "'");
		if (rs.next()) {
			data.getConnection().close();
			return true;
		} else {
			data.getConnection().close();
			return false;
		}
	}

	public void thongTinTK() {
		System.out.println("Tài khoản: " + this.taiKhoan);
		this.hoSo.hienThiTT();
	}

	public void thayDoiMatKhau() {
		System.out.println("Nhập mật khẩu mới (6 - 32 ký tự): ");
		do {
			this.matKhau = TestDrive.sc.nextLine();
		} while (this.matKhau.length() < 6);
	}

	protected String getTaiKhoan() {
		return this.taiKhoan;
	}

	protected void setTaiKhoan(String taiKhoan) throws SQLException {
		ResultSet rs = data.getSt().executeQuery("SELECT taiKhoan FROM taiKhoan WHERE taiKhoan='" + taiKhoan + "'");
		if (!rs.next())
			this.taiKhoan = taiKhoan;
	}

	protected String getMatKhau() {
		return this.matKhau;
	}

	protected void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	protected ConNguoi getHoSo() {
		return this.hoSo;
	}

	protected void setHoSo(ConNguoi hoSo) {
		this.hoSo = hoSo;
	}

	protected void tao() throws ParseException {

		System.out.println("Chọn loại tài khoản: 1/Sinh viên || 2/Quản trị viên");
		if (TestDrive.sc.nextInt() == 1) {
			this.hoSo = new SinhVien();
		} else if (TestDrive.sc.nextInt() == 2) {
			this.hoSo = new QuanTriVien();
		}
		this.hoSo.taoThongTin();
		System.out.println("---------- Nhập thông tin tài khoản ------------");

		try {
			data = new KetNoiCSDL();
			ResultSet rs;
			do {
				System.out.println("Tài khoản: ");
				this.taiKhoan = TestDrive.sc.nextLine();
				rs = data.getSt().executeQuery("SELECT taiKhoan FROM taiKhoan WHERE taiKhoan='" + this.taiKhoan + "'");
				if(rs.next()) {
					System.out.println("Tài khoản đã tồn tại !");
				}
			} while (rs.next());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Mật khẩu: ");
		this.setMatKhau(TestDrive.sc.nextLine());
	}

}
