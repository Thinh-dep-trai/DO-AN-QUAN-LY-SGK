package QuanLyKhoSGK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class NhapKho {
    static Scanner sc = new Scanner(System.in);
    private String maSGK, phieuNhap, loaiSach, tenSach, maNCC, maNV, ngayNhap;
    private int soLuong;
    private double donGia;

    public NhapKho() {
    }

    public NhapKho(String maSGK, String phieuNhap, String ngayNhap, String loaiSach, String tenSach, String maNCC,
            String maNV, int soLuong, double donGia) {
        this.maSGK = maSGK;
        this.phieuNhap = phieuNhap;
        this.ngayNhap = ngayNhap;
        this.loaiSach = loaiSach;
        this.tenSach = tenSach;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaSGK() {
        return maSGK;
    }

    public void setMaSGK(String maSGK) {
        this.maSGK = maSGK;
    }

    public String getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(String phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void WriterToFile(List<NhapKho> list) {
        try {
            FileWriter fw = new FileWriter("C:\\lap trinh jv\\File\\text\\QLSGK.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhapKho o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public void nhapKho() {
        System.out.print("Ma SGK: ");
        maSGK = sc.nextLine();
        System.out.print("Phieu nhap: ");
        phieuNhap = sc.nextLine();
        System.out.print("Loai sach: ");
        loaiSach = sc.nextLine();
        System.out.print("Ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Ma nha cung cap: ");
        maNCC = sc.nextLine();
        System.out.print("Ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Ngay nhap: ");
        ngayNhap = sc.nextLine();
        System.out.print("so luong: ");
        soLuong = sc.nextInt();
        System.out.print("don gia: ");
        donGia = sc.nextInt();
        sc.nextLine();
    }

    public String toString() {
        return "NhapKho [maSGK=" + maSGK + ", phieuNhap=" + phieuNhap + ", loaiSach="
                + loaiSach + ", tenSach=" + tenSach + ", maNCC=" + maNCC + ", maNV=" + maNV + ", ngayNhap=" + ngayNhap
                + ", soLuong=" + soLuong
                + ", donGia=" + donGia + "]";
    }
}