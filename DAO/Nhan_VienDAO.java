/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.TaiKhoan;
import Entity.Ton_Kho;
import Giao_Dien.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ASUS
 */
public class Nhan_VienDAO {
    public boolean insert(TaiKhoan tk){
        try{
            String sql ="insert into DangNhap(HoTen,MaSo,ChucVu,TenDangNhap,MatKhau,Gmail,DiaChi)"
                       +"values(?,?,?,?,?,?,?)";
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tk.getHoTen());
            ps.setString(2,tk.getMaSo());
            ps.setString(3, tk.getChucVu());
            ps.setString(4, tk.getTenDangNhap());
            ps.setString(5, tk.getMatKhau());
            ps.setString(6, tk.getGmail());
            ps.setString(7, tk.getDiaChi());
            return ps.executeUpdate() > 0; 
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
     public boolean delete(String MaSo){
        try{
            String sql = "delete from SoChiTietNhap where MaNV = ? "
                    + "delete from SoChiTietXuat where MaNV = ? "
                    + "delete from DangNhap where MaSo = ?";           

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,MaSo);
            ps.setString(2,MaSo);
            ps.setString(3,MaSo);
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
     public boolean deleteAll(){
        try{
            String sql = "delete from SoChiTietNhap delete from SoChiTietXuat delete from DangNhap";           
           Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);           
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
      public boolean update(TaiKhoan tk){
        try{
            String sql = "update DangNhap set HoTen = ?, ChucVu = ?, TenDangNhap = ?,MatKhau = ?, Gmail = ?, DiaChi = ? "
                       + "where MaSo = ? ";           

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
         
            ps.setString(1,tk.getHoTen());
            ps.setString(2, tk.getChucVu());
            ps.setString(3, tk.getTenDangNhap());
            ps.setString(4, tk.getMatKhau());
            ps.setString(5, tk.getGmail());
            ps.setString(6, tk.getDiaChi());
            ps.setString(7, tk.getMaSo());
            
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }   
}
