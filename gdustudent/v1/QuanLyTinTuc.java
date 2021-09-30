package com.gdustudent.v1;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class QuanLyTinTuc extends QuanLy<ThongTin> {
	private KetNoiCSDL data;

	public QuanLyTinTuc() {
		try {
			this.data = new KetNoiCSDL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void them(ThongTin tinTuc) {
		TinTuc tt = (TinTuc) tinTuc;
		int idUser = TestDrive.user.getTk().getId();
		java.sql.Date date = new java.sql.Date(tinTuc.getNgayTao().getTime());
		try {
			PreparedStatement ps = this.data.getConnection().prepareStatement(
					"INSERT INTO tinTuc(tieuDe, ngayTao, id_nguoiViet, noiDung, danhMuc) VALUES(?,?,?,?,?)");
			ps.setString(1, tt.getTieuDe());
			ps.setDate(2, date);
			ps.setInt(3, idUser);
			ps.setString(4, tt.getNoiDung());
			ps.setString(5, tt.getDanhMuc());
			int check = ps.executeUpdate();
			if (check == 1)
				System.out.println("Tạo mới thành công");
			else
				System.out.println("Tạo mới thất bại! Hãy thử lại");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void chinhSua(ThongTin tinTuc) {
		TinTuc tt = (TinTuc) tinTuc;
		try {
			PreparedStatement ps = this.data.getConnection()
					.prepareStatement("UPDATE tinTuc SET tieuDe=?,noiDung=?,danhMuc=? WHERE id='" + tt.getId() + "'");
			ps.setString(1, tt.getTieuDe());
			ps.setString(2, tt.getNoiDung());
			ps.setString(3, tt.getDanhMuc());
			int check = ps.executeUpdate();
			if (check == 1)
				System.out.println("Đã chỉnh sửa thành công");
			else
				System.out.println("Chỉnh sửa thất bại! Hãy thử lại");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ThongTin> timKiem(ThongTin tinTuc) {
		TinTuc tt = (TinTuc) tinTuc;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<ThongTin> ds = new ArrayList();
		try {
			PreparedStatement ps = this.data.getConnection()
					.prepareStatement("SELECT * FROM tinTuc where tieuDe LIKE '%" + tt.getTieuDe() + "%'");
			ResultSet rs = ps.executeQuery();
			if (!rs.wasNull()) {
				while (rs.next()) {
					ds.add(new TinTuc(rs.getString("tieuDe"), df.format(rs.getDate("ngayTao")),
							rs.getString("nguoiViet"), rs.getString("noiDung"), rs.getString("danhMuc")));
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void xoa(ThongTin thongTin) {
		TinTuc tb = (TinTuc) thongTin;
		try {
			int check = this.data.getSt().executeUpdate("DELETE FROM tinTuc WHERE id='" + tb.getId() + "'");
			if (check == 1)
				System.out.println("Đã xóa");
			else
				System.out.println("Có lỗi trong khi xóa! Hãy thử lại");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ThongTin> hienThiDS() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		TinTuc tt;
		List<ThongTin> ds = new ArrayList();
		try {
			ResultSet rs = this.data.getSt()
					.executeQuery("SELECT * FROM tinTuc INNER JOIN taiKhoan ON tinTuc.id_nguoiViet = taiKhoan.id");
			if (!rs.wasNull()) {
				while (rs.next()) {
					tt = new TinTuc(rs.getString("tieuDe"), df.format(rs.getDate("ngayTao")), rs.getString("taiKhoan"),
							rs.getString("noiDung"), rs.getString("danhMuc"));
					tt.setId(rs.getInt("id"));
					ds.add(tt);
				}

			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
