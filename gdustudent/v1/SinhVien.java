package com.gdustudent.v1;

import java.util.*;

public class SinhVien extends ConNguoi {
	private int mssv;
	private String lop;
	private String khoa;

	public SinhVien() {

	}

	public SinhVien(int mssv, String lop, String ten, int tuoi, boolean gioiTinh, String ngaySinh, String diaChi,
			String sdt, String chucVu, String quocTich, String ghiChu) {
		super(ten, tuoi, gioiTinh, ngaySinh, diaChi, sdt, chucVu, quocTich, ghiChu);
		this.mssv = mssv;
		this.lop = lop;
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

	@Override
	protected void hienThiTT() {
		// TODO Auto-generated method stub
		super.hienThiTT();
	}
}
