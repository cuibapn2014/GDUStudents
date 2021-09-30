package com.gdustudent.v1;

public class Diem {
	private String monHoc;
	private float diemGHP, diemThi, diemTb;
	private String diemChu;

	public Diem() {
	}

	public Diem(String monHoc, float diemGHP, float diemThi, float diemTb, String diemChu) {
		this.monHoc = monHoc;
		this.diemGHP = diemGHP;
		this.diemThi = diemThi;
		this.diemTb = diemTb;
		this.diemChu = diemChu;
	}

	protected String getMonHoc() {
		return monHoc;
	}

	protected void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	protected float getDiemGHP() {
		return diemGHP;
	}

	protected void setDiemGHP(float diemGHP) {
		if (diemGHP >= 0 || diemGHP <= 10)
			this.diemGHP = diemGHP;
		else
			System.out.println("Lỗi do điểm hợp lệ");
	}

	protected float getDiemThi() {
		return diemThi;
	}

	protected void setDiemThi(float diemThi) {
		if (diemThi >= 0 || diemThi <= 10)
			this.diemThi = diemThi;
		else
			System.out.println("Lỗi do điểm hợp lệ");
	}

	protected String getDiemChu() {
		return diemChu;
	}

	protected void setDiemChu() {
		if (this.diemTb >= 8.5 && this.diemTb <= 10)
			this.diemChu = "A";
		else if (this.diemTb >= 7.8 && this.diemTb <= 8.4)
			this.diemChu = "B+";
		else if (this.diemTb >= 7 && this.diemTb <= 7.7)
			this.diemChu = "B";
		else if (this.diemTb >= 6.3 && this.diemTb <= 6.9)
			this.diemChu = "C+";
		else if (this.diemTb >= 5.5 && this.diemTb <= 6.2)
			this.diemChu = "C";
		else if (this.diemTb >= 4.8 && this.diemTb <= 5.4)
			this.diemChu = "D+";
		else if (this.diemTb >= 4.0 && this.diemTb <= 4.7)
			this.diemChu = "D";
		else if (this.diemTb >= 3.0 && this.diemTb <= 3.9)
			this.diemChu = "F+";
		else
			this.diemChu = "F";
	}

	protected float getDiemTb() {
		return diemTb;
	}

	protected float diemTB() {
		this.diemTb = (this.diemGHP * 0.3f) + (this.diemThi * 0.7f);
		return this.diemTb;
	}

}
