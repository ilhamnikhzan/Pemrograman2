import javax.swing.table.DefaultTableModel;

public class FormMahasiswa extends javax.swing.JFrame {

    public FormMahasiswa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMahasiswa = new javax.swing.JTable();
        btnTampil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Mahasiswa");

        tableMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "NIM", "Nama Mahasiswa", "Nilai"
            }
        ));
        jScrollPane1.setViewportView(tableMahasiswa);

        btnTampil.setText("Tampilkan Data");
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });

        // Layout otomatis dari NetBeans GUI Designer
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btnTampil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTampil)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) tableMahasiswa.getModel();
        model.setRowCount(0); // hapus data lama

        // Contoh data
        Object[][] data = {
            {"230101001", "Andi", 88},
            {"230101002", "Budi", 90},
            {"230101003", "Citra", 77}
        };

        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FormMahasiswa().setVisible(true));
    }

    // Deklarasi komponen
    private javax.swing.JButton btnTampil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMahasiswa;
}
