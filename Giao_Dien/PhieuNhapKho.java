/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Giao_Dien;

import Entity.PhieuNhap;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ASUS
 */
public class PhieuNhapKho extends javax.swing.JPanel {

    private ArrayList<PhieuNhap> list;
    Vector vctHeader = new Vector(); // vector chứa header 
    Vector vctData = new Vector();// vector chứa dữ liệu trong bảng
    DefaultTableModel model;

    /**
     * Creates new form PhieuNhapKho
     */
    public PhieuNhapKho() {
        initComponents();
        list = new ArrayList<>();
        model = (DefaultTableModel) Table.getModel();

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
        } else {
            return true;
        }
    }

    public void taoPhieu(String maPhieu, String maSP, String tg, String maNV, String maNCC, String dvt, int sLuong, float donGia, float thanhTien) {
        try {
            Connection con = Database.getConnection();

            String query = "insert into SoChiTietNhap values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maPhieu);
            ps.setString(2, maSP);
            ps.setString(3, tg);
            ps.setString(4, maNV);
            ps.setString(5, maNCC);
            ps.setString(6, dvt);
            ps.setInt(7, sLuong);
            ps.setFloat(8, donGia);
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // kiểm tra sp có tồn tại trong kho tồn?
    boolean kiemTraTonKho(String maSP) {
        try {
            Connection con = Database.getConnection();

            String sql = "select * from TonKho where MaSP=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    // thêm sản phẩm mới vào kho tồn
    void themVaoKhoTon(String maSP, String tenSP, String dvt, int soLuong, float donGia) {
        try {
            Connection con = Database.getConnection();

            String sql = "insert into TonKho values(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setString(2, tenSP);
            ps.setString(3, dvt);
            ps.setInt(4, soLuong);
            ps.setFloat(5, donGia);
            ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // chỉnh sửa lại số lượng SP trong kho tồn
    void chinhSuaSL(String maSP, int soLuong) {
        try {
            Connection con = Database.getConnection();

            String sql = "update TonKho "
                    + "set SoLuong+=? where MaSP=?";
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
        txtTenSP = new javax.swing.JTextField();
        txtDVT = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtMaSP = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        ReSet = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        txtDonGia = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNCC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        txtTongTien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        NgayLap = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        TongTien = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhieu = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TaoPhieu = new javax.swing.JButton();
        TaoMoi = new javax.swing.JButton();
        btnInPDF = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

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

        ReSet.setText("Reset");
        ReSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReSetActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaSP))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenSP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDVT)
                            .addComponent(txtSoLuong)
                            .addComponent(txtDonGia)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add)
                            .addComponent(Update))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Delete)
                            .addComponent(ReSet))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(ReSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(Delete))
                .addGap(19, 19, 19))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Phiếu Nhập Kho");

        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Mã nhà cung cấp:");

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
        Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 0, 51));
        jLabel14.setText("VND");

        NgayLap.setDateFormatString("yyyy-MM-dd");

        jLabel15.setForeground(new java.awt.Color(0, 0, 51));
        jLabel15.setText("Month,Day,Year:");

        TongTien.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        TongTien.setForeground(new java.awt.Color(255, 51, 51));
        TongTien.setText("Tổng tiền:");
        TongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TongTienActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Mã phiếu:");

        jLabel3.setText("Mã nhân viên:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(TongTien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(36, 36, 36)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMaPhieu, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                        .addGap(308, 308, 308))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(172, 172, 172))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TaoPhieu.setText("Tạo phiếu");
        TaoPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoPhieuActionPerformed(evt);
            }
        });

        TaoMoi.setText("Tạo phiếu mới");
        TaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoMoiActionPerformed(evt);
            }
        });

        btnInPDF.setText("In file PDF");
        btnInPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPDFActionPerformed(evt);
            }
        });

        btnExcel.setText("Nhập SLL");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TaoPhieu)
                    .addComponent(btnExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TaoMoi)
                    .addComponent(btnInPDF))
                .addGap(132, 132, 132))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TaoPhieu)
                    .addComponent(TaoMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcel)
                    .addComponent(btnInPDF))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void ReSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReSetActionPerformed
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtDVT.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");

    }//GEN-LAST:event_ReSetActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        if (checkNull()) {
            PhieuNhap p = new PhieuNhap();
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

    private void TaoPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoPhieuActionPerformed
        if (NgayLap.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn ngày nhập");
        } else if (txtMaPhieu.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã phiếu");
        } else if (txtNCC.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã nhà cung cấp");
        } else if (txtMaNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã nhân viên");
        } else {
            String maPhieu = txtMaPhieu.getText();
            String maSP, tenSP;
            String date = new SimpleDateFormat("yyyy-MM-dd").format(NgayLap.getDate());
            String maNV = txtMaNV.getText();
            String maNCC = txtNCC.getText();
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
                //tạo phiếu
                taoPhieu(maPhieu, maSP, date, maNV, maNCC, dvt, sl, donGia, thanhTien);
                //thêm vào kho tồn
                //nếu sp đã tồn tại trong kho -> chỉnh sửa số lượng sp
                if (kiemTraTonKho(maSP)) {
                    chinhSuaSL(maSP, sl);
                } //nếu sp chưa có -> thêm mới sp
                else {
                    themVaoKhoTon(maSP, tenSP, dvt, sl, donGia);
                }
            }
            JOptionPane.showMessageDialog(this, "Nhập kho thành công!");
        }
    }//GEN-LAST:event_TaoPhieuActionPerformed

