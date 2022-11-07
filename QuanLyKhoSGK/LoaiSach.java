package QuanLyKhoSGK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class LoaiSach {
    static Scanner sc = new Scanner(System.in);
    private String maLoaiSGk, tenLoaiSGK;
    private int lop;

    public LoaiSach(String maLoaiSGk, String tenLoaiSGK, int lop) {
        this.maLoaiSGk = maLoaiSGk;
        this.tenLoaiSGK = tenLoaiSGK;
        this.lop = lop;
    }

    public LoaiSach() {
    }

    public String getMaLoaiSGk() {
        return maLoaiSGk;
    }

    public void setMaLoaiSGk(String maLoaiSGk) {
        this.maLoaiSGk = maLoaiSGk;
    }

    public String getTenLoaiSGK() {
        return tenLoaiSGK;
    }

    public void setTenLoaiSGK(String tenLoaiSGK) {
        this.tenLoaiSGK = tenLoaiSGK;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public void nhapLs() {
        System.out.print("Ma loai sach: ");
        maLoaiSGk = sc.nextLine();
        System.out.print("Ten loai sach: ");
        tenLoaiSGK = sc.nextLine();
        System.out.print("Lop: ");
        lop = sc.nextInt();
        sc.nextLine();
    }
    public void WriterToFile(List<LoaiSach> list) {
        try {
            FileWriter fw = new FileWriter("C:\\lap trinh jv\\File\\text\\QLSGK.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (LoaiSach o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }


    public String toString() {
        return "LoaiSach [maLoaiSGk=" + maLoaiSGk + ", tenLoaiSGK=" + tenLoaiSGK + ", lop=" + lop + "]";
    }
}
