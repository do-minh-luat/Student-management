package com.mycompany.view;

import app.bolivia.swing.JCTextField;
import com.mycompany.duan1.X.Auth;
import com.mycompany.duan1.X.MsgBox;
import com.mycompany.duan1.X.XDate;
import com.mycompany.duan1.dao.ChuyenNganhDao;
import com.mycompany.duan1.dao.LichHocDao;
import com.mycompany.duan1.dao.LopHocDAO;
import com.mycompany.duan1.dao.MonHocDao;
import com.mycompany.duan1.dao.NhanVienDao;
import com.mycompany.duan1.dao.SinhVienDao;
import com.mycompany.duan1.model.ChuyenNganh;
import com.mycompany.duan1.model.LichHoc;
import com.mycompany.duan1.model.LopHoc;
import com.mycompany.duan1.model.MonHoc;
import com.mycompany.duan1.model.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor;

/**
 *
 * @author ADMIN
 */
public class LichHocJPanel extends javax.swing.JPanel {
    SinhVienDao svDao = new SinhVienDao();
    /**
     * Creates new form LichHocJPanel
     */
    public List<LichHoc> lichhoc;
    private DefaultTableModel tblModel;

    public LichHocJPanel() {
        initComponents();
        init();
    }

    ChuyenNganhDao cndao = new ChuyenNganhDao();
    MonHocDao mhdao = new MonHocDao();
    LopHocDAO lopHocDAO = new LopHocDAO();
    LichHocDao lichhdao = new LichHocDao();
    NhanVienDao nhanVienDao = new NhanVienDao();
    int row = -1;

    void filltable() {
        DefaultTableModel model = (DefaultTableModel) tblLichHoc.getModel();
        model.setRowCount(0);
        try {
            List<LichHoc> list = lichhdao.selectAll();
            for (LichHoc lh : list) {
                String TenMH = null;
                String TenNV = null;
                if(mhdao.selectById(lh.getMaMonHoc()).getTenMonHoc() != null && nhanVienDao.selectById(lh.getMaNhanVien()).getTenNhanVien() != null){
                    TenMH = mhdao.selectById(lh.getMaMonHoc()).getTenMonHoc();
                    TenNV = nhanVienDao.selectById(lh.getMaNhanVien()).getTenNhanVien();
                }else{
                    TenMH = null;
                    TenNV = null;
                }
                Object[] row = {
                    lh.getMaLichHoc(),
                    lh.getNgay(),
                    lh.getThoiGian(),
                    lh.getMaMonHoc(), 
                    TenMH,
                    lh.getMaLopHoc(),
                    lh.getMaChuyenNganh(),
                    lh.getMaNhanVien(),
                    TenNV,
                    lh.getMaPhongHoc(),
                    
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    void filltable2(String MaLH) {
        DefaultTableModel model = (DefaultTableModel) tblLichHoc.getModel();
        model.setRowCount(0);
        try {
            List<LichHoc> list = lichhdao.selectByMaLopHoc(MaLH);
            for (LichHoc lh : list) {
                String TenMH = null;
                String TenNV = null;
                if(mhdao.selectById(lh.getMaMonHoc()).getTenMonHoc() != null && nhanVienDao.selectById(lh.getMaNhanVien()).getTenNhanVien() != null){
                    TenMH = mhdao.selectById(lh.getMaMonHoc()).getTenMonHoc();
                    TenNV = nhanVienDao.selectById(lh.getMaNhanVien()).getTenNhanVien();
                }else{
                    TenMH = null;
                    TenNV = null;
                }
                Object[] row = {
                    lh.getMaLichHoc(),
                    lh.getNgay(),
                    lh.getThoiGian(),
                    lh.getMaMonHoc(), 
                    TenMH,
                    lh.getMaLopHoc(),
                    lh.getMaChuyenNganh(),
                    lh.getMaNhanVien(),
                    TenNV,
                    lh.getMaPhongHoc(),
                    
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichHoc = new rojeru_san.complementos.RSTableMetro();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Tim = new javax.swing.JButton();
        jctFind = new app.bolivia.swing.JCTextField();
        jPanel4 = new javax.swing.JPanel();
        txt_Thoigian = new textfield.ThoiGian();
        txt_Maphonghoc = new textfield.MaPhongHoc();
        btn_Xoa = new rojeru_san.complementos.RSButtonHover();
        btn_Moi = new rojeru_san.complementos.RSButtonHover();
        btn_Sua = new rojeru_san.complementos.RSButtonHover();
        btn_Luu = new rojeru_san.complementos.RSButtonHover();
        cbbmachuyennganh = new combobox.CBBMaChuyenNganh();
        cbb_Mamonhoc = new combobox.MaMonHoc();
        cbb_Malop = new combobox.CBBMaLopHoc();
        cbb_Manhanvien = new combobox.MaNhanVien();
        txt_Ngay = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_Malich = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabs.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Lịch Học"));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblLichHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Ngày", "Thời Gian", "Mã MH", "Tên MH", "Mã LH", "Mã CN", "Mã NV", "Tên NV", "Phòng Học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLichHoc.setColorBackgoundHead(new java.awt.Color(204, 0, 51));
        tblLichHoc.setColorBordeFilas(new java.awt.Color(153, 153, 153));
        tblLichHoc.setColorBordeHead(new java.awt.Color(153, 153, 153));
        tblLichHoc.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblLichHoc.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblLichHoc.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblLichHoc.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblLichHoc.setRowHeight(40);
        tblLichHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblLichHocMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblLichHoc);

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Lớp Học");

        btn_Tim.setText("Tìm Kiếm");
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        jctFind.setBackground(new java.awt.Color(0, 51, 51));
        jctFind.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jctFind.setForeground(new java.awt.Color(255, 255, 255));
        jctFind.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jctFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jctFindKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jctFind, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jctFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Tim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        tabs.addTab("XEM LỊCH HỌC", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(txt_Thoigian, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 105, 400, 40));
        jPanel4.add(txt_Maphonghoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 3, 400, 40));

        btn_Xoa.setText("Xoá");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 492, 143, -1));

        btn_Moi.setText("Mới");
        btn_Moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Moi, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 492, 143, -1));

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 492, 143, -1));

