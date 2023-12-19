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


public class dataBuku extends javax.swing.JDialog {
    
    public final Connection conn = new koneksi().connect();

    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2;
    
    // frame maks dan geser panel
    static boolean maximixed = true;
    int xMouse;
    int yMouse;
    
    private void aktif(){
        tfkdbuku.setEnabled(true);
        tfPenerbit.setEnabled(true);
        tfjudul.setEnabled(true);
        tfharga.setEnabled(true);
        tfjumlah.setEnabled(true);
        tfpengarang.setEnabled(true);
        tfkodejenis.setEnabled(true);
        
        
    }
    
    protected void kosong(){
        tfkdbuku.setText(null);
        tfPenerbit.setText(null);
        tfkodejenis.setText(null);
        tfjumlah.setText(null);
        tfharga.setText(null);
        tfpengarang.setText(null);
        tfjudul.setText(null);
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
        Object[] Baris = {"No","Kode Buku","Kode Jenis","Judul Buku","Pengarang","Penerbit","Jumlah","Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelBuku.setModel(tabmode);
        String sql = "select * from buku order by kd_buku asc";
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
        Object[] Baris2 = {"Kode Jenis","Nama Jenis"};
        tabmode2 = new DefaultTableModel(null, Baris2);
        tabelJenis.setModel(tabmode2);
        String sql = "select * from jenis order by kd_jns asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String kd_jns = hasil.getString("kd_jns");
                String nama_jenis_buku = hasil.getString("nama_jenis_buku");
                String[] data = {kd_jns,nama_jenis_buku};
                tabmode2.addRow(data);
            }
        } catch (Exception e){
        }
    }
    
    
