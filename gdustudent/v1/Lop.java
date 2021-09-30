package com.gdustudent.v1;

public class Lop {
	private int id;
	private String monHoc;
	private int soTC;
	private String lop;
	private String giangVien;
	private String phongHoc;
	private int soLuong;
	private int caHoc;
	private int thu;

	public Lop() {
	}

	public Lop(String monHoc, int soTC, String lop, String giangVien, String phongHoc, int soLuong, int caHoc, int thu) {
		this.monHoc = monHoc;
		this.soTC = soTC;
		this.lop = lop;
		this.giangVien = giangVien;
		this.caHoc = caHoc;
		this.phongHoc = phongHoc;
		this.soLuong = soLuong;
		this.thu = thu;
	}

	protected String getMonHoc() {
		return monHoc;
	}

	protected void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	protected int getThu() {
		return thu;
	}

	protected void setThu(int thu) {
		this.thu = thu;
	}

	protected int getSoTC() {
		return soTC;
	}

	protected void setSoTC(int soTC) {
		this.soTC = soTC;
	}

	protected String getLop() {
		return lop;
	}

	protected void setLop(String lop) {
		this.lop = lop;
	}

	protected String getGiangVien() {
		return giangVien;
	}

	protected void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}

	protected int getCaHoc() {
		return caHoc;
	}

	protected void setCaHoc(int caHoc) {
		this.caHoc = caHoc;
	}

	protected String getPhongHoc() {
		return phongHoc;
	}

	protected void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}

	protected int getSoLuong() {
		return soLuong;
	}

	protected void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	
}
