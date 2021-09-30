package com.app;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDriveUngVien {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candidate uv;
		BangCap bc;
		boolean fleg = true;
		int total = 0;
		QlUngVien ql = new QlUngVien();
		bc = new BangCap();
		int luachon = 0;
		do {
			try {
				menu();
				System.out.print("Chọn chức năng: ");
				luachon = sc.nextInt();
				sc.nextLine();
				switch (luachon) {
				case 1:
					ql.themUngVien();
					fleg = true;
					break;
				case 2:
					ql.inDs();
					fleg = true;
					break;
				case 3:
					System.out.println("Nhập mã ứng viên cần tìm: ");
					String maUV = sc.nextLine();
					System.out.println(ql.timKiem(maUV));
					fleg = true;
					break;
				case 4:
					ql.tongUV();
					fleg = true;
					break;
				case 5:
					ql.xoaUngVien();
					fleg = true;
					break;
				case 6:
					System.out.println("Nhập mã ứng viên cần tìm: ");
					int id = sc.nextInt();
					if (ql.timKiemBang(id)) {
						System.out.println("Tìm thấy nhân viên có mã là: " + id);
					}
					fleg = true;
					break;
				case 7:
					fleg = false;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println();
				fleg = false;
			}
		} while (fleg);
		System.out.println();
	}

	static void menu() {
		System.out.println("------------------ MENU ------------------");
		System.out.println("1. Thêm ứng viên");
		System.out.println("2. In thông tin ứng viên");
		System.out.println("3. Tìm kiếm ứng viên theo mã");
		System.out.println("4. In tổng số lượng ứng viên");
		System.out.println("5. Xoá ứng viên");
		System.out.println("6. Tìm kiếm chứng chỉ ứng viên bằng ID");
		System.out.println("7. Kết thúc");
		System.out.println("------------------------------------------");
	}
}