package com.gdustudent.v1;

import java.text.ParseException;
import java.util.*;

public class SinhVien extends ConNguoi {
	private int mssv;
	private String lop;
	private String khoa;

	public SinhVien() {

	}

	public SinhVien(int mssv, String lop, String khoa,String ten, boolean gioiTinh, String ngaySinh, String diaChi, String sdt,
			String chucVu, String quocTich, String ghiChu) {
		super(ten, gioiTinh, ngaySinh, diaChi, sdt, chucVu, quocTich, ghiChu);
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

	@Override
	protected void taoThongTin() throws ParseException {
		super.taoThongTin();
		System.out.println("Mã số sinh viên: ");
		this.mssv = TestDrive.sc.nextInt();
		TestDrive.sc.nextLine();
		do {
			System.out.println("Lớp: ");
			this.lop = TestDrive.sc.nextLine();
		}while(this.lop.length() > 10);
		System.out.println("Khoa: ");
		this.khoa = TestDrive.sc.nextLine();
	}

	@Override
	protected void hienThiTT() {
		System.out.println("MSSV: " + this.mssv);
		System.out.println("Lớp: " + this.lop);
		System.out.println("Khoa: " + this.khoa);
		super.hienThiTT();
	}
}
