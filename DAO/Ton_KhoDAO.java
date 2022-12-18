/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Ton_Kho;
import Giao_Dien.Database;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ton_KhoDAO {
    
   
    public boolean insert(Ton_Kho tk){
        try{
            String sql ="insert into TonKho(MaSP,TenSP,DVT,SoLuong,DonGia)"
                       +"values(?,?,?,?,?)";
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tk.getMaSP());
            ps.setString(2,tk.getTenSP());
            ps.setString(3, tk.getDVT());
            ps.setInt(4, tk.getSoLuong());
            ps.setLong(5, tk.getDonGia());
            
            return ps.executeUpdate() > 0; 
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public boolean delete(String MaSP){
        try{
            String sql = "delete from SoChiTietNhap where MaSP = ? "
                    + "delete from SoChiTietXuat where MaSP = ? "
                    + "delete from TonKho where MaSP = ?";           

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,MaSP);
            ps.setString(2,MaSP);
            ps.setString(3,MaSP);
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public boolean deleteAll(){
        try{
            String sql = "delete from SoChiTietNhap delete from SoChiTietXuat delete from TonKho";           
           Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);           
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
     public boolean update(Ton_Kho tk){
        try{
            String sql = "update TonKho set TenSP = ?, DVT = ?, SoLuong = ?,DonGia = ? "
                       + "where MaSP = ?";           

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
         
            ps.setString(1,tk.getTenSP());
            ps.setString(2, tk.getDVT());
            ps.setInt(3, tk.getSoLuong());
            ps.setLong(4, tk.getDonGia());
            ps.setString(5, tk.getMaSP());
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }   
   

}
