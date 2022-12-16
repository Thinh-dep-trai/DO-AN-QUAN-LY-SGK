/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Giao_Dien;

import DAO.Nha_CungCapDAO;
import DAO.Nhan_VienDAO;
import Entity.NhaCungCap;
import Entity.TaiKhoan;
import Entity.Ton_Kho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class QuanLiNCC extends javax.swing.JPanel {
    DefaultTableModel model;
    private ArrayList<NhaCungCap> listNCC;
    public QuanLiNCC() {
        initComponents();
        listNCC= new ArrayList<>();
        model = (DefaultTableModel) Table.getModel();
        loadAll("");
       
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtMaNCC = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Find = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxFind = new javax.swing.JComboBox<>();
        DeleteAll = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Danh sách nhà cung cấp");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số thứ tự", "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Mã nhà cung cấp:");

        jLabel4.setText("Tên nhà cung cấp:");

        jLabel6.setText("Địa chỉ:");

        jLabel7.setText("Số điện thoại:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Find.setText("Find:");
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });

        jLabel10.setText("Chọn thông tin:");

        cbxFind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nhà cung cấp ", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", " " }));
        cbxFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFindActionPerformed(evt);
            }
        });

        DeleteAll.setText("DeleteAll");
        DeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFind, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Find))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Add)
                                    .addComponent(Reset))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Update)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(Delete)
                                        .addGap(38, 38, 38)
                                        .addComponent(DeleteAll)))))))
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Find)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Update))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reset)
                    .addComponent(Delete)
                    .addComponent(DeleteAll))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(378, 378, 378))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Refresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(Refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   int i ;
    private void loadAll(String dk){
        i = 1;
        try{
            String sql = "select * "
                       + " from NhaCungCap "
                       + dk;
                       
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String [] row;
                row = new String []{
                     String.valueOf(i++),
                     rs.getString("MaNCC"),
                     rs.getString("TenNCC"),
                     rs.getString("DiaChi"),
                     rs.getString("SDT")
                };
                model.addRow(row);
            }
            rs.close();
            ps.close();
            conn.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
     public boolean checkNull() {
        if (txtMaNCC.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập mã nhà cung cấp ");
            txtMaNCC.requestFocus();
            return false;
        } else if (txtTenNCC.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập tên nhà cung cấp");
            txtTenNCC.requestFocus();
            return false;
        } else if (txtDiaChi.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập địa chỉ");
            txtDiaChi.requestFocus();
            return false;
        } else if (txtSDT.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Chưa nhập số điện thoại");
            txtSDT.requestFocus();
            return false;
        } 
        else {
            return true;
        }
    }
        
    public void showResult() {
            for(NhaCungCap ncc : listNCC){
                 model.addRow(new Object[]{i++, ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(), ncc.getSDT() });
            }
           
    }
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
       if (checkNull()) {
          try{
            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNCC(txtMaNCC.getText());
            ncc.setTenNCC(txtTenNCC.getText());
            ncc.setDiaChi(txtDiaChi.getText());
            ncc.setSDT(txtSDT.getText());
            Nha_CungCapDAO  dao = new Nha_CungCapDAO();
            dao.insert(ncc);
            listNCC.add(ncc);
            showResult();
            listNCC.remove(ncc);
          }
          catch(Exception ex){
              JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
              ex.printStackTrace();
          }
        }  
    }//GEN-LAST:event_AddActionPerformed

    private void cbxFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFindActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        
    }//GEN-LAST:event_ResetActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int selectedRow = Table.getSelectedRow();
        if (selectedRow >= 0) {
            txtMaNCC.setText(Table.getValueAt(selectedRow, 1).toString());
            txtTenNCC.setText(Table.getValueAt(selectedRow, 2).toString());
            txtDiaChi.setText(Table.getValueAt(selectedRow, 3).toString());
            txtSDT.setText(Table.getValueAt(selectedRow, 4).toString());
           
        }
    }//GEN-LAST:event_TableMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int removeIndex = Table.getSelectedRow();// lấy chỉ số dòng được chọn
        if (removeIndex == -1) {
            JOptionPane.showConfirmDialog(this, "Hãy chọn dòng cần xóa");
        } 
        else {
            try{
                Nha_CungCapDAO dao = new Nha_CungCapDAO();
                dao.delete(txtMaNCC.getText());
                model.setRowCount(0);
                loadAll("");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void DeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAllActionPerformed
        Nha_CungCapDAO dao = new Nha_CungCapDAO();
        dao.deleteAll();

    }//GEN-LAST:event_DeleteAllActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        model.setNumRows(0);
        loadAll("");
    }//GEN-LAST:event_RefreshActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        int removeIndex = Table.getSelectedRow();// lấy chỉ số dòng được chọn
        if (removeIndex == -1) {
            JOptionPane.showConfirmDialog(this, "Hãy chọn dòng cần cập nhật");
        } 
        else {
            try{
                Nha_CungCapDAO dao = new Nha_CungCapDAO();
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(txtMaNCC.getText());
                ncc.setTenNCC(txtTenNCC.getText());
                ncc.setDiaChi(txtDiaChi.getText());
                ncc.setSDT(txtSDT.getText());             
                dao.update(ncc);
                model.setRowCount(0);
                loadAll("");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindActionPerformed
        String dk = null;
        if (cbxFind.getSelectedItem().equals("Số điện thoại")) {
            if (txtFind.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập số điện thoại");
            } 
            else {
                model.setNumRows(0);
                dk = " where SDT = N'" + txtFind.getText() + "'";
            }
        } 
        else if(cbxFind.getSelectedItem().equals("Tên nhà cung cấp")){
            if (txtFind.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập tên nhà cung cấp");
            }
            else {
                model.setNumRows(0);
                dk = "where TenNCC = N'" + txtFind.getText() + "'";
            }
        }
        else if(cbxFind.getSelectedItem().equals("Địa chỉ")){
            if (txtFind.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ");
            }
            else {
                model.setNumRows(0);
                dk = "where DiaChi = N'" + txtFind.getText() + "'";
            }
        }
        else {
            if (txtFind.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập mã nhà cung cấp");
            }
            else {
                model.setNumRows(0);
                dk = "where MaNCC = N'" + txtFind.getText() + "'";
            }
        }
        loadAll(dk);
    }//GEN-LAST:event_FindActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Delete;
    private javax.swing.JButton DeleteAll;
    private javax.swing.JButton Find;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Reset;
    private javax.swing.JTable Table;
    private javax.swing.JButton Update;
    private javax.swing.JComboBox<String> cbxFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}