        btn_Luu.setText("Lưu");
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Luu, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 492, 143, -1));

        cbbmachuyennganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbmachuyennganhActionPerformed(evt);
            }
        });
        jPanel4.add(cbbmachuyennganh, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 3, 400, 40));
        jPanel4.add(cbb_Mamonhoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 207, 400, 40));
        jPanel4.add(cbb_Malop, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 105, 400, 40));
        jPanel4.add(cbb_Manhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 309, 400, 40));

        txt_Ngay.setDateFormatString("dd-MM-yyyy");
        txt_Ngay.setMaxSelectableDate(new java.util.Date(253370743298000L));
        jPanel4.add(txt_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 218, 400, 29));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ngày");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Mã lịch học");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, -1, -1));

        lbl_Malich.setBackground(new java.awt.Color(245, 245, 245));
        jPanel4.add(lbl_Malich, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, 400, 30));

        tabs.addTab("THÊM LỊCH HỌC", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        loadByMa();
    }//GEN-LAST:event_btn_TimActionPerformed

    private void tblLichHocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichHocMousePressed
        if (evt.getClickCount() == 2) {
            if(!Auth.isSinhVien()){
                this.row = tblLichHoc.getSelectedRow();
                edit();
            }
        }
    }//GEN-LAST:event_tblLichHocMousePressed

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        insert();
    }//GEN-LAST:event_btn_LuuActionPerformed

    private void cbbmachuyennganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbmachuyennganhActionPerformed
        fillComboBoxLopHoc();
        fillComboBoxMonHoc();
        fillComboBoxNhanVien();
    }//GEN-LAST:event_cbbmachuyennganhActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        update();
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        delete();
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_MoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_MoiActionPerformed

    private void jctFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jctFindKeyReleased
        if(!jctFind.getText().equals("")){
            loadByMa();
        }else{
            if(Auth.isSinhVien()){
                KT();
            }
        }
    }//GEN-LAST:event_jctFindKeyReleased
    LichHoc getForm() {
        LichHoc nv = new LichHoc();
        nv.setThoiGian(txt_Thoigian.getText());
        nv.setNgay(txt_Ngay.getDate());
        nv.setMaMonHoc(String.valueOf(cbb_Mamonhoc.getSelectedItem()));
        nv.setMaLopHoc(String.valueOf(cbb_Malop.getSelectedItem()));
        nv.setMaChuyenNganh(String.valueOf(cbbmachuyennganh.getSelectedItem()));
        nv.setMaNhanVien(cbb_Manhanvien.getSelectedItem().toString());
        nv.setMaPhongHoc(txt_Maphonghoc.getText());
//        nv.setMaLichHoc(Integer.parseInt(lbl_Malich.getText()));
        return nv;
    }

    void setForm(LichHoc lh) {
        if (row == -1) {
            if(lh.getMaChuyenNganh() == null){
                cbbmachuyennganh.setSelectedIndex(0);
                txt_Ngay.setDate(null);
                txt_Maphonghoc.setText("");
                txt_Thoigian.setText("");
                lbl_Malich.setText("");
            }
        } else {
            cbbmachuyennganh.setSelectedItem(lh.getMaChuyenNganh());
            cbb_Mamonhoc.setSelectedItem(lh.getMaMonHoc());
            cbb_Malop.setSelectedItem(lh.getMaLopHoc());
            cbb_Manhanvien.setSelectedItem(lh.getMaNhanVien());
            txt_Maphonghoc.setText(lh.getMaPhongHoc());
            txt_Thoigian.setText(lh.getThoiGian());
            txt_Ngay.setDate(lh.getNgay());
            lbl_Malich.setText(String.valueOf(lh.getMaLichHoc()));
        }
    }

    void edit() {
        try {
            Integer MaLH = (Integer) tblLichHoc.getValueAt(row, 0);
            LichHoc lh = lichhdao.selectByMaLH(MaLH);
            if (lh != null) {
                setForm(lh);
                tabs.setSelectedIndex(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    public void init() {
        if(Auth.isSinhVien()){
            this.tabs.setEnabledAt(1, false);
            KT();
        }else{
            filltable();
            fillComboBoxChuyenNganh();
        }
        
    }

    void KT() {
        if(Auth.isSinhVien()){
            String MaLH = svDao.selectByMaTK(Auth.user.getMaTK()).getMaLopHoc();
            if(MaLH != null){
                filltable2(MaLH);
            }
        }
    }
    
    void fillComboBoxLopHoc() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbb_Malop.getModel();
            model.removeAllElements();
            String chuyenNganh = cbbmachuyennganh.getSelectedItem().toString();
            if (chuyenNganh != null) {
                List<LopHoc> list = lopHocDAO.selectByChuyenNganh(chuyenNganh);
                for (LopHoc lh : list) {
                    model.addElement(lh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi Truy Vấn");
        }

    }

    void fillComboBoxChuyenNganh() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbmachuyennganh.getModel();
        model.removeAllElements();
        try {
            List<ChuyenNganh> list = cndao.selectAll();
            for (ChuyenNganh cd : list) {
                model.addElement(cd.getMaChuyenNganh());
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi Truy Vấn");
        }

    }

    void fillComboBoxMonHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbb_Mamonhoc.getModel();
        model.removeAllElements();
        try {
            String chuyenNganh = cbbmachuyennganh.getSelectedItem().toString();
            if (chuyenNganh != null) {
                List<MonHoc> list = mhdao.selectByChuyenNganh(chuyenNganh);
                for (MonHoc lh : list) {
                    model.addElement(lh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi Truy Vấn");
        }

    }

    void fillComboBoxNhanVien() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbb_Manhanvien.getModel();
            model.removeAllElements();
            try {
                String chuyenNganh = cbbmachuyennganh.getSelectedItem().toString();
                List<NhanVien> list = nhanVienDao.selectByMaCN(chuyenNganh);
                for (NhanVien cd : list) {
                    model.addElement(cd.getMaNhanVien());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi Truy Vấn");
        }

    }

    void loadByMa() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblLichHoc.getModel();
            model.setRowCount(0);
            String MaLopHoc = jctFind.getText();
            List<LichHoc> list = lichhdao.selectByMaLopHoc(MaLopHoc);
            for (LichHoc nv : list) {
                String TenMH = mhdao.selectById(nv.getMaLopHoc()).getTenMonHoc();
                Object[] row = {
                    nv.getMaLichHoc(),
                    nv.getNgay(),
                    nv.getThoiGian(),
                    nv.getMaMonHoc(),
                    nv.getMaLopHoc(),
                    nv.getMaChuyenNganh(),
                    nv.getMaNhanVien(),
                    nv.getMaPhongHoc(),
                    TenMH};
                model.addRow(row);

            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        LichHoc lh = getForm();
        try {
            lichhdao.insert(lh);
            filltable();
            clearForm();
            tabs.setSelectedIndex(0);
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm thất bại");
        }
    }
    
    void update() {
        LichHoc lh = getForm();
        try {
            lichhdao.update(lh);
            filltable();
            clearForm();
            tabs.setSelectedIndex(0);
            MsgBox.alert(this, "Cập nhâp thành công");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Cập nhật thất bại");
        }
    }
    void delete() {
        Integer MaLH = (Integer) tblLichHoc.getValueAt(row, 0);
        try {
            lichhdao.delete(MaLH.toString());
            filltable();
            clearForm();
            tabs.setSelectedIndex(0);
            MsgBox.alert(this, "Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Xoá thất bại");
        }
    }
    
    void clearForm() {
        try {
            this.row = -1;
            LichHoc lh = new LichHoc();
            this.setForm(lh);
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_Luu;
    private rojeru_san.complementos.RSButtonHover btn_Moi;
    private rojeru_san.complementos.RSButtonHover btn_Sua;
    private javax.swing.JButton btn_Tim;
    private rojeru_san.complementos.RSButtonHover btn_Xoa;
    private combobox.CBBMaLopHoc cbb_Malop;
    private combobox.MaMonHoc cbb_Mamonhoc;
    private combobox.MaNhanVien cbb_Manhanvien;
    private combobox.CBBMaChuyenNganh cbbmachuyennganh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private app.bolivia.swing.JCTextField jctFind;
    private javax.swing.JLabel lbl_Malich;
    private javax.swing.JTabbedPane tabs;
    private rojeru_san.complementos.RSTableMetro tblLichHoc;
    private textfield.MaPhongHoc txt_Maphonghoc;
    private com.toedter.calendar.JDateChooser txt_Ngay;
    private textfield.ThoiGian txt_Thoigian;
    // End of variables declaration//GEN-END:variables
}
