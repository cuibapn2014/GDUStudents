package com.gdustudent.v1;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PhanAnh {
	private int id;
	private String tieuDe;
	private String noiDung;
	private Date ngayGui;
	private String nguoiGui;
	private String danhMuc;

	public PhanAnh() {
	}

	public PhanAnh(String tieuDe, String noiDung, String ngayGui, String danhMuc, int id) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		try {
			this.ngayGui = df.parse(ngayGui);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.danhMuc = danhMuc;
		this.id = id;
	}

	public PhanAnh(String tieuDe, String noiDung, String danhMuc) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.danhMuc = danhMuc;
	}

	protected String getTieuDe() {
		return tieuDe;
	}

	protected void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	protected String getNoiDung() {
		return noiDung;
	}

	protected void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	protected Date getNgayGui() {
		return ngayGui;
	}

	protected void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}

	public String getDanhMuc() {
		return danhMuc;
	}

	protected void setDanhMuc(String danhMuc) {
		this.danhMuc = danhMuc;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getNguoiGui() {
		return nguoiGui;
	}

	protected void setNguoiGui(String nguoiGui) {
		this.nguoiGui = nguoiGui;
	}

}
