package com.gdustudent.v1;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QuanLyPhanAnh extends QuanLy<PhanAnh> {
	private KetNoiCSDL data;

	public QuanLyPhanAnh() {
		try {
			data = new KetNoiCSDL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void them(PhanAnh phanAnh) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		String ngGui = TestDrive.user.getTk().getHoSo().getTen();
		try {
			int check = this.data.getSt()
					.executeUpdate("INSERT INTO phanAnh(tieuDe,danhMuc, noiDung, ngayGui, nguoiGui, trangThai) VALUES('"
							+ phanAnh.getTieuDe() + "','" + phanAnh.getDanhMuc() + "','" + phanAnh.getNoiDung() + "','"
							+ date + "','" + ngGui + "','0')");
			if (check > 0)
				System.out.println("Đã gửi phản ánh");
			else
				System.out.println("Có lỗi trong quá trình gửi phản ánh! Hãy thử lại");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void chinhSua(PhanAnh phanAnh) {
		try {
			int check = this.data.getSt()
					.executeUpdate("UPDATE phanAnh SET tieuDe='" + phanAnh.getTieuDe() + "', danhMuc='"
							+ phanAnh.getDanhMuc() + "', noiDung='" + phanAnh.getNoiDung() + "' WHERE tieuDe = '"
							+ phanAnh.getTieuDe() + "'");
			if (check > 0)
				System.out.println("Chỉnh sửa thành công");
			else
				System.out.println("Có lỗi trong quá trình chỉnh sửa! Hãy thử lại");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<PhanAnh> timKiem(PhanAnh phanAnh) {
		List<PhanAnh> ds = new ArrayList<PhanAnh>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String parse;
		try {
			ResultSet rs = this.data.getSt()
					.executeQuery("SELECT * FROM phanAnh WHERE tieuDe='" + phanAnh.getTieuDe() + "'");
			while (rs.next()) {
				parse = df.format(rs.getDate("ngayGui"));
				ds.add(new PhanAnh(rs.getString("tieuDe"), rs.getString("noiDung"), parse, rs.getString("danhMuc"),
						rs.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public void xoa(PhanAnh phanAnh) {
		try {
			int check = this.data.getSt()
					.executeUpdate("DELETE FROM phanAnh WHERE tieuDe='" + phanAnh.getTieuDe() + "'");
			if (check > 0)
				System.out.println("Xóa thành công");
			else
				System.out.println("Có lỗi trong quá trình xóa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<PhanAnh> hienThiDS() {
		List<PhanAnh> ds = new ArrayList<PhanAnh>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String parse;
		try {
			ResultSet rs = this.data.getSt().executeQuery("SELECT * FROM phanAnh");
			while (rs.next()) {
				parse = df.format(rs.getDate("ngayGui").getTime());
				PhanAnh pa = new PhanAnh(rs.getString("tieuDe"), rs.getString("noiDung"), parse,
						rs.getString("danhMuc"), rs.getInt("id"));
				pa.setNguoiGui(rs.getString("nguoiGui"));
				ds.add(pa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	protected void xuLyPhanAnh(PhanAnh phanAnh, String noiDung) {
		try {
			KetNoiCSDL data2 = new KetNoiCSDL();
			ResultSet rs = this.data.getSt()
					.executeQuery("SELECT id FROM phanAnh WHERE id='" + phanAnh.getId() + "' AND trangThai='0'");
			int check = rs.next() ? (this.data.getSt()
					.executeUpdate("INSERT INTO xu_ly_phanAnh(id_phanAnh, noiDung) VALUES('" + phanAnh.getId() + "','"
							+ noiDung + "')")
					* data2.getSt()
							.executeUpdate("UPDATE phanAnh SET trangThai='1' WHERE id='" + phanAnh.getId() + "'"))
					: 0;
			if (check > 0)
				System.out.println("Đã xử lý phản ánh");
			else
				System.out.println(
						"Có lỗi trong quá trình xử lý hoặc phản ánh đã được xử lý trước đó! Vui lòng kiểm tra lại");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
