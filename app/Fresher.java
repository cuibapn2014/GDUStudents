package com.app;

import java.util.Date;
import java.util.Scanner;

public class Fresher extends Candidate{
	private int thoiGianTN;
	private String xepLoai;
	private String truongTN;
    
	public Fresher() {
		
	}
	
	public Fresher(String ma, String hoTen, int loai, String ngaySinh, int sdt, String mail, int candidate_count, int thoiGianTN, String xepLoai, String truongTN) {
		super(ma, hoTen, loai, ngaySinh, sdt, mail, candidate_count);
		this.thoiGianTN = thoiGianTN;
		this.xepLoai = xepLoai;
		this.truongTN = truongTN;
	}

	protected int getThoiGianTN() {
		return thoiGianTN;
	}

	protected void setThoiGianTN(int thoiGianTN) {
		this.thoiGianTN = thoiGianTN;
	}

	protected String getXepLoai() {
		return xepLoai;
	}

	protected void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

	protected String getTruongTN() {
		return truongTN;
	}

	protected void setTruongTN(String truongTN) {
		this.truongTN = truongTN;
	}
	
	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		super.nhap();
		System.out.println("Thời gian tốt nghiệp: ");
		thoiGianTN = nhap.nextInt();
		nhap.nextLine();
		System.out.println("Xếp loại: ");
		xepLoai = nhap.nextLine();
		System.out.println("Trường tốt nghiệp: ");
		truongTN = nhap.nextLine();
	}

	
	public void ShowInfo() {
		System.out.println("Loại ứng viên: Fresher");
		super.ShowInfo();
		System.out.println("Thời gian tốt nghiệp: "+this.thoiGianTN);
		System.out.println("Xếp học: "+this.xepLoai);
		System.out.println("Trường tốt nghiệp: "+this.thoiGianTN);
	}
}
