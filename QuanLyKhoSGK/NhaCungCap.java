package QuanLyKhoSGK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class NhaCungCap implements Comparable<NhaCungCap> {
    static Scanner sc = new Scanner(System.in);

    private String maNCC, tenNCC, ghiChu, diaChi, SDT;

    public NhaCungCap(String maNCC, String tenNCC, String ghiChu, String diaChi, String SDT) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.ghiChu = ghiChu;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }

    public NhaCungCap() {
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void nhapncc() {
        System.out.print("Ma nhan cung cap: ");
        maNCC = sc.nextLine();
        System.out.print("Ten nha cung cap: ");
        tenNCC = sc.nextLine();
        System.out.print("Ghi chu: ");
        ghiChu = sc.nextLine();
        System.out.print("Dia chi: ");
        diaChi = sc.nextLine();
        System.out.print("So dien thoai: ");
        SDT = sc.nextLine();
    }

    public void WriterToFile(List<NhaCungCap> list) {
        try {
            FileWriter fw = new FileWriter("C:\\lap trinh jv\\File\\text\\QLSGK.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhaCungCap o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
        
    }

    public String toString() {
        return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", ghiChu=" + ghiChu + ", diaChi=" + diaChi
                + ", SDT=" + SDT + "]";
    }

    @Override
    public int compareTo(NhaCungCap o) {
        return this.maNCC.compareTo(o.getMaNCC());
    }
}
