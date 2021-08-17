package com.gdustudent.v1;

import java.sql.*;
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

	public void dangNhap() throws SQLException {
		try {
			this.data = new KetNoiCSDL();
			this.data.kiemTraKetNoi();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-----------Chào mừng bạn đến với GDUStudents-----------");
		System.out.println("___________________ ĐĂNG NHẬP___________________");
		System.out.println("- Tên Tài Khoản: ");
		this.taiKhoan = nhap.nextLine();
		System.out.println("- Mật Khẩu: ");
		this.matKhau = nhap.nextLine();
		ResultSet rs = data.getSt().executeQuery("SELECT taiKhoan FROM taiKhoan WHERE taiKhoan='" + this.taiKhoan
				+ "' AND matKhau='" + this.matKhau + "'");
		data.setResultSet(rs);
		if (data.getResultSet().next()) {
			System.out.println("Đăng nhập thành công");
		} else {
			System.out.println("Đăng nhập thất bại");
		}
		data.getConnection().close();
	}

	public void dangXuat() {

	}

	public void thongTinTK() {

	}

	public void thayDoiMatKhau() {

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

	protected ConNguoi getHoSo() {
		return hoSo;
	}

	protected void setHoSo(ConNguoi hoSo) {
		this.hoSo = hoSo;
	}

}
