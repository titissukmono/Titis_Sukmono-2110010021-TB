package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import gui.koneksi;
import static gui.Menu.maximixed;


public class Transaksi extends javax.swing.JDialog {
    
    public final Connection conn = new koneksi().connect();

    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2;
    
   
    static boolean maximixed = true;
    int xMouse;
    int yMouse;
    
    private void aktif(){
        tfidtransaksi.setEnabled(true);
        tftotal.setEnabled(true);
        tftelepon.setEnabled(true);
        tfkembali.setEnabled(true);
        tfbayar.setEnabled(true);
        tfpcs.setEnabled(true);
        tfnamapmbeli.setEnabled(true);
        
        
    }
    
    protected void kosong(){
        tfidtransaksi.setText(null);
        tftotal.setText(null);
        tfnamapmbeli.setText(null);
        tfbayar.setText(null);
        tfkembali.setText(null);
        tfpcs.setText(null);
        tftelepon.setText(null);
        tfhargabuku.setText(null);
    }
    
    public void noTable(){
        int Baris = tabmode.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            tabmode.setValueAt(nomor +".",a,0);
        }
    }
    
    
    
    
    public void dataTable(){
        
        String sql = "select * from transaksi order by id_transaksi asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String kd_buku = hasil.getString("kd_buku");
                String kd_jns = hasil.getString("kd_jns");
                String jdl_buku = hasil.getString("jdl_buku");
                String pengarang = hasil.getString("pengarang");
                String pnerbit = hasil.getString("pnerbit");
                String jumlah = hasil.getString("jumlah");
                String harga = hasil.getString("harga");
                String[] data = {"",kd_buku,kd_jns,jdl_buku,pengarang,pnerbit,jumlah,harga};
                tabmode.addRow(data);
                noTable();
            }
        } catch (Exception e){
        }
    }
    
    public void dataTable2(){
        Object[] Baris2 = {"Kode Buku","Judul Buku","Harga"};
        tabmode2 = new DefaultTableModel(null, Baris2);
        tabelbuku.setModel(tabmode2);
        String sql = "select * from buku order by kd_buku asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                 String kd_buku = hasil.getString("kd_buku");
                 String jdl_buku = hasil.getString("jdl_buku");
                String harga = hasil.getString("harga");
                String[] data = {kd_buku,jdl_buku,harga};
                tabmode2.addRow(data);
            }
        } catch (Exception e){
        }
    }
    
    

    
    public void lebarKolom2(){
        TableColumn column2;
        tabelbuku.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column2 = tabelbuku.getColumnModel().getColumn(0);
        column2.setPreferredWidth(100);
        column2 = tabelbuku.getColumnModel().getColumn(1);
        column2.setPreferredWidth(200);
        column2 = tabelbuku.getColumnModel().getColumn(2);
        column2.setPreferredWidth(100);
    }
    
    public void pencarian(String sql){
        
        
        
    }
    
    public void pencarian2(String sql){
         Object[] Baris2 = {"Kode Buku","Judul Buku","Harga"};
        tabmode2 = new DefaultTableModel(null, Baris2);
        tabelbuku.setModel(tabmode2);
        int brs = tabelbuku.getRowCount();
        for (int i = 0; 1 < brs; i++){
            tabmode2.removeRow(1);
        }
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                 String kd_buku = hasil.getString("kd_buku");
                 String jdl_buku = hasil.getString("jdl_buku");
                String harga = hasil.getString("harga");
                String[] data = {kd_buku,jdl_buku,harga};
                tabmode2.addRow(data);
            }
        } catch(Exception e){
            
        }
    }

    /**
     * Creates new form dataBarang
     */
    public Transaksi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        aktif();
        dataTable();

        dataTable2();
        lebarKolom2();
        tfidtransaksi.requestFocus();
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
        panelHeader = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        labelKodebuku = new javax.swing.JLabel();
        labelkdjenis = new javax.swing.JLabel();
        tfidtransaksi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        tfnamapmbeli = new javax.swing.JTextField();
        labelQty = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfbayar = new javax.swing.JTextField();
        tfcaribuku = new javax.swing.JTextField();
        btnkdbuku = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelbuku = new javax.swing.JTable();
        labelQty1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tftelepon = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        labelQty2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfpcs = new javax.swing.JTextField();
        tftotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        labelQty3 = new javax.swing.JLabel();
        labelQty4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfkembali = new javax.swing.JTextField();
        labelQty5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfhargabuku = new javax.swing.JTextField();
        btnTotal = new javax.swing.JButton();
        btnHitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 300));

        panelHeader.setBackground(new java.awt.Color(0, 204, 204));
        panelHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelHeaderMouseDragged(evt);
            }
        });
        panelHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHeaderMousePressed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(204, 102, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_4.png"))); // NOI18N
        btnClose.setContentAreaFilled(false);
        btnClose.setOpaque(true);
        btnClose.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_5.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_data_in_both_directions_50px_3.png"))); // NOI18N
        labelNama.setText("Transaksi");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 665, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelKodebuku.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKodebuku.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelKodebuku.setText("ID Transaksi");
        labelKodebuku.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelkdjenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelkdjenis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelkdjenis.setText("Nama Pembeli");
        labelkdjenis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tfidtransaksi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfidtransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfidtransaksiKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(":");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        btnSimpan.setBackground(new java.awt.Color(204, 204, 204));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_save_50px.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.setOpaque(true);
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSimpanMouseExited(evt);
            }
        });
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBersih.setBackground(new java.awt.Color(204, 204, 204));
        btnBersih.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBersih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_broom_50px.png"))); // NOI18N
        btnBersih.setText("Bersih");
        btnBersih.setContentAreaFilled(false);
        btnBersih.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBersih.setOpaque(true);
        btnBersih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBersihMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBersihMouseExited(evt);
            }
        });
        btnBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihActionPerformed(evt);
            }
        });

        tfnamapmbeli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfnamapmbeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfnamapmbeliKeyPressed(evt);
            }
        });

        labelQty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty.setText("Bayar");
        labelQty.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(":");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tfbayar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfbayarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfbayarKeyTyped(evt);
            }
        });

        tfcaribuku.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfcaribuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfcaribukuKeyTyped(evt);
            }
        });

        btnkdbuku.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnkdbuku.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnkdbuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_50px_2.png"))); // NOI18N
        btnkdbuku.setText("Kode Buku");
        btnkdbuku.setOpaque(true);

        tabelbuku.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelbuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelbuku.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelbuku.setRowHeight(30);
        tabelbuku.setRowMargin(2);
        tabelbuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbukuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelbuku);

        labelQty1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty1.setText("Telepon");
        labelQty1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(":");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tftelepon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tftelepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfteleponKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfteleponKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(":");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelQty2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty2.setText("Pcs");
        labelQty2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(":");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tfpcs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfpcs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfpcsKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfpcsKeyTyped(evt);
            }
        });

        tftotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tftotal.setFocusable(false);
        tftotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tftotalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tftotalKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(":");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelQty3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty3.setText("Total");
        labelQty3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelQty4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty4.setText("Kembali");
        labelQty4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(":");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tfkembali.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfkembali.setFocusable(false);
        tfkembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfkembaliKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfkembaliKeyTyped(evt);
            }
        });

        labelQty5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty5.setText("Harga Buku");
        labelQty5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText(":");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tfhargabuku.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfhargabuku.setFocusable(false);
        tfhargabuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfhargabukuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfhargabukuKeyTyped(evt);
            }
        });

        btnTotal.setBackground(new java.awt.Color(204, 204, 204));
        btnTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_calculator_50px.png"))); // NOI18N
        btnTotal.setText("Total");
        btnTotal.setContentAreaFilled(false);
        btnTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTotal.setOpaque(true);
        btnTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTotalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTotalMouseExited(evt);
            }
        });
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        btnHitung.setBackground(new java.awt.Color(204, 204, 204));
        btnHitung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_calculator_50px.png"))); // NOI18N
        btnHitung.setText("Hitung Kembalian");
        btnHitung.setContentAreaFilled(false);
        btnHitung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHitung.setOpaque(true);
        btnHitung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHitungMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHitungMouseExited(evt);
            }
        });
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelQty5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfhargabuku, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelQty3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(tftotal, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelQty2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfpcs, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(61, 61, 61)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(tfcaribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnkdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelkdjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelKodebuku, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfidtransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addComponent(tfnamapmbeli)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelQty1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tftelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelQty4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelQty, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnHitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfidtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKodebuku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfnamapmbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelkdjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelQty4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tftelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelQty1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(tfhargabuku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelQty5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfpcs, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelQty2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tftotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelQty3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfcaribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnkdbuku))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihTanggalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilihTanggalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilihTanggalMouseClicked

    private void btnPilihTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPilihTanggalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilihTanggalKeyPressed

    private void tabelbukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbukuMouseClicked
        int bar = tabelbuku.getSelectedRow();
        String a = tabmode2.getValueAt(bar, 0).toString();
        String b = tabmode2.getValueAt(bar, 1).toString();
         String c = tabmode2.getValueAt(bar, 2).toString();
        tfhargabuku.setText(c);

    }//GEN-LAST:event_tabelbukuMouseClicked

    private void tfcaribukuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcaribukuKeyTyped
        String sqlPencarian2 = "select * from buku where kd_buku like '%"+tfcaribuku.getText()+"%' or jdl_buku like '%"+tfcaribuku.getText()+"%'";
        pencarian2(sqlPencarian2);
        lebarKolom2();
    }//GEN-LAST:event_tfcaribukuKeyTyped

    private void tfbayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfbayarKeyTyped
        char c= evt.getKeyChar();
        if(! ((Character.isDigit(c)) ||
            ( c== KeyEvent.VK_BACK_SPACE)
            || (c== KeyEvent.VK_DELETE)
        ))
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "masukan angka 1-9");
            evt.consume();
        }
    }//GEN-LAST:event_tfbayarKeyTyped

    private void tfbayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfbayarKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfkembali.requestFocus();
        }
    }//GEN-LAST:event_tfbayarKeyPressed

    private void tfnamapmbeliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnamapmbeliKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tftelepon.requestFocus();
        }
    }//GEN-LAST:event_tfnamapmbeliKeyPressed

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed
        
        kosong();
    }//GEN-LAST:event_btnBersihActionPerformed

    private void btnBersihMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseExited
        btnBersih.setBackground(new Color(204,204,204));
        btnBersih.setForeground(Color.black);
    }//GEN-LAST:event_btnBersihMouseExited

    private void btnBersihMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseEntered
        btnBersih.setBackground(new Color(0,204,204));
        btnBersih.setForeground(Color.white);
    }//GEN-LAST:event_btnBersihMouseEntered

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(tfidtransaksi.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Id Transaksi tidak boleh kosong");
        } else if (tfnamapmbeli.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Pembeli tidak boleh kosong");
        } else if (tftelepon.getText().equals("")){
            JOptionPane.showMessageDialog(null, "telepon tidak boleh kosong");
        }else if (tfpcs.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Pcs tidak boleh kosong");
        } else if (tftotal.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Total tidak boleh kosong");
        }         
        else if (tfbayar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nominal Bayar tidak boleh kosong");
        } else if (tfkembali.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kembalian tidak boleh kosong");
        }  else {
            String sql = "insert into transaksi values (?,?,?,?,?,?,?)";
            
            
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tfidtransaksi.getText());
            stat.setString(2, tfnamapmbeli.getText());
            stat.setString(3, tftelepon.getText());
            stat.setString(4, tfpcs.getText());
            stat.setString(5, tftotal.getText());
            stat.setString(6, tfbayar.getText());
            stat.setString(7, tfkembali.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
                
                kosong();
                dataTable();
//                lebarKolom();
                tfidtransaksi.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnSimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseExited
        btnSimpan.setBackground(new Color(204,204,204));
        btnSimpan.setForeground(Color.black);
    }//GEN-LAST:event_btnSimpanMouseExited

    private void btnSimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseEntered
        btnSimpan.setBackground(new Color(0,204,204));
        btnSimpan.setForeground(Color.white);
    }//GEN-LAST:event_btnSimpanMouseEntered

    private void tfidtransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfidtransaksiKeyPressed
