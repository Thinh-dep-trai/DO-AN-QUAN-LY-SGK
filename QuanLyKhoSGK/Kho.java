package QuanLyKhoSGK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class Kho {
    static Scanner sc = new Scanner(System.in);
    private String maKho, tenKho, diaDiem;

    public Kho(String maKho, String tenKho, String diaDiem) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.diaDiem = diaDiem;
    }

    public Kho() {
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public void nhapk() {
        System.out.print("Ma kho: ");
        maKho = sc.nextLine();
        System.out.print("Ten kho: ");
        tenKho = sc.nextLine();
        System.out.print("Dia diem: ");
        diaDiem = sc.nextLine();
    }

    public void WriterToFile(List<Kho> list) {
        try {
            FileWriter fw = new FileWriter("C:\\lap trinh jv\\File\\text\\QLSGK.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Kho o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    
    public String toString() {
        return "Kho [maKho=" + maKho + ", tenKho=" + tenKho + ", diaDiem=" + diaDiem + "]";
    }
}
