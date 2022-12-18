/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Giao_Dien;

//import Entity.PhieuNhap;
import Entity.PhieuXuat;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.util.test.Test;

/**
 *
 * @author ASUS
 */
public class PhieuXuatKho extends javax.swing.JPanel {

    private ArrayList<PhieuXuat> list;
    Vector vctHeader = new Vector(); // vector chứa header 
    Vector vctData = new Vector();// vector chứa dữ liệu trong bảng
    DefaultTableModel model;

    /**
     * Creates new form PhieuXuatKho
     */
    public PhieuXuatKho() {
        initComponents();
        list = new ArrayList<>();
        model = (DefaultTableModel) Table.getModel();
        showComboMaNV();
    }

    public boolean checkNull() {
        if (txtMaSP.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập mã sản phẩm");
            txtMaSP.requestFocus();
            return false;
        } else if (txtTenSP.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập tên sản phẩm");
            txtTenSP.requestFocus();
            return false;
        } else if (txtDVT.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập đơn vị tính");
            txtDVT.requestFocus();
            return false;
        } else if (txtSoLuong.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập số lượng");
            txtSoLuong.requestFocus();
            return false;
        } else if (txtDonGia.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập đơn giá");
            txtDonGia.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void taoPhieu(String maPhieu, String maSP, String tg, String maNV, String tenNN, String dvt, int sLuong, float donGia, float thanhTien) {
        try {
            Connection con = Database.getConnection();

            String query = "insert into SoChiTietXuat values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maPhieu);
            ps.setString(2, maSP);
            ps.setString(3, tg);
            ps.setString(4, maNV);
            ps.setString(5, tenNN);
            ps.setString(6, dvt);
            ps.setInt(7, sLuong);
            ps.setFloat(8, donGia);
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // kiểm tra sluong sp trong kho tồn
    int kiemTraSLSP(String maSP, int soLuong) {
        try {
            Connection con = Database.getConnection();

            String sql = "select SoLuong from TonKho where MaSP=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("SoLuong") >= soLuong) {
                    return 1;
                } else {
                    return -1;
                } 
//                else {
//                    return 0;
//                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return -2;
    }

    // xóa sản phẩm khỏi kho tồn
    void xoaKhoiKhoTon(String maSP) {
        try {
            Connection con = Database.getConnection();

            String sql = "delete from TonKho where MaSP=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // chỉnh sửa lại số lượng SP trong kho tồn(sl ton -= sl xuat)
    void chinhSuaSL(String maSP, int soLuong) {
        try {
            Connection con = Database.getConnection();

            String sql = "update TonKho "
                    + "set SoLuong-=? where MaSP=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setString(2, maSP);
            ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtDVT = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        txtTongTien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        dcNgayLap = new com.toedter.calendar.JDateChooser();
        TongTien = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhieu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenNguoiNhan = new javax.swing.JTextField();
        cbxMaNhanVien = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnExcel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        PhieuMoi = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel16.setText("Mã sản phẩm:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel17.setText("Tên sản phẩm:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel18.setText("Đơn vị tính:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel19.setText("Số lượng:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel20.setText("Đơn giá:");

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(Add, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Delete, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Update)
                                    .addComponent(Reset))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenSP)
                                    .addComponent(txtDVT)
                                    .addComponent(txtSoLuong)
                                    .addComponent(txtDonGia))))))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Reset))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete)
                    .addComponent(Update))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Phiếu Xuất Kho");

        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Mã nhân viên:");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn vị tính", "Số lượng ", "Đơn giá", "Thành tiền"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jLabel14.setForeground(new java.awt.Color(0, 0, 51));
        jLabel14.setText("VND");

        jLabel22.setForeground(new java.awt.Color(0, 0, 51));
        jLabel22.setText("Month,Day,Year:");

        TongTien.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        TongTien.setForeground(new java.awt.Color(255, 0, 0));
        TongTien.setText("Tổng tiền:");
        TongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TongTienActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Mã phiếu:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("Tên người nhận:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TongTien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(66, 66, 66))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 316, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(283, 283, 283))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel8))
                                    .addGap(31, 31, 31)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dcNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbxMaNhanVien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                                    .addContainerGap()))))
                    .addComponent(jScrollPane1)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TongTien)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(101, 101, 101))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnExcel.setText("Xuất SLL");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        jButton1.setText("Tạo phiếu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        PhieuMoi.setText("Tạo phiếu mới");
        PhieuMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhieuMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(PhieuMoi)
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(PhieuMoi))
                .addGap(29, 29, 29)
                .addComponent(btnExcel)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtDVT.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");
    }//GEN-LAST:event_ResetActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        if (checkNull()) {
            PhieuXuat p = new PhieuXuat();
            p.setMaSP(txtMaSP.getText());
            p.setTenSP(txtTenSP.getText());
            p.setDVT(txtDVT.getText());
            p.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            p.setDonGia(Long.parseLong(txtDonGia.getText()));
            p.setThanhTien(p.getDonGia() * p.getSoLuong());
            list.add(p);
            showResult();
        }
    }//GEN-LAST:event_AddActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int removeIndex = Table.getSelectedRow();// lấy chỉ số dòng được chọn
        if (removeIndex == -1) {
            JOptionPane.showConfirmDialog(this, "Hãy chọn dòng cần xóa");
        } else if (list.size() == 0) {
            JOptionPane.showConfirmDialog(this, "Không có thông tin để xóa");
        } else {
            list.remove(removeIndex);
            showData();
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        DefaultTableModel tbmodel = (DefaultTableModel) Table.getModel();
        if (Table.getSelectedRowCount() == 1) {
            String MaSP = txtMaSP.getText();
            String TenSP = txtTenSP.getText();
            String DVT = txtDVT.getText();
            String SoLuong = txtSoLuong.getText();
            String DonGia = txtDonGia.getText();
            long ThanhTien = Long.parseLong(txtSoLuong.getText()) * Integer.parseInt(txtDonGia.getText());

            tbmodel.setValueAt(MaSP, Table.getSelectedRow(), 0);
            tbmodel.setValueAt(TenSP, Table.getSelectedRow(), 1);
            tbmodel.setValueAt(DVT, Table.getSelectedRow(), 2);
            tbmodel.setValueAt(SoLuong, Table.getSelectedRow(), 3);
            tbmodel.setValueAt(DonGia, Table.getSelectedRow(), 4);
            tbmodel.setValueAt(ThanhTien, Table.getSelectedRow(), 5);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } else {
            if (Table.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Bảng rỗng");
            } else {
                JOptionPane.showMessageDialog(this, "Vui longf chọn dòng cần cập nhật");
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int selectedRow = Table.getSelectedRow();
        if (selectedRow >= 0) {
            txtMaSP.setText(Table.getValueAt(selectedRow, 0).toString());
            txtTenSP.setText(Table.getValueAt(selectedRow, 1).toString());
            txtDVT.setText(Table.getValueAt(selectedRow, 2).toString());
            txtSoLuong.setText(Table.getValueAt(selectedRow, 3).toString());
            txtDonGia.setText(Table.getValueAt(selectedRow, 4).toString());
//            txtThanhTien.setText(Table.getValueAt(selectedRow,5).toString());
        }
    }//GEN-LAST:event_TableMouseClicked

    private void TongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TongTienActionPerformed
        long Sum = 0;
        for (PhieuXuat phieuxuat : list) {
            Sum += (phieuxuat.getDonGia() * phieuxuat.getSoLuong());
            txtTongTien.setText(String.valueOf(Sum));
        }
    }//GEN-LAST:event_TongTienActionPerformed

    private void PhieuMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhieuMoiActionPerformed
        model.setRowCount(0);
        txtMaPhieu.setText("");
        txtTenNguoiNhan.setText("");
        txtTongTien.setText("");
    }//GEN-LAST:event_PhieuMoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (dcNgayLap.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn ngày nhập");
        } else if (txtMaPhieu.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã phiếu");
        } else if (txtTenNguoiNhan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên người nhận");
        } else if (cbxMaNhanVien.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã nhân viên");
        } else {
            String maPhieu = txtMaPhieu.getText();
            String maSP, tenSP;
            String date = new SimpleDateFormat("yyyy-MM-dd").format(dcNgayLap.getDate());
            String maNV = cbxMaNhanVien.getSelectedItem().toString();
            String tenNN = txtTenNguoiNhan.getText();
            String dvt;
            int sl = 0;
            float donGia = 0;
            float thanhTien = 0;
            if (Table.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Chưa thêm sản phẩm nào!");
                return;
            }
            for (int i = 0; i < Table.getRowCount(); i++) {
                maSP = Table.getValueAt(i, 0).toString();
                tenSP = Table.getValueAt(i, 1).toString();
                dvt = Table.getValueAt(i, 2).toString();
                sl = Integer.parseInt(Table.getValueAt(i, 3).toString());
                donGia = Float.parseFloat(Table.getValueAt(i, 4).toString());
                thanhTien = sl * donGia;

                //chỉnh sửa sl tồn kho
                switch (kiemTraSLSP(maSP, sl)) {
                    case 1:
                        chinhSuaSL(maSP, sl);//nếu sl sp trong kho > sl sp xuất -> chỉnh sửa số lượng sp(sl ton -= sl xuat)
                        break;
                    case -1: //nếu sl sp trong kho < sl sp xuất -> không thể xuất
                        JOptionPane.showMessageDialog(this, "Sản phẩm " + maSP + " không đủ số lượng để xuất nên được bỏ qua");
                        continue;
//                    case 0:
//                        xoaKhoiKhoTon(maSP);//sl tồn = sl xuất -> xóa sp khỏi kho tồn
//                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Sản phẩm " + maSP + " không tồn tại nên được bỏ qua");
                        continue;
                }

                //tạo phiếu
                taoPhieu(maPhieu, maSP, date, maNV, tenNN, dvt, sl, donGia, thanhTien);
            }

            JOptionPane.showMessageDialog(this, "Xuất kho thành công!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fc = new JFileChooser();
            fc.setPreferredSize(new Dimension(800, 550));
            FileFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
            fc.addChoosableFileFilter(filter);
            fc.setMultiSelectionEnabled(false);
            int t = fc.showDialog(this, "Open");
            if (t == JFileChooser.APPROVE_OPTION) {
                FileInputStream fi = new FileInputStream(fc.getSelectedFile());
                // Get workbook
                XSSFWorkbook wb = new XSSFWorkbook(fi);
                // Get sheet
                XSSFSheet sheet = wb.getSheetAt(0);

                String maPhieu, maSP, tenSP, date, maNV, tenNN, dvt;
                int sl;
                float donGia, thanhTien;

                for (int i = 5; i < sheet.getLastRowNum() + 1; i++) {
                    Row row = sheet.getRow(i);

                    DataFormatter dataFormatter = new DataFormatter();
                    maPhieu = row.getCell(1).getStringCellValue();
                    maSP = row.getCell(2).getStringCellValue();
                    tenSP = row.getCell(3).getStringCellValue();
                    date = dataFormatter.formatCellValue(row.getCell(4));;
                    maNV = row.getCell(5).getStringCellValue();
                    tenNN = row.getCell(6).getStringCellValue();
                    dvt = row.getCell(7).getStringCellValue();
                    sl = (int) row.getCell(8).getNumericCellValue();
                    donGia = (float) row.getCell(9).getNumericCellValue();
                    thanhTien = (float) row.getCell(10).getNumericCellValue();

                    //chỉnh sửa sl tồn kho
                    switch (kiemTraSLSP(maSP, sl)) {
                        case 1:
                            chinhSuaSL(maSP, sl);//nếu sl sp trong kho > sl sp xuất -> chỉnh sửa số lượng sp(sl ton -= sl xuat)
                            break;
                        case -1: //nếu sl sp trong kho < sl sp xuất -> không thể xuất
                            JOptionPane.showMessageDialog(this, "Sản phẩm " + maSP + " không đủ số lượng để xuất nên được bỏ qua");
                            continue;
//                        case 0:
//                            xoaKhoiKhoTon(maSP);//sl tồn = sl xuất -> xóa sp khỏi kho tồn
//                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Sản phẩm " + maSP + " không tồn tại nên được bỏ qua");
                            continue;
                    }

                    //tạo phiếu
                    taoPhieu(maPhieu, maSP, date, maNV, tenNN, dvt, sl, donGia, thanhTien);
                }
                JOptionPane.showMessageDialog(this, "Xuất kho thành công!");
                wb.close();
                fi.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcelActionPerformed
    public void showResult() {
        PhieuXuat phieuxuat = list.get(list.size() - 1);
        model.addRow(new Object[]{phieuxuat.getMaSP(), phieuxuat.getTenSP(), phieuxuat.getDVT(), phieuxuat.getSoLuong(), phieuxuat.getDonGia(), phieuxuat.getThanhTien()

        });
    }

    public void showData() {
        model.setRowCount(0);
        for (PhieuXuat phieuxuat : list) {
            model.addRow(new Object[]{phieuxuat.getMaSP(), phieuxuat.getTenSP(), phieuxuat.getDVT(), phieuxuat.getSoLuong(), phieuxuat.getDonGia(), phieuxuat.getThanhTien()
            });
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Delete;
    private javax.swing.JButton PhieuMoi;
    private javax.swing.JButton Reset;
    private javax.swing.JTable Table;
    private javax.swing.JButton TongTien;
    private javax.swing.JButton Update;
    private javax.swing.JButton btnExcel;
    private javax.swing.JComboBox<String> cbxMaNhanVien;
    private com.toedter.calendar.JDateChooser dcNgayLap;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenNguoiNhan;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void showComboMaNV() {
        try {
            String query = "select MaSo "
                    + "from DangNhap\n"
                    + "where ChucVu = 'nhanvien'";
            Connection conn = new Database().getConnection();//kết nối sql server
            PreparedStatement ps = conn.prepareStatement(query); // nems câu lệnh query từ netbean sang sql server
            ResultSet rs = ps.executeQuery();// execute and nhận kết quả trả về
            cbxMaNhanVien.removeAllItems();
            while (rs.next()) {
                String Value = rs.getString("MaSo");
                cbxMaNhanVien.addItem(Value);
            }
            conn.close();
            rs.close();
            ps.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
