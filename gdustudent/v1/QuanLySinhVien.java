package com.gdustudent.v1;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class QuanLySinhVien extends QuanLy<SinhVien> {
	KetNoiCSDL data;

	public QuanLySinhVien() {
		try {
			data = new KetNoiCSDL();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void them(SinhVien sv) {
		try {
			KetNoiCSDL data = new KetNoiCSDL();
			data = new KetNoiCSDL();
			ResultSet rs;
			rs = data.getSt().executeQuery("SELECT id FROM taiKhoan ORDER BY id DESC");
			if (rs.next()) {
				try {
					java.sql.Date parse = new java.sql.Date(sv.getNgaySinh().getTime());
					data.getSt().executeUpdate(
							"INSERT INTO sinhVien(id_taiKhoan, mssv, lop, khoa, ten, gt, ngaySinh, diaChi, sdt, quocTich) VALUES('"
									+ rs.getInt("id") + "','" + sv.getMssv() + "','" + sv.getLop() + "','"
									+ sv.getKhoa() + "','" + sv.getTen() + "','" + sv.isGioiTinh() + "','" + parse
									+ "','" + sv.getDiaChi() + "','" + sv.getSdt() + "','" + sv.getQuocTich() + "')");
					System.out.println("Đã thêm vào hệ thống");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void chinhSua(SinhVien sv) {
		try {
			KetNoiCSDL data = new KetNoiCSDL();
			data = new KetNoiCSDL();
			ResultSet rs;
			java.sql.Date parse = new java.sql.Date(sv.getNgaySinh().getTime());
			int check = data.getSt()
					.executeUpdate("UPDATE sinhVien SET mssv='" + sv.getMssv() + "' , lop='" + sv.getLop() + "', khoa='"
							+ sv.getLop() + "', ten='" + sv.getTen() + "', gt='" + sv.isGioiTinh() + "', ngaySinh='"
							+ parse + "', diaChi='" + sv.getDiaChi() + "', sdt='" + sv.getSdt() + "', quocTich='"
							+ sv.getQuocTich() + "' WHERE mssv='" + sv.getMssv() + "'");
			if (check > 0)
				System.out.println("Chỉnh sửa dữ liệu thành công");
			else
				System.out.println("Có lỗi khi chỉnh sửa");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<SinhVien> hienThiDS() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<SinhVien> ds = new ArrayList();
		try {
			ResultSet rs = this.data.getSt().executeQuery("SELECT * FROM sinhVien");
			/*
			 * System.out.format("%s%15s%15s%10s%10s%30s%15s%15s%15s%15s%15s%15s%15s", "ID",
			 * "Tài khoản", "MSSV", "Lớp", "Khoa", "Họ tên", "Giới tính", "Ngày sinh",
			 * "Địa Chỉ", "Số điện thoại", "Chức vụ", "Quốc tịch", " Ghi chú");
			 */
			if (!rs.wasNull()) {
				while (rs.next()) {
					ds.add(new SinhVien(rs.getInt("mssv"), rs.getString("lop"), rs.getString("khoa"),
							rs.getString("ten"), rs.getBoolean("gt"), df.format(rs.getDate("ngaySinh")),
							rs.getString("diaChi"), rs.getString("sdt"), rs.getString("quocTich")));

				}
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public List<SinhVien> timKiem(SinhVien sv) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<SinhVien> ds = new ArrayList();
		try {
			ResultSet rs = this.data.getSt().executeQuery("SELECT * FROM taiKhoan WHERE mssv='" + sv.getMssv() + "'");
			if (!rs.wasNull()) {
				while (rs.next()) {
					ds.add(new SinhVien(rs.getInt("mssv"), rs.getString("lop"), rs.getString("khoa"),
							rs.getString("ten"), rs.getBoolean("gt"), df.format(rs.getDate("ngaySinh")),
							rs.getString("diaChi"), rs.getString("sdt"), rs.getString("quocTich")));

				}
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void xoa(SinhVien sv) {
		try {

			int checkSV = this.data.getSt().executeUpdate("DELETE FROM sinhVien WHERE mssv='" + sv.getMssv() + "'");
			if (checkSV > 0)
				System.out.println("Đã xóa:" + sv.getTen());
			else
				System.out.println("Lỗi xóa: Không tìm thấy sinh viên " + sv.getTen());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
