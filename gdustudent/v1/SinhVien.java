package com.gdustudent.v1;

import java.text.ParseException;
import java.util.*;

public class SinhVien extends ConNguoi {
	private int mssv;
	private String lop;
	private String khoa;

	public SinhVien() {

	}

	public SinhVien(int mssv, String lop, String khoa, String ten, boolean gioiTinh, String ngaySinh, String diaChi,
			String sdt, String quocTich) {
		super(ten, gioiTinh, ngaySinh, diaChi, sdt, quocTich);
		this.mssv = mssv;
		this.lop = lop;
		this.khoa = khoa;
	}

	protected void phanAnh() {
		System.out.println("MỜI NHẬN PHẢN ÁNH CỦA BẠN: ");
	}

	protected int getMssv() {
		return mssv;
	}

	protected void setMssv(int mssv) {
		this.mssv = mssv;
	}

	protected String getLop() {
		return lop;
	}

	protected void setLop(String lop) {
		this.lop = lop;
	}

	protected String getKhoa() {
		return this.khoa;
	}

	protected void setKhoa(String khoa) {
		this.khoa = khoa;
	}

}
