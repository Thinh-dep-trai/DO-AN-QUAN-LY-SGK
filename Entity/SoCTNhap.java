/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

public class SoCTNhap {
   
    public String MaPhieu,MaSP;
    public Date TimeGD;
    public String MaNV,MaNCC,DVT;
    public int SoLuong;
    public long DonGia;

    public SoCTNhap() {
        
    }

    public SoCTNhap(String MaPhieu, String MaSP, Date TimeGD, String MaNV, String MaNCC, String DVT, int SoLuong, long DonGia) {
        this.MaPhieu = MaPhieu;
        this.MaSP = MaSP;
        this.TimeGD = TimeGD;
        this.MaNV = MaNV;
        this.MaNCC = MaNCC;
        this.DVT = DVT;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Date getTimeGD() {
        return TimeGD;
    }

    public void setTimeGD(Date TimeGD) {
        this.TimeGD = TimeGD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getDonGia() {
        return DonGia;
    }

    public void setDonGia(long DonGia) {
        this.DonGia = DonGia;
    }
    
    }

  