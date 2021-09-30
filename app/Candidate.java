package com.app;

import java.util.Date;
import java.util.Scanner;

public class Candidate {
	private String ma;
	private String hoTen;
	private int loai;
	private String ngaySinh;
	private int sdt;
	private String mail;
	private int candidate_count;

	public Candidate() {

	}

	public Candidate(String ma, String hoTen, int loai, String ngaySinh, int sdt, String mail, int candidate_count) {
		this.ma = ma;
		this.hoTen = hoTen;
		this.loai = loai;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.mail = mail;
		this.candidate_count = candidate_count;
	}

	protected String getMa() {
		return ma;
	}

	protected void setMa(String ma) {
		this.ma = ma;
	}

	protected String getHoTen() {
		return hoTen;
	}

	protected void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	protected int getLoai() {
		return loai;
	}

	protected void setLoai(int loai) {
		this.loai = loai;
	}

	protected String getNgaySinh() {
		return ngaySinh;
	}

	protected void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	protected int getSdt() {
		return sdt;
	}

	protected void setSdt(int sdt) {
		this.sdt = sdt;
	}

	protected String getMail() {
		return mail;
	}

	protected void setMail(String mail) {
		this.mail = mail;
	}

	protected int getCandidate_count() {
		return candidate_count;
	}

	protected void setCandidate_count(int candidate_count) {
		this.candidate_count = candidate_count;
	}

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("Mời nhập mã ứng viên: ");
		this.ma = nhap.nextLine();
		System.out.println("Mời nhâp tên của ứng viên: ");
		this.hoTen = nhap.nextLine();
		System.out.println("Ngày sinh ứng viên: ");
		this.ngaySinh = nhap.nextLine();
		System.out.println("Số điện thoại: ");
		this.sdt = nhap.nextInt();
		nhap.nextLine();
		System.out.println("Mail: ");	
		this.mail = nhap.nextLine();	
	}

	public void ShowInfo() {
		System.out.println("________Thông tin ứng viên________");
		System.out.println("Mã ứng viên: " + this.ma);
		System.out.println("Tên ứng viên " + this.hoTen);
		System.out.println("Ngày sinh: " + this.ngaySinh);
		System.out.println("Số điện thoại: " + this.sdt);
		System.out.println("Mail: " + this.mail);
	}

}
