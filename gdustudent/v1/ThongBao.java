package com.gdustudent.v1;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ThongBao extends ThongTin {
	public ThongBao() {
	}

	public ThongBao(String tieuDe, String ngayTao, String noiDung, String danhMuc)
			throws ParseException {
		super(tieuDe, ngayTao, noiDung, danhMuc);
	}
	
	public ThongBao(String tieuDe, String ngayTao, String nguoiViet, String noiDung, String danhMuc)
			throws ParseException {
		super(tieuDe, ngayTao, nguoiViet, noiDung, danhMuc);
	}

}
