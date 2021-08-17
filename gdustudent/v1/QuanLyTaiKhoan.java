package com.gdustudent.v1;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class QuanLyTaiKhoan extends QuanLy<TaiKhoan> {
	public QuanLyTaiKhoan() {
	}

	@Override
	public void them(TaiKhoan tk) {
		try {
			tk.tao();
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		try {
			KetNoiCSDL data = new KetNoiCSDL();
			java.sql.Date parse = new java.sql.Date(tk.getHoSo().getNgaySinh().getTime());

			data.getSt().executeUpdate(
					"INSERT INTO taiKhoan(taiKhoan, matKhau, ten, gioiTinh, ngaySinh, diaChi, sdt, chucVu, quocTich, ghiChu) VALUES('"
							+ tk.getTaiKhoan() + "','" + tk.getMatKhau() + "','" + tk.getHoSo().getTen() + "','"
							+ tk.getHoSo().isGioiTinh() + "','" + parse + "','" + tk.getHoSo().getDiaChi() + "','"
							+ tk.getHoSo().getSdt() + "','" + tk.getHoSo().getChucVu() + "','"
							+ tk.getHoSo().getQuocTich() + "','" + tk.getHoSo().getGhiChu() + "')");

			Statement st1 = data.getConnection().createStatement();
			ResultSet rs = st1.executeQuery("SELECT TOP 1 * FROM taiKhoan ORDER BY id DESC");
			SinhVien sv = (SinhVien) tk.getHoSo();

			while (rs.next()) {
				data.getSt().executeUpdate("INSERT INTO sinhVien(id_taiKhoan, mssv, lop, khoa) VALUES('"
						+ rs.getInt("id") + "','" + sv.getMssv() + "','" + sv.getLop() + "','" + sv.getKhoa() + "')");
			}

			System.out.println("Đã thêm vào hệ thống");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void chinhSua(TaiKhoan tk) {

	}

	@Override
	public void timKiem(TaiKhoan tk) {

	}

	@Override
	public void xoa(TaiKhoan tk) {
		// TODO Auto-generated method stub

	}
}
