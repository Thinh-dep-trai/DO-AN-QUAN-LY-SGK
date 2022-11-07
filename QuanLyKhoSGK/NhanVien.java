package QuanLyKhoSGK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class NhanVien {
    static Scanner sc = new Scanner(System.in);
    private String maNV, tenTk, tenNV, matKhau;

    public NhanVien(String maNV, String tenTk, String tenNV, String matKhau) {
        this.maNV = maNV;
        this.tenTk = tenTk;
        this.tenNV = tenNV;
        this.matKhau = matKhau;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void nhapNV() {
        System.out.print("Ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Ten nhan vien: ");
        tenNV = sc.nextLine();
        System.out.print("Ten tai khoan: ");
        tenTk = sc.nextLine();
        System.out.print("Mat khau: ");
        matKhau = sc.nextLine();
    }

    public String toString() {
        return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", tenTk=" + tenTk + ", matKhau=" + matKhau + "]";
    }

    public void WriterToFile(List<NhanVien> list) {
        try {
            FileWriter fw = new FileWriter("C:\\lap trinh jv\\File\\text\\QLSGK.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhanVien o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
}