// hiển thị thông tin về 1 dòng trong table
    private void TableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKeyReleased

    }//GEN-LAST:event_TableKeyReleased
    // hiển thị thông tin về 1 dòng trong table
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
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần cập nhật");
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed

    }//GEN-LAST:event_txtTongTienActionPerformed

    private void TaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoMoiActionPerformed
         model.setRowCount(0);
         txtMaPhieu.setText("");
         txtNCC.setText("");
         txtTongTien.setText("");
    }//GEN-LAST:event_TaoMoiActionPerformed

    private void btnInPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInPDFActionPerformed

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

                String maPhieu, maSP, tenSP, date, maNV, maNCC, dvt;
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
                    maNCC = row.getCell(6).getStringCellValue();
                    dvt = row.getCell(7).getStringCellValue();
                    sl = (int) row.getCell(8).getNumericCellValue();
                    donGia = (float) row.getCell(9).getNumericCellValue();
                    thanhTien = (float) row.getCell(10).getNumericCellValue();
                    //tạo phiếu
                    taoPhieu(maPhieu, maSP, date, maNV, maNCC, dvt, sl, donGia, thanhTien);

                    //thêm vào kho tồn
                    //nếu sp đã tồn tại trong kho -> chỉnh sửa số lượng sp
                    if (kiemTraTonKho(maSP)) {
                        chinhSuaSL(maSP, sl);
                    } //nếu sp chưa có -> thêm mới sp
                    else {
                        themVaoKhoTon(maSP, tenSP, dvt, sl, donGia);
                    }
                }
                JOptionPane.showMessageDialog(this, "Nhập thành công!");
                wb.close();
                fi.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void TongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TongTienActionPerformed
        long Sum = 0;
        for(PhieuNhap phieunhap : list){
            Sum += (phieunhap.getDonGia() * phieunhap.getSoLuong());
            txtTongTien.setText(String.valueOf(Sum));
        }
    }//GEN-LAST:event_TongTienActionPerformed
    public void showResult() {
        PhieuNhap phieunhap = list.get(list.size() - 1);
        model.addRow(new Object[]{phieunhap.getMaSP(), phieunhap.getTenSP(), phieunhap.getDVT(), phieunhap.getSoLuong(), phieunhap.getDonGia(), phieunhap.getThanhTien()

        });
    }

    public void showData() {
        model.setRowCount(0);
        for (PhieuNhap phieunhap : list) {
            model.addRow(new Object[]{phieunhap.getMaSP(), phieunhap.getTenSP(), phieunhap.getDVT(), phieunhap.getSoLuong(), phieunhap.getDonGia(), phieunhap.getThanhTien()

            });
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Delete;
    private com.toedter.calendar.JDateChooser NgayLap;
    private javax.swing.JButton ReSet;
    private javax.swing.JTable Table;
    private javax.swing.JButton TaoMoi;
    private javax.swing.JButton TaoPhieu;
    private javax.swing.JButton TongTien;
    private javax.swing.JButton Update;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnInPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNCC;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
