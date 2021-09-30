package com.app;

import java.util.ArrayList;
import java.util.Scanner;

public class QlUngVien {
	static Scanner sc = new Scanner(System.in);
	private ArrayList<Candidate> dsUngVien;
	private ArrayList<BangCap> dsBangCap;
	private int tongUngVien;

	protected ArrayList<Candidate> getDsUngVien() {
		return dsUngVien;
	}

	protected void setDsUngVien(ArrayList<Candidate> dsUngVien) {
		this.dsUngVien = dsUngVien;
	}

	protected ArrayList<BangCap> getDsBangCap() {
		return dsBangCap;
	}

	protected void setDsBangCap(ArrayList<BangCap> dsBangCap) {
		this.dsBangCap = dsBangCap;
	}

	protected int getTongUngVien() {
		return tongUngVien;
	}

	protected void setTongUngVien(int tongUngVien) {
		this.tongUngVien = tongUngVien;
	}

	public QlUngVien() {
		dsUngVien = new ArrayList<Candidate>();
		dsBangCap = new ArrayList<BangCap>();
	}

	public void themUngVien() {
		Candidate uv1;
		BangCap bc1;
		System.out.println("Mời chọn loại ứng viên: 1/ Experience | 2/ Fresher | 3/ Intern");
		int chon = sc.nextInt();
		if (chon == 1) {
			uv1 = new Experience();
			uv1.nhap();
			dsUngVien.add(uv1);
			System.out.println("Số chứng chỉ mà ứng viên có: ");
			int so = sc.nextInt();
			for (int n = 1; n <= so; n++) {
				bc1 = new BangCap();
				bc1.nhapChungChi();
				dsBangCap.add(bc1);
			}
			tongUngVien++;
		} else if (chon == 2) {
			uv1 = new Fresher();
			uv1.nhap();
			dsUngVien.add(uv1);
			System.out.println("Số chứng chỉ mà ứng viên có: ");
			int so = sc.nextInt();
			for (int n = 1; n <= so; n++) {
				bc1 = new BangCap();
				bc1.nhapChungChi();
				dsBangCap.add(bc1);
			}
			tongUngVien++;
		} else if (chon == 3) {
			uv1 = new Intern();
			uv1.nhap();
			dsUngVien.add(uv1);
			System.out.println("Số chứng chỉ mà ứng viên có: ");
			int so = sc.nextInt();
			for (int n = 1; n <= so; n++) {
				bc1 = new BangCap();
				bc1.nhapChungChi();
				dsBangCap.add(bc1);
			}
			tongUngVien++;
		} else {
			System.out.println("Bạn đã nhập sai!!! Xin mời thực hiện lại");
		}
	}

	public void inDs() {
		System.out.println("Danh sách các ứng viên: ");
		for (Candidate c : dsUngVien) {
			int i = 0;
			++i;
			System.out.println(i + ". ");
			c.ShowInfo	();
		}
	}

	public boolean timKiem(String maU) {
		for (Candidate uv1 : dsUngVien) {
			if (uv1.getMa().equals(maU)) {
				uv1.ShowInfo();
				System.out.println(uv1.getMa());
				return true;
			} else {
				System.out.println(uv1.getMa());
				System.out.println("Không thấy ứng viên nào có mã là: " + maU);
				return false;
			}
		}
		return false;
	}

	public void tongUV() {
		System.out.println("Tổng số lượng ứng viên là: " + this.tongUngVien);
	}

	public void xoaUngVien() {
		System.out.println("Mời nhập mã ứng vien cần xoá: ");
		String ma = sc.nextLine();
		for (Candidate uv1 : dsUngVien) {		
			if (uv1.getMa().equals(ma)) {
				dsUngVien.remove(uv1);
				System.out.println("Đã xoá ứng viên ra khỏi danh sách");
				break;
			} else {
				System.out.println("Không thấy ứng viên nào có mã là: " + ma);
			}

		}
	}

	public boolean timKiemBang(int id) {
		for (BangCap bc : dsBangCap) {
			if (bc.getId() == id) {
				bc.xuatChungChi();
				return true;
			} else {
			}
		}
		System.out.println("Không thấy ứng viên nào có mã là: " + id);
		return false;
	}

}