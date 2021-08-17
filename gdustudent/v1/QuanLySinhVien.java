package com.gdustudent.v1;

import java.util.List;

public class QuanLySinhVien extends QuanLy <SinhVien> {
    public QuanLySinhVien() {
	}

    public QuanLySinhVien(List ds) {
		super.setDs(ds);
	}

    public void them(SinhVien sv){}

    public void chinhSua(SinhVien sv){}

    public void xoa(SinhVien sv){}

    public void timKiem(SinhVien sv){}

}
