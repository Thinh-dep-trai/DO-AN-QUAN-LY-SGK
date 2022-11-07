package QuanLyKhoSGK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SGK {
    static List<SGK> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    protected String maSGK, tenSGK, tacGia, ngayXuatBan;
    private int soLuong;
    protected int lop;

    public SGK(String maSGK, String tenSGK, String tacGia, int soLuong, int lop, String ngayXuatBan) {
        this.maSGK = maSGK;
        this.tenSGK = tenSGK;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.lop = lop;
        this.ngayXuatBan = ngayXuatBan;
    }

    public SGK() {
    }

    public String getMaSGK() {
        return maSGK;
    }

    public void setMaSGK(String maSGK) {
        this.maSGK = maSGK;
    }

    public String getTenSGK() {
        return tenSGK;
    }

    public void setTenSGK(String tenSGK) {
        this.tenSGK = tenSGK;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public String getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(String ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public void nhapsgk() {
        System.out.print("Ma SGK: ");
        maSGK = sc.nextLine();
        System.out.print("Ten SGK: ");
        tenSGK = sc.nextLine();
        System.out.print("Tac gia: ");
        tacGia = sc.nextLine();
        System.out.print("Ngay xuat ban: ");
        ngayXuatBan = sc.nextLine();
        System.out.print("So luong: ");
        soLuong = sc.nextInt();
        System.out.print("Lop: ");
        lop = sc.nextInt();
        sc.nextLine();
    }

    public void WriterToFile(List<SGK> list) {
        try {
            FileWriter fw = new FileWriter("C:\\lap trinh jv\\File\\text\\QLSGK.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (SGK o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void xoaND()
    {
        
    }
    public String toString() {
        return "SGK [maSGK=" + maSGK + ", tenSGK=" + tenSGK + ", tacGia=" + tacGia + ", ngayXuatBan=" + ngayXuatBan
                + ", soLuong=" + soLuong + ", lop="
                + lop + "]";
    }
}
