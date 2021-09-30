package com.gdustudent.v1;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TestDrive {
	public static Scanner sc = new Scanner(System.in);
	static DangNhap user = new DangNhap();
	static DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	static Formatter fmt = new Formatter();

	public static void main(String[] args) throws SQLException {
		do {
			user.dangNhap();

			try {
				int chon;
				boolean fleg = true;
				while (fleg) {
					Menu menu = new Menu();
					if (user.getTk().getQuyen() == 0) {
						menu.menuSV();
						System.out.println("Chọn chức năng");
						chon = sc.nextInt();
						sc.nextLine();
						switch (chon) {
						case 1:
							ThoiKhoaBieu tkb = new ThoiKhoaBieu();
							List<Lop> lich = tkb.xemTkb();
							fmt.format("\n%30s %20s %15s %15s %15s %20s", "Tên môn học", "Số TC", "Ca học", "Thứ",
									"Phòng học", "Giảng Viên\n");
							fmt.format("%s",
									"---------------------------------------------------------------------------------------------------------\n");
							for (Lop l : lich) {
								fmt.format("%30s %20d %15d %15d %15s %20s\n", l.getMonHoc(), l.getSoTC(), l.getCaHoc(),
										l.getThu(), l.getPhongHoc(), l.getGiangVien());
							}
							System.out.println(fmt);
							break;
						case 2:
							BangDiem diem = new BangDiem();
							List<Diem> bd = diem.xemDiem();
							fmt.format("\n%s %40s %15s %20s %15s %15s", "Tên môn học", "Điểm giữa học phần", "Điểm thi",
									"Điểm trung bình", "Điểm chữ", "Điểm thang 4\n");
							fmt.format("%s",
									"------------------------------------------------------------------------------------------------------------------------\n");
							for (Diem d : bd) {
								fmt.format("%30s %20.2f %15.2f %20.2f %15s %15.2f\n", d.getMonHoc(), d.getDiemGHP(),
										d.getDiemThi(), d.getDiemTb(), d.getDiemChu(), convertToFour(d.getDiemChu()));
							}
							System.out.println(fmt);
							break;
						case 3:
							SinhVien sv = (SinhVien) user.getTk().getHoSo();
							System.out.println("\n------------- Thông tin tài khoản --------------");
							System.out.println("Tài khoản: " + user.getTaiKhoan());
							System.out.println("Mật khẩu : *********");
							System.out.println("Họ tên   : " + sv.getTen());
							System.out.println("MSSV     : " + sv.getMssv());
							System.out.println("Lớp      : " + sv.getLop());
							System.out.println("Ngày sinh: " + f.format(sv.getNgaySinh()));
							System.out.println("Giới tính: " + convertGender(sv.isGioiTinh()));
							System.out.println("Địa chỉ  : " + sv.getDiaChi());
							System.out.println("Số ĐT    : " + sv.getSdt());
							System.out.println("Quốc tịch: " + sv.getQuocTich());
							break;
						case 4:
							QuanLyThongBao tb = new QuanLyThongBao();
							List<ThongTin> ds = tb.hienThiDS();
							if (ds.isEmpty())
								System.out.println("Không có thông báo nào");
							else
								System.out.println("\n------------- Thông báo --------------");
							for (ThongTin list : ds) {
								System.out.println("\n" + list.getTieuDe() + "| " + list.getDanhMuc());
								System.out.println("Người viết: " + list.getNguoiViet() + "| Thời gian: "
										+ f.format(list.getNgayTao()));
								System.out.println("Nội dung: " + list.getNoiDung());

							}
							break;
						case 5:
							Lop lb = new Lop("Cong nghe web", 3, "K13DCPM01", "Ths.Le Huynh Phuoc", "B203", 60, 3, 4);
							DangKyHP dk = new DangKyHP(lb);
							dk.dangKy();
							break;
						case 6:
							QuanLyTinTuc tt = new QuanLyTinTuc();
							List<ThongTin> ds1 = tt.hienThiDS();
							if (ds1.isEmpty())
								System.out.println("Không có thông báo nào");
							else
								System.out.println("\n------------- Tin tức --------------");
							for (ThongTin list : ds1) {
								System.out.println("\n" + list.getTieuDe() + "| " + list.getDanhMuc());
								System.out.println("Người viết: " + list.getNguoiViet() + "| Thời gian: "
										+ f.format(list.getNgayTao()));
								System.out.println("Nội dung: " + list.getNoiDung());

							}
							break;
						case 7:
							PhanAnh pa = new PhanAnh("Xin lùi lịch học",
									"Xin ban giám hiệu nhà trường cho dời lịch học", "Học tập");
							QuanLyPhanAnh qlpa = new QuanLyPhanAnh();
							qlpa.them(pa);
							break;
						case 8:
							QuanLyTaiKhoanSV sv1 = new QuanLyTaiKhoanSV();
							TaiKhoan tk3 = user.getTk();
							tk3.setMatKhau("123456");
							sv1.chinhSua(tk3);
							break;
						case 9:
							user.dangXuat();
							break;
						default:
							System.out.println("Không xác định chức năng");
						}
					} else {
						QuanLy sv = new QuanLyTaiKhoanSV();
						QuanLy qltb = new QuanLyThongBao();
						QuanLy qltt = new QuanLyTinTuc();
						QuanLyLop qll = new QuanLyLop();
						QuanLyTaiKhoanSV qltk = new QuanLyTaiKhoanSV();
						QuanLyPhanAnh qlpa = new QuanLyPhanAnh();
						SinhVien sv3;

						menu.menuQTV();

						System.out.println("Chọn chức năng");
						chon = sc.nextInt();
						sc.nextLine();

						switch (chon) {
						case 1:
							ConNguoi ng = new SinhVien(1911040012, "K13DCPM01", "CNTT", "Le Hoang Chi Nhan", true,
									"15/05/2001", "Ho Chi Minh", "346342525", "VietNam");
							TaiKhoan tk1 = new TaiKhoan("chinhan01", "123456", ng);
							List<TaiKhoan> ds = qltk.hienThiDS();

							sv.them(tk1);

							fmt.format("\n%s %30s %20s %20s %15s %15s %15s %15s %15s", "Tài khoản", "Tên sinh viên",
									"MSSV", "Lớp", "Ngày sinh", "Giới tính", "Địa chỉ", "SDT", "Quốc tịch\n");
							fmt.format("%s",
									"------------------------------------------------------------------------------------------------------------------------\n");

							for (TaiKhoan tk : ds) {
								sv3 = (SinhVien) tk.getHoSo();
								fmt.format("%s %30s %20s %20s %15s %15s %15s %15s %15s\n", tk.getTaiKhoan(),
										sv3.getTen(), sv3.getMssv(), sv3.getLop(), f.format(sv3.getNgaySinh()),
										convertGender(sv3.isGioiTinh()), sv3.getDiaChi(), sv3.getSdt(),
										sv3.getQuocTich());
							}
							System.out.println(fmt);

							break;
						case 2:
							ThongBao tb = new ThongBao("Ngay 16/09 toan truong tro lai hoc tap binh thuong",
									"20/08/2021", "Tu ngay 16/09 toan bo giang vien, sinh vien tro lai hoc tap va lam viec binh thuong", "Tin Nong");
							List<ThongBao> ds1 = qltb.hienThiDS();

							qltb.them(tb);

							fmt.format("\n%s %50s %20s %20s %15s %15s\n", "ID", "Tiêu đề", "Danh mục", "Ngày tạo",
									"Người viết", "Nội dung");
							fmt.format("%s",
									"------------------------------------------------------------------------------------------------------------------------\n");

							for (ThongBao tb1 : ds1) {
								fmt.format("%d %50s %20s %20s %15s %15s\n", tb1.getId(), tb1.getTieuDe(),
										tb1.getDanhMuc(), f.format(tb1.getNgayTao()), tb1.getNguoiViet(),
										tb1.getNoiDung());
							}
							System.out.println(fmt);

							break;
						case 3:
							TinTuc tt = new TinTuc(
									"Cong ty FPT Software tuyen dung", "05/09/2021",
									"Cong ty FPT Software tuyen dung vi tri Dev Front-end ReactJS, lien he truong phong nhan su 03423423523 Mr. Nhan", "Tuyen dung");
							qltt.them(tt);
							break;
						case 4:
							Lop l1 = new Lop("Lap trinh moi truong truc quan", 3, "K13DCPM01", "Ths.Nguyen Thanh Binh", "A202", 50, 2, 6);
							qll.them(l1);
							break;
						case 5:
							ConNguoi ng2 = new SinhVien(1911040008, "K13DCPM01", "CNTT", "Le Quoc An", true,
									"20/12/2001", "Ho Chi Minh", "1234567890", "VietNam");
							TaiKhoan tk2 = new TaiKhoan("leanbuu01", "123456789", ng2);
							sv.chinhSua(tk2);
							break;
						case 6:
							ThongBao tb2 = new ThongBao("Ngay 16/09 toan truong tro lai hoc tap binh thuong",
									"20/08/2021", "asdihwiafwfwfwef", "Tin Nong");
							qltb.chinhSua(tb2);
							break;
						case 7:
							TinTuc tt2 = new TinTuc("Ngay 16/09 toan truong tro lai hoc tap binh thuong", "20/08/2021",
									"asdihwiafwfwfwef", "Tin Nong");
							qltt.chinhSua(tt2);
							break;
						case 8:
							ConNguoi ng3 = new SinhVien(1911040008, "K13DCPM01", "CNTT", "Le Quoc An", true,
									"20/12/2001", "Ho Chi Minh", "1234567890", "VietNam");
							TaiKhoan tk3 = new TaiKhoan("leanbuu01", "123456789", ng3);
							sv.xoa(tk3);
							break;
						case 9:
							ThongBao tb3 = new ThongBao("Ngay 16/09 toan truong tro lai hoc tap binh thuong",
									"20/08/2021", "asdihwiafwfwfwef", "Tin Nong");
							tb3.setId(19);
							qltb.xoa(tb3);
							break;
						case 10:
							TinTuc tt3 = new TinTuc("Ngay 16/09 toan truong tro lai hoc tap binh thuong", "20/08/2021",
									"asdihwiafwfwfwef", "Tin Nong");
							tt3.setId(2);
							qltt.xoa(tt3);
							break;
						case 11:
							Lop l3 = new Lop("Thiet ke va xay dung phan mem", 3, "K13DCPM01", "Ths.Le Huynh Phuoc",
									"B203", 60, 3, 6);
							l3.setId(8);
							qll.xoa(l3);
							break;
						case 12:
							List<PhanAnh> dspa = qlpa.hienThiDS();

							fmt.format("\n%s %50s %20s %20s %15s %50s\n", "ID", "Tiêu đề", "Danh mục", "Ngày tạo",
									"Sinh Viên", "Nội dung");
							fmt.format("%s",
									"------------------------------------------------------------------------------------------------------------------------\n");

							for (PhanAnh pa : dspa) {
								fmt.format("%d %50s %20s %20s %15s %50s\n", pa.getId(), pa.getTieuDe(), pa.getDanhMuc(),
										f.format(pa.getNgayGui()), pa.getNguoiGui(), pa.getNoiDung());
							}
							System.out.println(fmt);

							break;
						case 13:
							PhanAnh pa1 = new PhanAnh();
							pa1.setId(3);
							qlpa.xuLyPhanAnh(pa1, "Chúng tôi sẽ giải quyết vấn đề này");
							break;
						case 14:
							user.dangXuat();
							fleg = false;
							break;
						}

					}

				}
			} catch (NullPointerException e) {
				System.out.println("\nLỗi: Bạn chưa đăng nhập vào hệ thống! Hãy thử lại\n");
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} while (user.getTrangThai() == false);
	}

	private static float convertToFour(String diemChu) {
		float convert;

		switch (diemChu) {
		case "A":
			convert = 4f;
			;
			break;
		case "B+":
			convert = 3.5f;
			;
			break;
		case "B":
			convert = 3f;
			;
			break;
		case "C+":
			convert = 2.5f;
			;
			break;
		case "C":
			convert = 2f;
			;
			break;
		case "D+":
			convert = 1.5f;
			;
			break;
		case "D":
			convert = 1f;
			;
			break;
		case "F+":
			convert = 0.5f;
			;
			break;
		case "F":
			convert = 0;
			;
			break;
		default:
			convert = 0;
			break;
		}
		return convert;
	}

	private static String convertGender(boolean gt) {
		if (gt)
			return "Nam";
		else
			return "Nữ";
	}
}