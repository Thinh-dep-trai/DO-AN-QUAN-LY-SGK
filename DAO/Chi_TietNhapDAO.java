/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.SoCTNhap;
import Giao_Dien.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Chi_TietNhapDAO {
    public boolean insert(SoCTNhap n){
        try{
            String sql ="insert into SoChiTietNhap(MaPhieu,MaSP,TimeGD,MaNV,MaNCC,DVT,SoLuong,DonGia)"
                       +"values(?,?,?,?,?,?,?,?)";
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1,n.getMaPhieu());
            ps.setString(2, n.getMaSP());           
            ps.setDate(3, new Date(n.getTimeGD().getTime()));
            ps.setString(4,n.getMaNV());
            ps.setString(5,n.getMaNCC());
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
    public boolean delete(SoCTNhap n){
        try{
            String sql = "delete from SoChiTietNhap where MaPhieu = ? and MaSP = ? ";
                              

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,n.getMaPhieu());
            ps.setString(2, n.getMaSP());           

            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
     public boolean update(SoCTNhap n){
        try{
            String sql = "update SoChiTietNhap set MaNV = ?,MaNCC = ?, DVT = ?, SoLuong = ?,DonGia = ? "
                       + "where MaSP = ? and MaPhieu = ? and TimeGD = ?";           

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,n.getMaNV());
            ps.setString(2,n.getMaNCC());
            ps.setString(3, n.getDVT());
            ps.setInt(4, n.getSoLuong());
            ps.setLong(5, n.getDonGia());
            ps.setString(6,n.getMaPhieu());
            ps.setString(7, n.getMaSP());           
            ps.setDate(8, new Date(n.getTimeGD().getTime()));
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }   
   
}
