/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.NhaCungCap;
import Giao_Dien.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ASUS
 */
public class Nha_CungCapDAO {
    
      public boolean insert(NhaCungCap n){
        try{
            String sql ="insert into NhaCungCap(MaNCC,TenNCC,DiaChi,SDT)"
                       +"values(?,?,?,?)";
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getMaNCC());
            ps.setString(2,n.getTenNCC());
            ps.setString(3, n.getDiaChi());
            ps.setString(4, n.getSDT());
      
            return ps.executeUpdate() > 0; 
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public boolean delete(String MaNCC){
        try{
            String sql = "delete from SoChiTietNhap where MaNCC = ? "
                    + "delete from NhaCungCap where MaNCC = ?";           

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,MaNCC);
            ps.setString(2,MaNCC);
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public boolean update(NhaCungCap n){
        try{
            String sql = "update NhaCungCap set TenNCC = ?, DiaChi = ?, SDT = ? "
                       + "where MaNCC = ?";           

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
         
            ps.setString(1,n.getTenNCC());
            ps.setString(2, n.getDiaChi());
            ps.setString(3, n.getSDT());
            ps.setString(4, n.getMaNCC());
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }   
    public boolean deleteAll(){
        try{
            String sql = "delete from SoChiTietNhap delete from SoChiTietXuat delete from NhaCungCap";           
           Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);           
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
