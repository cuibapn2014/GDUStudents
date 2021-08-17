package com.gdustudent.v1;

import java.text.ParseException;
import java.util.*;

public class QuanTriVien extends ConNguoi {
	private QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
	private QuanLyThongBao qltb = new QuanLyThongBao();
	private QuanLyTinTuc qltt = new QuanLyTinTuc();

	public QuanTriVien() {

	}

	public QuanTriVien(String ten, boolean gioiTinh, String ngaySinh, String diaChi, String sdt, String chucVu,
			String quocTich, String ghiChu) {
		super(ten, gioiTinh, ngaySinh, diaChi, sdt, chucVu, quocTich, ghiChu);
	}

	protected QuanLyTaiKhoan getQltk() {
		return qltk;
	}

	protected void setQltk(QuanLyTaiKhoan qltk) {
		this.qltk = qltk;
	}

	protected QuanLyThongBao getQltb() {
		return qltb;
	}

	protected void setQltb(QuanLyThongBao qltb) {
		this.qltb = qltb;
	}

	protected QuanLyTinTuc getQltt() {
		return qltt;
	}

	protected void setQltt(QuanLyTinTuc qltt) {
		this.qltt = qltt;
	}

	@Override
	protected void taoThongTin() throws ParseException {
		super.taoThongTin();
	}

	@Override
	protected void hienThiTT() {
		super.hienThiTT();
	}
}
