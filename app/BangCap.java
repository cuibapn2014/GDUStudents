package com.app;

import java.util.Scanner;

public class BangCap {
	private Double id;
	private String tenChungChi;
	private String capChungChi;
	private String ngayCap;

	public BangCap() {

	}

	public BangCap(Double id, String tenChungChi, String capChungChi, String ngayCap) {
		this.id = id;
		this.tenChungChi = tenChungChi;
		this.capChungChi = capChungChi;
		this.ngayCap = ngayCap;
	}

	protected Double getId() {
		return id;
	}

	protected void setId(Double id) {
		this.id = id;
	}

	protected String getTenChungChi() {
		return tenChungChi;
	}

	protected void setTenChungChi(String tenChungChi) {
		this.tenChungChi = tenChungChi;
	}

	protected String getCapChungChi() {
		return capChungChi;
	}

	protected void setCapChungChi(String capChungChi) {
		this.capChungChi = capChungChi;
	}

	protected String getNgayCap() {
		return ngayCap;
	}

	protected void setNgayCap(String ngayCap) {
		this.ngayCap = ngayCap;
	}

	public void nhapChungChi() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("Mời nhập Id chứng chỉ: ");
		this.id = nhap.nextDouble();
		System.out.println("Mời nhập tên chứng chỉ: ");
		this.tenChungChi = nhap.nextLine();
		nhap.nextLine();
		System.out.println("Mời nhập cấp chứng chỉ: ");
		this.capChungChi = nhap.nextLine();
		System.out.println("Mời nhập ngày cấp");
		this.ngayCap = nhap.nextLine();
	}

	public void xuatChungChi() {
		System.out.println("++Thông Tin chứng chỉ++");
		System.out.println("Id: " + this.id);
		System.out.println("Tên chứng chỉ: " + this.tenChungChi);
		System.out.println("Cấp chứng chỉ: " + this.capChungChi);
		System.out.println("Ngày cấp: " + this.ngayCap);
	}
}
