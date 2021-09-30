package com.app;

import java.util.ArrayList;
import java.util.Scanner;

public class mainUngVien {
	static Scanner nhap = new Scanner(System.in);
	private ArrayList<BangCap> dsBangCap;

	protected ArrayList<BangCap> getDsBangCap() {
		return dsBangCap;
	}

	protected void setDsBangCap(ArrayList<BangCap> dsBangCap) {
		this.dsBangCap = dsBangCap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candidate UngVien;
		BangCap bangcap;
		boolean tiep = true;
		int tongUngVien = 0;
		QlUngVien qlUngVien = new QlUngVien();
		BangCap bc = new BangCap();
		int luachon = 0;
		do {
			try {
				menu();
				System.out.print("Hãy chọn một chức năng: ");
				luachon = nhap.nextInt();
				nhap.nextLine();
				switch (luachon) {
				case 1:
					qlUngVien.themUngVien();
					tiep = true;
					break;
				case 2:
					qlUngVien.inDs();
					tiep = true;
					break;
				case 3:
					System.out.println("Mời nhập mã ứng viên cần tìm: ");
					String maU = nhap.nextLine();
					System.out.println(qlUngVien.timKiem(maU));
					tiep = true;
					break;
				case 4:
					qlUngVien.tongUV();
					tiep = true;
					break;
				case 5:
					qlUngVien.xoaUngVien();
					tiep = true;
					break;
				case 6:
					System.out.println("Mời nhập mã ứng viên cần tìm: ");
					int id = nhap.nextInt();
					qlUngVien.timKiemBang(id);
					tiep = true;
					break;
				case 7:
					System.out.println("Kết thúc chương trình!!!");
					System.out.println("Hẹn Gặp Lại!!");
					tiep = false;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println();
				tiep = false;
			}
		} while (tiep);
		System.out.println();
	}

	static void menu() {
		System.out.println("---MỜI CHỌN CHỨC NĂNG CỦA CHƯƠNG TRÌNH---");
		System.out.println("1/Thêm ứng viên: ");
		System.out.println("2/In thông tin ứng viên: ");
		System.out.println("3/Tìm kiếm ứng viên theo mã: ");
		System.out.println("4/In tổng số lượng ứng viên : ");
		System.out.println("5/Xoá ứng viên: ");
		System.out.println("6/Tìm kiếm chứng chỉ ứng viên bằng Id: ");
		System.out.println("7/Kết thúc: ");
		System.out.println("------------------------------------------");
	}
}
