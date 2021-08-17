package com.gdustudent.v1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public abstract class ConNguoi {
	private String ten;
	private int tuoi;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String sdt;
	private String chucVu;
	private String quocTich;
	private String ghiChu;

	public ConNguoi() {

	}

	public ConNguoi(String ten, int tuoi, boolean gioiTinh, String ngaySinh, String diaChi, String sdt, String chucVu,
			String quocTich, String ghiChu) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.ten = ten;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		try {
			this.ngaySinh = df.parse(ngaySinh);
		} catch (ParseException e) {
			System.out.println(e.getStackTrace());
		}
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.chucVu = chucVu;
		this.quocTich = quocTich;
		this.ghiChu = ghiChu;
	}

	protected String getTen() {
		return ten;
	}

	protected void setTen(String ten) {
		this.ten = ten;
	}

	protected int getTuoi() {
		return tuoi;
	}

	protected void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	protected boolean isGioiTinh() {
		return gioiTinh;
	}

	protected void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	protected Date getNgaySinh() {
		return ngaySinh;
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

	protected String getChucVu() {
		return chucVu;
	}

	protected void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	protected String getQuocTich() {
		return quocTich;
	}

	protected void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	protected String getGhiChu() {
		return ghiChu;
	}

	protected void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	protected void hienThiTT() {
		String gt;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (this.gioiTinh) {
			gt = "Nam";
		} else {
			gt = "Nữ";
		}
		System.out.printf("%-15s%8d%10s%15s%15s%15s%15s%15s%15s\n", this.ten, this.tuoi, gt, df.format(this.ngaySinh),
				this.diaChi, this.sdt, this.chucVu, this.quocTich, this.ghiChu);
	}
}
