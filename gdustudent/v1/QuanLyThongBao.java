package com.gdustudent.v1;

import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class QuanLyThongBao extends QuanLy<ThongTin> {
	private KetNoiCSDL data;

	public QuanLyThongBao() {
		try {
			this.data = new KetNoiCSDL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void them(ThongTin thongTin) {
		ThongBao tb = (ThongBao) thongTin;
		int idUser = TestDrive.user.getTk().getId();
		java.sql.Date date = new java.sql.Date(thongTin.getNgayTao().getTime());
		try {
			PreparedStatement ps = this.data.getConnection().prepareStatement(
					"INSERT INTO thongBao(tieuDe, ngayTao, id_nguoiViet, noiDung, danhMuc) VALUES(?,?,?,?,?)");
			ps.setString(1, tb.getTieuDe());
			ps.setDate(2, date);
			ps.setInt(3, idUser);
			ps.setString(4, tb.getNoiDung());
			ps.setString(5, tb.getDanhMuc());
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
	public void chinhSua(ThongTin thongTin) {
		ThongBao tb = (ThongBao) thongTin;
		try {
			PreparedStatement ps = this.data.getConnection()
					.prepareStatement("UPDATE thongBao SET tieuDe=?,noiDung=?,danhMuc=? WHERE id='" + tb.getId() + "'");
			ps.setString(1, tb.getTieuDe());
			ps.setString(2, tb.getNoiDung());
			ps.setString(3, tb.getDanhMuc());
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
	public List<ThongTin> timKiem(ThongTin thongTin) {
		ThongBao tb = (ThongBao) thongTin;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<ThongTin> ds = new ArrayList();
		try {
			PreparedStatement ps = this.data.getConnection().prepareStatement(
					"SELECT * FROM thongBao INNER JOIN taiKhoan ON thongbao.id_nguoiViet = taiKhoan.id WHERE tieuDe LIKE '%"
							+ tb.getTieuDe() + "%'");
			ResultSet rs = ps.executeQuery();
			if (!rs.wasNull()) {
				while (rs.next()) {
					ds.add(new ThongBao(rs.getString("tieuDe"), df.format(rs.getDate("ngayTao")),
							rs.getString("taiKhoan"), rs.getString("noiDung"), rs.getString("danhMuc")));
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
		ThongBao tb = (ThongBao) thongTin;
		try {
			int check = this.data.getSt().executeUpdate("DELETE FROM thongBao WHERE id='" + tb.getId() + "'");
			if (check >= 1)
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
		ThongBao tb;
		List<ThongTin> ds = new ArrayList();
		try {
			ResultSet rs = this.data.getSt()
					.executeQuery("SELECT * FROM thongBao INNER JOIN taiKhoan ON thongBao.id_nguoiViet = taiKhoan.id");
			while (rs.next()) {
				tb = new ThongBao(rs.getString("tieuDe"), df.format(rs.getDate("ngayTao")), rs.getString("taiKhoan"),
						rs.getString("noiDung"), rs.getString("danhMuc"));
				tb.setId(rs.getInt("id"));
				ds.add(tb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
