package com.gdustudent.v1;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class ThongTin {
	private int id;
	private String tieuDe;
	private Date ngayTao;
	private String nguoiViet;
	private String noiDung;
	private String danhMuc;
	KetNoiCSDL data;

	public ThongTin() {
	}

	public ThongTin(String tieuDe, String ngayTao, String noiDung, String danhMuc) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.tieuDe = tieuDe;
		this.ngayTao = df.parse(ngayTao);
		this.noiDung = noiDung;
		this.danhMuc = danhMuc;
	}

	public ThongTin(String tieuDe, String ngayTao, String nguoiViet, String noiDung, String danhMuc)
			throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.tieuDe = tieuDe;
		this.ngayTao = df.parse(ngayTao);
		this.noiDung = noiDung;
		this.danhMuc = danhMuc;
		this.nguoiViet = nguoiViet;
	}

	protected String getTieuDe() {
		return this.tieuDe;
	}

	protected void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	protected Date getNgayTao() {
		return this.ngayTao;
	}

	protected void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	protected String getNguoiViet() {
		return this.nguoiViet;
	}

	protected String getNoiDung() {
		return this.noiDung;
	}

	protected void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	protected String getDanhMuc() {
		return this.danhMuc;
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

}
