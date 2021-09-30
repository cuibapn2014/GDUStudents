package com.gdustudent.v1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThoiKhoaBieu {
	private KetNoiCSDL data;

	public List<Lop> xemTkb() {
		List<Lop> tkb = new ArrayList();
		SinhVien sv = (SinhVien) TestDrive.user.getTk().getHoSo();
		try {
			data = new KetNoiCSDL();
			ResultSet rs = data.getSt().executeQuery(
					"SELECT * FROM lop INNER JOIN dang_ky_hp ON lop.id = dang_ky_hp.id_lop WHERE dang_ky_hp.mssv='"
							+ sv.getMssv() + "'");
			while (rs.next()) {
				tkb.add(new Lop(rs.getString("mon_hoc"), rs.getInt("so_tc"), rs.getString("ten_lop"),
						rs.getString("giang_vien"), rs.getString("phong_hoc"), rs.getInt("so_luong"),
						rs.getInt("ca_hoc"), rs.getInt("thu")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tkb;
	}
}
