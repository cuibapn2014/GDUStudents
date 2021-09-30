package com.gdustudent.v1;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DangKyHP {
	private KetNoiCSDL data;
	private Lop lop;

	public DangKyHP() {
		try {
			data = new KetNoiCSDL();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public DangKyHP(Lop lop) {
		try {
			data = new KetNoiCSDL();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		this.lop = lop;
	}

	public void dangKy() {
		SinhVien sv = (SinhVien) TestDrive.user.getTk().getHoSo();
		try {
			ResultSet rs, rs1;
			boolean checkSV = true;
			int idLop = 0, mssv, soLuong = 0, sucChua = 0;
			rs = kiemTra();
			if (rs.next()) {
				sucChua = rs.getInt("so_luong");
				idLop = rs.getInt("id");
				mssv = rs.getInt("mssv");
				checkSV = mssv == sv.getMssv() ? false : true;
				while (rs.next()) {
					soLuong++;
					if (checkSV == false)
						break;
					checkSV = rs.getInt("mssv") == sv.getMssv() ? false : true;

				}
				if (checkSV && idLop != 0 && soLuong < sucChua) {
					KetNoiCSDL _data = new KetNoiCSDL();
					int check = _data.getSt().executeUpdate(
							"INSERT INTO dang_ky_hp(id_lop,mssv) VALUES('" + idLop + "','" + sv.getMssv() + "')");
					System.out.println((check > 0) ? "Đăng ký thành công!" : "Lỗi đăng ký");
				} else {
					System.out.println("Lớp đã đầy hoặc bạn đã có mặt trong lớp!");
				}
			} else {
				rs1 = this.data.getSt()
						.executeQuery("SELECT id FROM lop WHERE (ten_lop='" + this.lop.getLop() + "' AND mon_hoc='"
								+ this.lop.getMonHoc() + "') AND (lop.ca_hoc='" + this.lop.getCaHoc()
								+ "' AND lop.thu='" + this.lop.getThu() + "')");
				if (rs1.next()) {
					KetNoiCSDL data2 = new KetNoiCSDL();
					int check = 0;
					check = data2.getSt().executeUpdate("INSERT INTO dang_ky_hp(id_lop,mssv) VALUES('"
							+ rs1.getInt("id") + "','" + sv.getMssv() + "')");
					System.out.println((check > 0) ? "Đăng ký thành công!" : "Lỗi đăng ký");
				}
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoa(int id) {
		try {
			int check = this.data.getSt().executeUpdate("DELETE FROM dang_ky_hp WHERE id_lop='" + id + "'");
			if (check > 0)
				System.out.println("Đã xóa thành công");

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	private ResultSet kiemTra() {
		try {
			KetNoiCSDL csdl = new KetNoiCSDL();
			ResultSet rs = csdl.getSt().executeQuery(
					"SELECT * FROM dang_ky_hp INNER JOIN lop ON dang_ky_hp.id_lop = lop.id WHERE lop.ten_lop = '"
							+ this.lop.getLop() + "' AND lop.mon_hoc = '" + this.lop.getMonHoc()
							+ "' AND lop.ca_hoc = '" + this.lop.getCaHoc() + "' AND lop.thu='" + this.lop.getThu()
							+ "'");
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
