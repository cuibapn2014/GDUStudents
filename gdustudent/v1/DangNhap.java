package com.gdustudent.v1;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DangNhap {
	private String taiKhoan;
	private String matKhau;
	private boolean trangThai = false;
	private TaiKhoan tk;
	KetNoiCSDL data;

	public DangNhap() {

	}

	public DangNhap(String taiKhoan, String matKhau) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	protected String getTaiKhoan() {
		return taiKhoan;
	}

	protected void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	protected String getMatKhau() {
		return matKhau;
	}

	protected void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean getTrangThai() {
		return this.trangThai;
	}

	public TaiKhoan getTk() {
		if (!this.tk.equals(null))
			return this.tk;

		return null;
	}

	public void dangNhap() throws SQLException {
		System.out.println("-----------Chào mừng bạn đến với GDUStudents-----------");
		System.out.println("___________________ ĐĂNG NHẬP___________________");
		System.out.println("- Tên Tài Khoản: ");
		this.taiKhoan = TestDrive.sc.nextLine();
		System.out.println("- Mật Khẩu: ");
		this.matKhau = TestDrive.sc.nextLine();
		try {
			data = new KetNoiCSDL();
			data.kiemTraKetNoi();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		ResultSet rs = data.getSt().executeQuery(
				"SELECT * FROM taiKhoan WHERE  taiKhoan='" + this.taiKhoan + "' AND matKhau='" + this.matKhau + "'");
		if (rs.next()) {
			rs = data.getSt().executeQuery(
					"SELECT * FROM sinhVien as sv INNER JOIN taiKhoan as tk ON tk.id = sv.id_taiKhoan WHERE  taiKhoan='"
							+ this.taiKhoan + "'");
			rs.next();
			if (rs.getInt("quyen") == 0) {
				String parse = TestDrive.f.format(rs.getDate("ngaySinh"));
				this.tk = new TaiKhoan(this.taiKhoan, this.matKhau,
						new SinhVien(rs.getInt("mssv"), rs.getString("lop"), rs.getString("khoa"), rs.getString("ten"),
								rs.getBoolean("gt"), parse, rs.getString("diaChi"), rs.getString("sdt"),
								rs.getString("quocTich")),
						rs.getInt("quyen"));
				this.tk.setId(rs.getInt("id"));
			} else {
				String parse = TestDrive.f.format(rs.getDate("ngaySinh"));
				this.tk = new TaiKhoan(
						this.taiKhoan, this.matKhau, new QuanTriVien(rs.getString("ten"), rs.getBoolean("gt"), parse,
								rs.getString("diaChi"), rs.getString("sdt"), rs.getString("quocTich")),
						rs.getInt("quyen"));
				this.tk.setId(rs.getInt("id"));
			}
			this.trangThai = true;
		} else {
			this.trangThai = false;
		}
		data.getConnection().close();
	}

	public void dangXuat() {
		this.tk = null;
		this.trangThai = false;
	}

}
