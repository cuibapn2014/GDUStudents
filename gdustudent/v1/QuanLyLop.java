package com.gdustudent.v1;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class QuanLyLop extends QuanLy<Lop> {
	private KetNoiCSDL data;

	public QuanLyLop() {
		try {
			data = new KetNoiCSDL();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void them(Lop lop) {
		try {
			KetNoiCSDL data = new KetNoiCSDL();
			data = new KetNoiCSDL();
			ResultSet rs, rs1;
			rs = data.getSt().executeQuery("SELECT * FROM lop WHERE phong_hoc = '" + lop.getPhongHoc()
					+ "' AND ca_hoc='" + lop.getCaHoc() + "' AND thu='" + lop.getThu() + "'");
			if (!rs.next()) {
				int check = data.getSt().executeUpdate(
						"INSERT INTO lop(ten_lop, mon_hoc, so_tc, ca_hoc, phong_hoc, giang_vien, so_luong, thu) VALUES('"
								+ lop.getLop() + "','" + lop.getMonHoc() + "','" + lop.getSoTC() + "','"
								+ lop.getCaHoc() + "','" + lop.getPhongHoc() + "','" + lop.getGiangVien() + "','"
								+ lop.getSoLuong() + "','" + lop.getThu() + "')");
				System.out.println((check > 0) ? "Thêm thành công" : "Thêm thất bại");
			} else {
				System.out.println("Hệ thống đã tồn tại lớp học: " + lop.getMonHoc() + " | Hoặc lớp học bị trùng lịch");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void chinhSua(Lop lop) {
		try {
			KetNoiCSDL data = new KetNoiCSDL();
			data = new KetNoiCSDL();
			ResultSet rs, rs1;
			rs = data.getSt().executeQuery(
					"SELECT * FROM lop WHERE ten_lop='" + lop.getLop() + "' AND mon_hoc='" + lop.getMonHoc() + "'");
			if (rs.next()) {
				int check = data.getSt()
						.executeUpdate("UPDATE lop SET ten_lop='" + lop.getLop() + "', mon_hoc='" + lop.getMonHoc()
								+ "',so_tc='" + lop.getSoTC() + "', ca_hoc='" + lop.getCaHoc() + "',phong_hoc='"
								+ lop.getPhongHoc() + "',giang_vien='" + lop.getGiangVien() + "',so_luong='"
								+ lop.getSoLuong() + "' WHERE ten_lop='" + lop.getLop() + "' AND mon_hoc='"
								+ lop.getMonHoc() + "'");
				System.out.println((check > 0) ? "Chỉnh sửa thành công" : "Chỉnh sửa thất bại");
			} else {
				System.out.println("Hệ thống đã tồn tại lớp học: " + lop.getMonHoc());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Lop> hienThiDS() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Lop> ds = new ArrayList();
		try {
			ResultSet rs = this.data.getSt().executeQuery("SELECT * FROM Lop");
			if (!rs.wasNull()) {
				while (rs.next()) {
					ds.add(new Lop(rs.getString("mon_hoc"), rs.getInt("so_tc"), rs.getString("ten_lop"),
							rs.getString("giang_vien"), rs.getString("phong_hoc"), rs.getInt("so_luong"),
							rs.getInt("ca_hoc"), rs.getInt("thu")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public List<Lop> timKiem(Lop lop) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Lop> ds = new ArrayList();
		try {
			ResultSet rs = this.data.getSt().executeQuery("SELECT * FROM lop WHERE ten_lop='" + lop.getLop() + "'");
			if (!rs.wasNull()) {
				while (rs.next()) {
					ds.add(new Lop(rs.getString("mon_hoc"), rs.getInt("so_tc"), rs.getString("ten_lop"),
							rs.getString("giang_vien"), rs.getString("phong_hoc"), rs.getInt("so_luong"),
							rs.getInt("ca_hoc"), rs.getInt("thu")));
				}
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public void xoa(Lop lop) {
		DangKyHP dk = new DangKyHP();
		try {
			int check = this.data.getSt().executeUpdate("DELETE FROM lop WHERE id='" + lop.getId() + "'");
			dk.xoa(lop.getId());
			if (check > 0)
				System.out.println("Đã xóa thành công");
			else
				System.out.println("Lỗi xóa: Không tìm thấy Lớp: " + lop.getLop() + " - " + lop.getMonHoc());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
