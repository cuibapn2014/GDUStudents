package com.gdustudent.v1;

import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class TaiKhoan {
	static Scanner nhap = new Scanner(System.in);
	private int id;
	private String taiKhoan;
	private String matKhau;
	private ConNguoi hoSo;
	private int quyen;
	private KetNoiCSDL data;

	public TaiKhoan() {

	}

	public TaiKhoan(String taiKhoan, String matKhau, ConNguoi hoSo) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.hoSo = hoSo;
		this.quyen = 0;
	}

	public TaiKhoan(String taiKhoan, String matKhau, ConNguoi hoSo, int quyen) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.hoSo = hoSo;
		this.quyen = quyen;
	}

	protected String getTaiKhoan() {
		return this.taiKhoan;
	}

	protected void setTaiKhoan(String taiKhoan) throws SQLException {
		ResultSet rs = data.getSt().executeQuery("SELECT taiKhoan FROM taiKhoan WHERE taiKhoan='" + taiKhoan + "'");
		if (!rs.next())
			this.taiKhoan = taiKhoan;
		else {
			System.out.println("Tài khoản đã tồn tại !");
		}
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

	protected void setData(KetNoiCSDL data) {
		this.data = data;
	}

	protected KetNoiCSDL getData() {
		return this.data;
	}

	protected int getQuyen() {
		return quyen;
	}

	protected void setQuyen(int quyen) {
		this.quyen = quyen;
	}

	public void thongTinTK() {
		System.out.println("Tài khoản: " + this.taiKhoan);
	}

	protected void thayDoiMatKhau() {
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}
}
