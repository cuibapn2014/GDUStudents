package com.app;

import java.util.Date;
import java.util.Scanner;

public class Experience extends Candidate {
	private int soNam;
	private String kiNang;

	public Experience() {

	}

	public Experience(String ma, String hoTen, int loai, String ngaySinh, int sdt, String mail, int candidate_count,
			int soNam, String kiNang) {
		super(ma, hoTen, loai, ngaySinh, sdt, mail, candidate_count);
		this.soNam = soNam;
		this.kiNang = kiNang;
	}

	protected int getSoNam() {
		return soNam;
	}

	protected void setSoNam(int soNam) {
		this.soNam = soNam;
	}

	protected String getKiNang() {
		return kiNang;
	}

	protected void setKiNang(String kiNang) {
		this.kiNang = kiNang;
	}

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		super.nhap();
		System.out.println("Số năm kinh nghiệm: ");
		this.soNam = nhap.nextInt();
		System.out.println("Kĩ năng chuyên môn: ");
		nhap.nextLine();
		this.kiNang = nhap.nextLine();
	}

	public void ShowInfo() {
		System.out.println("Loại ứng viên: Experience");
		super.ShowInfo();
		System.out.println("Số năm kinh nghiệm: " + this.soNam);
		System.out.println("Kĩ năng chuyên môn: " + this.kiNang);
	}

}
