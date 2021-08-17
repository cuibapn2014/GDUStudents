package com.gdustudent.v1;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class ThongTin {
    private String tieuDe;
    private Date ngayTao;
    private String nguoiViet;
    private String noiDung;
    private String danhMuc;

    public ThongTin() {
    }

    public ThongTin(String tieuDe, String ngayTao, String nguoiViet, String noiDung, String danhMuc)
            throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.tieuDe = tieuDe;
        this.ngayTao = df.parse(ngayTao);
        this.nguoiViet = nguoiViet;
        this.noiDung = noiDung;
        this.danhMuc = danhMuc;
    }

    protected String getTieuDe() {
        return this.tieuDe;
    }

    protected void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    protected Date getNgayTao() {
        return this.ngayTao;
    }

    protected void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    protected String getNguoiViet() {
        return this.nguoiViet;
    }

    protected void setNguoiViet(String nguoiViet) {
        this.nguoiViet = nguoiViet;
    }

    protected String getNoiDung() {
        return this.noiDung;
    }

    protected void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    protected String getDanhMuc() {
        return this.danhMuc;
    }

    protected void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String hienThi() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return "\nTiêu đề: " + this.tieuDe + "\nNgày tạo: " + df.format(this.ngayTao) + "\nNgười viết: "
                + this.nguoiViet + "\nNội dung: " + this.noiDung + "\nDanh mục" + this.danhMuc;
    }

    protected void tao() throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập tiêu đề: ");
        this.tieuDe = TestDrive.sc.nextLine();
        this.ngayTao = df.parse(df.format(LocalDate.now()));
        System.out.println("Nhập danh mục: ");
        this.danhMuc = TestDrive.sc.nextLine();
        System.out.println("Nhập nội dung");
        this.noiDung = TestDrive.sc.nextLine();
    }
}
