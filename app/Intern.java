package com.app;

import java.util.Date;
import java.util.Scanner;

public class Intern extends Candidate {
	private String chuyenNganh;
	private int hocKiDangHoc;
	private String tenTruongDangHoc;

	public Intern() {

	}

	public Intern(String ma, String hoTen, int loai, String ngaySinh, int sdt, String mail, int candidate_count,
			String chuyenNganh, int hocKiDangHoc, String tenTruongDangHoc) {
		super(ma, hoTen, loai, ngaySinh, sdt, mail, candidate_count);
		this.chuyenNganh = chuyenNganh;
		this.hocKiDangHoc = hocKiDangHoc;
		this.tenTruongDangHoc = tenTruongDangHoc;
	}

	protected String getChuyenNganh() {
		return chuyenNganh;
	}

	protected void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	protected int getHocKiDangHoc() {
		return hocKiDangHoc;
	}

	protected void setHocKiDangHoc(int hocKiDangHoc) {
		this.hocKiDangHoc = hocKiDangHoc;
	}

	protected String getTenTruongDangHoc() {
		return tenTruongDangHoc;
	}

	protected void setTenTruongDangHoc(String tenTruongDangHoc) {
		this.tenTruongDangHoc = tenTruongDangHoc;
	}

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		super.nhap();
		System.out.println("Chuyên ngành đang học: ");
		this.chuyenNganh = nhap.nextLine();
		System.out.println("Học kì đang học: ");
		this.hocKiDangHoc = nhap.nextInt();
		System.out.println("Tên trường đang học: ");
		this.tenTruongDangHoc = nhap.nextLine();
	}

	public void ShowInfo() {
		System.out.println("Loại ứng viên: Intern");
		super.ShowInfo();
		System.out.println("Chuyên ngành đang học: " + this.chuyenNganh);
		System.out.println("Học kì đang học: " + this.hocKiDangHoc);
		System.out.println("Tên trường đang học: " + this.tenTruongDangHoc);
	}

}
