package com.gdustudent.v1;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TinTuc extends ThongTin {
	public TinTuc() {
	}

	public TinTuc(String tieuDe, String ngayTao, String nguoiViet, String noiDung, String danhMuc)
			throws ParseException {
		super(tieuDe, ngayTao, nguoiViet, noiDung, danhMuc);
	}

	@Override
	public String hienThi() {
		return super.hienThi();
	}

	@Override
	protected void tao() throws ParseException {
		super.tao();
	}
}