//    public void lebarKolom(){
//        TableColumn column;
//        tabelBarang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
//        column = tabelBarang.getColumnModel().getColumn(0);
//        column.setPreferredWidth(40);
//        column = tabelBarang.getColumnModel().getColumn(1);
//        column.setPreferredWidth(100);
//        column = tabelBarang.getColumnModel().getColumn(2);
//        column.setPreferredWidth(100);
//        column = tabelBarang.getColumnModel().getColumn(3);
//        column.setPreferredWidth(100);
//        column = tabelBarang.getColumnModel().getColumn(4);
//        column.setPreferredWidth(100);
//        column = tabelBarang.getColumnModel().getColumn(5);
//        column.setPreferredWidth(100);
//        column = tabelBarang.getColumnModel().getColumn(6);
//        column.setPreferredWidth(100);
//        column = tabelBarang.getColumnModel().getColumn(7);
//        column.setPreferredWidth(100);
//        column = tabelBarang.getColumnModel().getColumn(8);
//        column.setPreferredWidth(100);
//        
//    }
    
    public void lebarKolom2(){
        TableColumn column2;
        tabelJenis.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column2 = tabelJenis.getColumnModel().getColumn(0);
        column2.setPreferredWidth(100);
        column2 = tabelJenis.getColumnModel().getColumn(1);
        column2.setPreferredWidth(200);
    }
    
    public void pencarian(String sql){
        Object[] Baris = {"No","Kode Buku","Kode Jenis","Judul Buku","Pengarang","Penerbit","Jumlah","Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelBuku.setModel(tabmode);
        int brs = tabelBuku.getRowCount();
        for (int i = 0; 1 < brs; i++){
            tabmode.removeRow(1);
        }
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
        } catch(Exception e){
        }
    }
    
    public void pencarian2(String sql){
         Object[] Baris2 = {"Kode Jenis","Nama Jenis"};
        tabmode2 = new DefaultTableModel(null, Baris2);
        tabelJenis.setModel(tabmode2);
        int brs = tabelJenis.getRowCount();
        for (int i = 0; 1 < brs; i++){
            tabmode2.removeRow(1);
        }
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                 String kd_jns = hasil.getString("kd_jns");
                String nama_jenis_buku = hasil.getString("nama_jenis_buku");
                String[] data = {kd_jns,nama_jenis_buku};
                tabmode2.addRow(data);
            }
        } catch(Exception e){
            
        }
    }

    /**
     * Creates new form dataBarang
     */
    public dataBuku(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        aktif();
        dataTable();
//        lebarKolom();
        dataTable2();
        lebarKolom2();
        tfkdbuku.requestFocus();
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
        tfkdbuku = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBuku = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        tfkodejenis = new javax.swing.JTextField();
        labelQty = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfjumlah = new javax.swing.JTextField();
        tfcariJenis = new javax.swing.JTextField();
        btnJenis = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelJenis = new javax.swing.JTable();
        labelQty1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfjudul = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        labelQty2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfpengarang = new javax.swing.JTextField();
        tfPenerbit = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        labelQty3 = new javax.swing.JLabel();
        labelQty4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfharga = new javax.swing.JTextField();

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
        labelNama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_book_50px_1.png"))); // NOI18N
        labelNama.setText("Data Buku");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        labelKodebuku.setText("Kode Buku");
        labelKodebuku.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelkdjenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelkdjenis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelkdjenis.setText("Kode Jenis");
        labelkdjenis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tfkdbuku.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfkdbuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfkdbukuKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(":");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(900, 402));

        tabelBuku.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Buku", "Kode Jenis", "Judul  Buku", "Pengarang", "Penerbit", "Jumlah", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelBuku.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelBuku.setMaximumSize(new java.awt.Dimension(840, 500));
        tabelBuku.setMinimumSize(new java.awt.Dimension(840, 300));
        tabelBuku.setPreferredSize(new java.awt.Dimension(840, 300));
        tabelBuku.setRowHeight(30);
        tabelBuku.setRowMargin(2);
        tabelBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBuku);

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

        btnUbah.setBackground(new java.awt.Color(204, 204, 204));
        btnUbah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_property_50px.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setContentAreaFilled(false);
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.setOpaque(true);
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUbahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahMouseExited(evt);
            }
        });
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 204, 204));
        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_50px.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setContentAreaFilled(false);
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.setOpaque(true);
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapusMouseExited(evt);
            }
        });
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
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

        tfkodejenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfkodejenis.setFocusable(false);
        tfkodejenis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfkodejenisKeyPressed(evt);
            }
        });

        labelQty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty.setText("Jumlah");
        labelQty.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(":");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tfjumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfjumlahKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfjumlahKeyTyped(evt);
            }
        });

        tfcariJenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfcariJenis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfcariJenisKeyTyped(evt);
            }
        });

        btnJenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnJenis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnJenis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_50px_2.png"))); // NOI18N
        btnJenis.setText("Jenis");
        btnJenis.setOpaque(true);

        tabelJenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelJenis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "KODE JENIS", "NAMA JENIS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelJenis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelJenis.setRowHeight(30);
        tabelJenis.setRowMargin(2);
        tabelJenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelJenisMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelJenis);

        labelQty1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty1.setText("Judul");
        labelQty1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(":");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tfjudul.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfjudul.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfjudulKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfjudulKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(":");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelQty2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty2.setText("Pengarang");
        labelQty2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(":");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tfpengarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfpengarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfpengarangKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfpengarangKeyTyped(evt);
            }
        });

        tfPenerbit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfPenerbit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPenerbitKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPenerbitKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(":");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelQty3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty3.setText("Penerbit");
        labelQty3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelQty4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQty4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelQty4.setText("Harga");
        labelQty4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(":");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tfharga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfhargaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfhargaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelKodebuku, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelkdjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfkdbuku, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addComponent(tfkodejenis)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelQty1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelQty2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfpengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(labelQty3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelQty4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(645, 645, 645))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfharga, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfcariJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(422, 422, 422))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfkdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKodebuku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfharga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelQty4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfkodejenis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelkdjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQty1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfpengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQty2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfcariJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJenis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelQty3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
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

    private void tabelJenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelJenisMouseClicked
        int bar = tabelJenis.getSelectedRow();
        String a = tabmode2.getValueAt(bar, 0).toString();
        String b = tabmode2.getValueAt(bar, 1).toString();
        tfkodejenis.setText(a);
