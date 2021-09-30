package com.gdustudent.v1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BangDiem {
	private KetNoiCSDL data;

	public BangDiem() {
	}

	protected List<Diem> xemDiem() {
		List<Diem> diem = new ArrayList<Diem>();
		try {
			this.data = new KetNoiCSDL();
			SinhVien sv = (SinhVien) TestDrive.user.getTk().getHoSo();
			ResultSet rs = this.data.getSt().executeQuery("SELECT * FROM diem WHERE mssv='" + sv.getMssv() + "'");
			while (rs.next()) {
				diem.add(new Diem(rs.getString("monHoc"), rs.getFloat("diemGHP"), rs.getFloat("diemThi"),
						rs.getFloat("diemTb"), rs.getString("diemChu")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diem;
	}
}
