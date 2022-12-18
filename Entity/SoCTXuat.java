
package Entity;

import java.util.Date;

public class SoCTXuat {
    public Date TimeGD;
    public String MaPhieu,MaNV,TenNN,MaSP,DVT;
    public int SoLuong;
    public long DonGia;

    public SoCTXuat() {
    }

    public SoCTXuat(Date TimeGD, String MaPhieu, String MaNV, String TenNN, String MaSP, String DVT, int SoLuong, long DonGia) {
        this.TimeGD = TimeGD;
        this.MaPhieu = MaPhieu;
        this.MaNV = MaNV;
        this.TenNN = TenNN;
        this.MaSP = MaSP;
        this.DVT = DVT;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public Date getTimeGD() {
        return TimeGD;
    }

    public void setTimeGD(Date TimeGD) {
        this.TimeGD = TimeGD;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNN() {
        return TenNN;
    }

    public void setTenNN(String TenNN) {
        this.TenNN = TenNN;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
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