//        tfjumlah.requestFocus();
    }//GEN-LAST:event_tabelJenisMouseClicked

    private void tfcariJenisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcariJenisKeyTyped
        String sqlPencarian2 = "select * from jenis where kd_jns like '%"+tfcariJenis.getText()+"%' or nama_jenis_buku like '%"+tfcariJenis.getText()+"%'";
        pencarian2(sqlPencarian2);
        lebarKolom2();
    }//GEN-LAST:event_tfcariJenisKeyTyped

    private void tfjumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfjumlahKeyTyped
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
        {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka 0-9", "Input Jumlah", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tfjumlahKeyTyped

    private void tfjumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfjumlahKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfharga.requestFocus();
        }
    }//GEN-LAST:event_tfjumlahKeyPressed

    private void tfkodejenisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfkodejenisKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfjudul.requestFocus();
        }
    }//GEN-LAST:event_tfkodejenisKeyPressed

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed
        
        kosong();
    }//GEN-LAST:event_btnBersihActionPerformed

    private void btnBersihMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseExited
        btnBersih.setBackground(new Color(204,204,204));
        btnBersih.setForeground(Color.black);
    }//GEN-LAST:event_btnBersihMouseExited

    private void btnBersihMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseEntered
        btnBersih.setBackground(new Color(0,0,204));
        btnBersih.setForeground(Color.white);
    }//GEN-LAST:event_btnBersihMouseEntered

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql="delete from buku where kd_buku='"+tfkdbuku.getText()+"'";
            try {
                PreparedStatement stat=conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                kosong();
                dataTable();
//                lebarKolom();
                tfkdbuku.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
        btnHapus.setBackground(new Color(204,204,204));
        btnHapus.setForeground(Color.black);
    }//GEN-LAST:event_btnHapusMouseExited

    private void btnHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseEntered
        btnHapus.setBackground(Color.red);
        btnHapus.setForeground(Color.white);
    }//GEN-LAST:event_btnHapusMouseEntered

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String sql = "update buku set kd_buku=?,kd_jns=?,jdl_buku=?,pengarang=?,pnerbit=?,jumlah=?,harga=? where kd_buku='"+tfkdbuku.getText()+"'";
        
        
       
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, tfkdbuku.getText());
            stat.setString(2, tfkodejenis.getText());
            stat.setString(3, tfjudul.getText());
            stat.setString(4, tfpengarang.getText());
            stat.setString(5, tfPenerbit.getText());
            stat.setString(6, tfjumlah.getText());
            stat.setString(7, tfharga.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
           
            kosong();
            dataTable();

            tfkdbuku.requestFocus();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnUbahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseExited
        btnUbah.setBackground(new Color(204,204,204));
        btnUbah.setForeground(Color.black);
    }//GEN-LAST:event_btnUbahMouseExited

    private void btnUbahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseEntered
        btnUbah.setBackground(new Color(0,0,204));
        btnUbah.setForeground(Color.white);
    }//GEN-LAST:event_btnUbahMouseEntered

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(tfkdbuku.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kode Buku tidak boleh kosong");
        } else if (tfkodejenis.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kode jenis tidak boleh kosong");
        } else if (tfjudul.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Judul tidak boleh kosong");
        }else if (tfpengarang.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Pengarang tidak boleh kosong");
        } else if (tfPenerbit.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Penerbit tidak boleh kosong");
        }         
        else if (tfjumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong");
        } else if (tfharga.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong");
        }  else {
            String sql = "insert into buku values (?,?,?,?,?,?,?)";
            
            
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tfkdbuku.getText());
            stat.setString(2, tfkodejenis.getText());
            stat.setString(3, tfjudul.getText());
            stat.setString(4, tfpengarang.getText());
            stat.setString(5, tfPenerbit.getText());
            stat.setString(6, tfjumlah.getText());
            stat.setString(7, tfharga.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
                //            String refresh = "select * from tb_barang";
                kosong();
                dataTable();
//                lebarKolom();
                tfkdbuku.requestFocus();
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
        btnSimpan.setBackground(new Color(0,0,204));
        btnSimpan.setForeground(Color.white);
    }//GEN-LAST:event_btnSimpanMouseEntered

    private void tabelBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBukuMouseClicked
        int bar = tabelBuku.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        

        
        
        
        tfkdbuku.setText(b);
        tfkodejenis.setText(c);
        tfjudul.setText(d);
        tfpengarang.setText(e);
        tfPenerbit.setText(f);
        tfjumlah.setText(g);
        tfharga.setText(h);
      
    }//GEN-LAST:event_tabelBukuMouseClicked

    private void tfkdbukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfkdbukuKeyPressed
if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfcariJenis.requestFocus();
        }         
    }//GEN-LAST:event_tfkdbukuKeyPressed

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

    private void tfjudulKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfjudulKeyPressed
if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfpengarang.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tfjudulKeyPressed

    private void tfjudulKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfjudulKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfjudulKeyTyped

    private void tfpengarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpengarangKeyPressed
      if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfPenerbit.requestFocus();
        }
    }//GEN-LAST:event_tfpengarangKeyPressed

    private void tfpengarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpengarangKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfpengarangKeyTyped

    private void tfPenerbitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPenerbitKeyPressed
   if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            tfjumlah.requestFocus();
        }
    }//GEN-LAST:event_tfPenerbitKeyPressed

    private void tfPenerbitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPenerbitKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPenerbitKeyTyped

    private void tfhargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfhargaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfhargaKeyPressed

    private void tfhargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfhargaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfhargaKeyTyped

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
            java.util.logging.Logger.getLogger(dataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                dataBuku dialog = new dataBuku(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel btnJenis;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelKodebuku;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelQty;
    private javax.swing.JLabel labelQty1;
    private javax.swing.JLabel labelQty2;
    private javax.swing.JLabel labelQty3;
    private javax.swing.JLabel labelQty4;
    private javax.swing.JLabel labelkdjenis;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTable tabelBuku;
    private javax.swing.JTable tabelJenis;
    private javax.swing.JTextField tfPenerbit;
    private javax.swing.JTextField tfcariJenis;
    private javax.swing.JTextField tfharga;
    private javax.swing.JTextField tfjudul;
    private javax.swing.JTextField tfjumlah;
    private javax.swing.JTextField tfkdbuku;
    private javax.swing.JTextField tfkodejenis;
    private javax.swing.JTextField tfpengarang;
    // End of variables declaration//GEN-END:variables
}
