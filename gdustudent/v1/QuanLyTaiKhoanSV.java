package com.gdustudent.v1;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class QuanLyTaiKhoanSV extends QuanLy<TaiKhoan> {
	KetNoiCSDL data;

	public QuanLyTaiKhoanSV() {
		try {
			data = new KetNoiCSDL();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void them(TaiKhoan tk) {
		try {
			KetNoiCSDL data = new KetNoiCSDL();
			data = new KetNoiCSDL();
			ResultSet rs;
			SinhVien sv = (SinhVien) tk.getHoSo();
			QuanLySinhVien qlsv = new QuanLySinhVien();
			rs = data.getSt().executeQuery("SELECT taiKhoan FROM taiKhoan WHERE taiKhoan='" + tk.getTaiKhoan() + "'");
			if (rs.next()) {
				System.out.println("Tài khoản đã tồn tại !");
			} else {
				try {
					data.getSt().executeUpdate("INSERT INTO taiKhoan(taiKhoan, matKhau, quyen) VALUES('"
							+ tk.getTaiKhoan() + "','" + tk.getMatKhau() + "','" + tk.getQuyen() + "')");
					qlsv.them(sv);
					data.getConnection().close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void chinhSua(TaiKhoan tk) {
		try {
			KetNoiCSDL data = new KetNoiCSDL();
			QuanLySinhVien qlsv = new QuanLySinhVien();
			SinhVien sv = (SinhVien) tk.getHoSo();
			data.getSt().executeUpdate(
					"UPDATE taiKhoan SET matKhau='" + tk.getMatKhau() + "' WHERE taiKhoan='" + tk.getTaiKhoan() + "'");
			qlsv.chinhSua(sv);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<TaiKhoan> hienThiDS() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<TaiKhoan> ds = new ArrayList();
		try {
			ResultSet rs = this.data.getSt()
					.executeQuery("SELECT * FROM taiKhoan AS tk INNER JOIN sinhVien AS sv ON tk.id=sv.id_taiKhoan");
			/*
			 * System.out.format("%s%15s%15s%10s%10s%30s%15s%15s%15s%15s%15s%15s%15s", "ID",
			 * "Tài khoản", "MSSV", "Lớp", "Khoa", "Họ tên", "Giới tính", "Ngày sinh",
			 * "Địa Chỉ", "Số điện thoại", "Chức vụ", "Quốc tịch", " Ghi chú");
			 */
			if (!rs.wasNull()) {
				while (rs.next()) {
					ds.add(new TaiKhoan(rs.getString("taiKhoan"), rs.getString("matKhau"),
							new SinhVien(rs.getInt("mssv"), rs.getString("lop"), rs.getString("khoa"),
									rs.getString("ten"), rs.getBoolean("gt"), df.format(rs.getDate("ngaySinh")),
									rs.getString("diaChi"), rs.getString("sdt"), rs.getString("quocTich"))));

				}
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public List<TaiKhoan> timKiem(TaiKhoan tk) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SinhVien sv = (SinhVien) tk.getHoSo();
		List<TaiKhoan> ds = new ArrayList();
		try {
			ResultSet rs = this.data.getSt().executeQuery(
					"SELECT * FROM taiKhoan AS tk INNER JOIN sinhVien AS sv ON tk.id=sv.id_taiKhoan WHERE sv.mssv='"
							+ sv.getMssv() + "'");
			if (!rs.wasNull()) {
				while (rs.next()) {
					ds.add(new TaiKhoan(rs.getString("taiKhoan"), rs.getString("matKhau"),
							new SinhVien(rs.getInt("mssv"), rs.getString("lop"), rs.getString("khoa"),
									rs.getString("ten"), rs.getBoolean("gt"), df.format(rs.getDate("ngaySinh")),
									rs.getString("diaChi"), rs.getString("sdt"), rs.getString("quocTich"))));

				}
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void xoa(TaiKhoan tk) {
		SinhVien sv = (SinhVien) tk.getHoSo();
		QuanLySinhVien qlsv = new QuanLySinhVien();
		try {
			ResultSet rs = this.data.getSt()
					.executeQuery("SELECT id FROM taiKhoan WHERE taiKhoan='" + tk.getTaiKhoan() + "'");
			if (rs.next()) {
				int checkTK = this.data.getSt()
						.executeUpdate("DELETE FROM taiKhoan WHERE taiKhoan='" + tk.getTaiKhoan() + "'");
				qlsv.xoa(sv);
				if (checkTK > 0)
					System.out.println("Đã xóa:" + tk.getTaiKhoan());
			} else
				System.out.println("Lỗi xóa: Không tìm thấy tài khoản " + tk.getTaiKhoan());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void permision(String tk, int quyen) {
		try {
			int check = this.data.getSt()
					.executeUpdate("UPDATE taiKhoan SET quyen='" + quyen + "' WHERE taiKhoan='" + tk + "'");
			if (check > 0)
				System.out.println("Đã chỉnh sửa quyền tài khoản thành Quản trị viên");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