if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfcaribuku.requestFocus();
        }         
    }//GEN-LAST:event_tfidtransaksiKeyPressed

    private void panelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelHeaderMousePressed

    private void panelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMouseDragged
        if(maximixed){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_panelHeaderMouseDragged

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setBackground(new Color(204,102,255));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setBackground(Color.red);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void tfteleponKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfteleponKeyPressed
if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfpcs.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tfteleponKeyPressed

    private void tfteleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfteleponKeyTyped
 char c= evt.getKeyChar();
        if(! ((Character.isDigit(c)) ||
            ( c== KeyEvent.VK_BACK_SPACE)
            || (c== KeyEvent.VK_DELETE)
        ))
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "masukan angka 1-9");
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tfteleponKeyTyped

    private void tfpcsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpcsKeyPressed
      if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tftotal.requestFocus();
        }
    }//GEN-LAST:event_tfpcsKeyPressed

    private void tfpcsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpcsKeyTyped
 char c= evt.getKeyChar();
        if(! ((Character.isDigit(c)) ||
            ( c== KeyEvent.VK_BACK_SPACE)
            || (c== KeyEvent.VK_DELETE)
        ))
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "masukan angka 1-9");
            evt.consume();
        }     
    }//GEN-LAST:event_tfpcsKeyTyped

    private void tftotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftotalKeyPressed
   if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfbayar.requestFocus();
        }
    }//GEN-LAST:event_tftotalKeyPressed

    private void tftotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tftotalKeyTyped

    private void tfkembaliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfkembaliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfkembaliKeyPressed

    private void tfkembaliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfkembaliKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfkembaliKeyTyped

    private void tfhargabukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfhargabukuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfhargabukuKeyPressed

    private void tfhargabukuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfhargabukuKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfhargabukuKeyTyped

    private void btnTotalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTotalMouseEntered
 btnTotal.setBackground(new Color(0,204,204));
        btnTotal.setForeground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_btnTotalMouseEntered

    private void btnTotalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTotalMouseExited
       btnTotal.setBackground(new Color(204,204,204));
        btnTotal.setForeground(Color.black);
    }//GEN-LAST:event_btnTotalMouseExited

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
      int hargaBuku,pcs,Total;
      hargaBuku=Integer.parseInt(tfhargabuku.getText());
      pcs=Integer.parseInt(tfpcs.getText());
      Total=hargaBuku*pcs;
      
      tftotal.setText(Integer.toString(Total));
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnHitungMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungMouseEntered
    btnHitung.setBackground(new Color(0,204,204));
        btnHitung.setForeground(Color.white); 
    }//GEN-LAST:event_btnHitungMouseEntered

    private void btnHitungMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitungMouseExited
    btnHitung.setBackground(new Color(204,204,204));
        btnHitung.setForeground(Color.black);        // TODO add your handling code here:
    }//GEN-LAST:event_btnHitungMouseExited

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        int Total,Bayar,Kembalian;
        Total=Integer.parseInt(tftotal.getText());
        Bayar=Integer.parseInt(tfbayar.getText());
        
        Kembalian=Bayar-Total;
        
        tfkembali.setText(Integer.toString(Kembalian));
    }//GEN-LAST:event_btnHitungActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Transaksi dialog = new Transaksi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersih;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTotal;
    private javax.swing.JLabel btnkdbuku;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelKodebuku;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelQty;
    private javax.swing.JLabel labelQty1;
    private javax.swing.JLabel labelQty2;
    private javax.swing.JLabel labelQty3;
    private javax.swing.JLabel labelQty4;
    private javax.swing.JLabel labelQty5;
    private javax.swing.JLabel labelkdjenis;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTable tabelbuku;
    private javax.swing.JTextField tfbayar;
    private javax.swing.JTextField tfcaribuku;
    private javax.swing.JTextField tfhargabuku;
    private javax.swing.JTextField tfidtransaksi;
    private javax.swing.JTextField tfkembali;
    private javax.swing.JTextField tfnamapmbeli;
    private javax.swing.JTextField tfpcs;
    private javax.swing.JTextField tftelepon;
    private javax.swing.JTextField tftotal;
    // End of variables declaration//GEN-END:variables
}
