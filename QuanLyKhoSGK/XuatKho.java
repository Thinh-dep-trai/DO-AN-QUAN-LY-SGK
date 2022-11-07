package QuanLyKhoSGK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class XuatKho {

    static Scanner sc = new Scanner(System.in);

    public XuatKho(String maSGK, String phieuXuat, String loaiSach, String tenSach, String maThuKho, String ngayXuat,
            int soLuong, double thongKe, double donGia) {
        this.maSGK = maSGK;
        this.phieuXuat = phieuXuat;
        this.loaiSach = loaiSach;
        this.tenSach = tenSach;
        this.maThuKho = maThuKho;
        this.ngayXuat = ngayXuat;
        this.soLuong = soLuong;
        this.thongKe = thongKe;
        this.donGia = donGia;
    }

    public XuatKho() {
    }

    protected String maSGK, phieuXuat, loaiSach, tenSach, maThuKho, ngayXuat;
    protected int soLuong;
    protected double thongKe, donGia;

    public String getMaSGK() {
        return maSGK;
    }

    public void setMaSGK(String maSGK) {
        this.maSGK = maSGK;
    }

    public String getPhieuXuat() {
        return phieuXuat;
    }

    public void setPhieuXuat(String phieuXuat) {
        this.phieuXuat = phieuXuat;
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

    public String getMaThuKho() {
        return maThuKho;
    }

    public void setMaThuKho(String maThuKho) {
        this.maThuKho = maThuKho;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThongKe() {
        return thongKe;
    }

    public void setThongKe(double thongKe) {
        this.thongKe = thongKe;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void nhapxk() {
        System.out.print("Ma SGK: ");
        maSGK = sc.nextLine();
        System.out.print("Phieu xuat: ");
        phieuXuat = sc.nextLine();
        System.out.print("Loai sach: ");
        loaiSach = sc.nextLine();
        System.out.print("Ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Ma thu kho: ");
        maThuKho = sc.nextLine();
        System.out.print("Ngay xuat: ");
        ngayXuat = sc.nextLine();
        System.out.print("So luong: ");
        soLuong = sc.nextInt();
        System.out.print("Thong ke: ");
        thongKe = sc.nextDouble();
        System.out.print("Don gia: ");
        donGia = sc.nextDouble();
    }

    public void WriterToFile(List<XuatKho> list) {
        try {
            FileWriter fw = new FileWriter("C:\\lap trinh jv\\File\\text\\QLSGK.txt",true); //true
            BufferedWriter bw = new BufferedWriter(fw);
            for (XuatKho o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public String toString() {
        return "XuatKho [maSGK=" + maSGK + ", phieuXuat=" + phieuXuat + ", loaiSach=" + loaiSach + ", tenSach="
                + tenSach + ", maThuKho=" + maThuKho + ", ngayXuat=" + ngayXuat + ", soLuong=" + soLuong + ", thongKe="
                + thongKe + ", donGia=" + donGia + "]";
    }
}
