package com.gdustudent.v1;

import java.text.DateFormat;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public abstract class ConNguoi {
	private String ten;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String diaChi = null;
	private String sdt;
	private String quocTich;

	public ConNguoi() {

	}

	public ConNguoi(String ten, boolean gioiTinh, String ngaySinh, String diaChi, String sdt, String quocTich) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		try {
			this.ngaySinh = df.parse(ngaySinh);
		} catch (ParseException e) {
			System.out.println(e.getStackTrace());
		}
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.quocTich = quocTich;
	}

	protected String getTen() {
		return ten;
	}

	protected void setTen(String ten) {
		this.ten = ten;
	}

	protected boolean isGioiTinh() {
		return gioiTinh;
	}

	protected void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	protected Date getNgaySinh() {
		return this.ngaySinh;
	}

	protected void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	protected String getDiaChi() {
		return diaChi;
	}

	protected void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	protected String getSdt() {
		return sdt;
	}

	protected void setSdt(String sdt) {
		this.sdt = sdt;
	}

	protected String getQuocTich() {
		return quocTich;
	}

	protected void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

}
