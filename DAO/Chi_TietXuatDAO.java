/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.SoCTXuat;
import Giao_Dien.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author ASUS
 */
public class Chi_TietXuatDAO {
    
    public boolean update(SoCTXuat x){
        try{
            String sql = "update SoChiTietNhap set TimeGD = ?,MaNV = ?,MaNCC = ?, DVT = ?, SoLuong = ?,DonGia = ? "
                       + "where MaSP = ? and MaPhieu = ?";           

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new Date(x.getTimeGD().getTime()));
            ps.setString(2,x.getMaNV());
            ps.setString(3,x.getTenNN());
            ps.setString(4, x.getDVT());
            ps.setInt(5, x.getSoLuong());
            ps.setLong(6, x.getDonGia());
            ps.setString(7,x.getMaPhieu());
            ps.setString(8, x.getMaSP());           
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }                   
     public boolean insert(SoCTXuat x){
        try{
            String sql ="insert into SoChiTietXuat(TimeGD,MaPhieu,MaNV,TenNN,MaSP,DVT,SoLuong,DonGia)"
                       +"values(?,?,?,?,?,?,?,?)";
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new Date(x.getTimeGD().getTime()));
            ps.setString(2,x.getMaPhieu());
            ps.setString(3,x.getMaNV());
            ps.setString(4,x.getTenNN());
            ps.setString(5, x.getMaSP());
            ps.setString(6, x.getDVT());
            ps.setInt(7, x.getSoLuong());
            ps.setLong(8, x.getDonGia());
            
            return ps.executeUpdate() > 0; 
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
        public boolean delete(SoCTXuat n){
        try{
            String sql = "delete from SoChiTietXuat where TimeGD = ? and MaPhieu = ? and MaNV = ? and TenNN = ? and MaSP = ? and DVT = ? and SoLuong = ? and DonGia = ? ";
                              

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new Date(n.getTimeGD().getTime()));
            ps.setString(2,n.getMaPhieu());
            ps.setString(3,n.getMaNV());
            ps.setString(4,n.getTenNN());
            ps.setString(5, n.getMaSP());
            ps.setString(6, n.getDVT());
            ps.setInt(7, n.getSoLuong());
            ps.setLong(8, n.getDonGia());
            return ps.executeUpdate() > 0;
            
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
