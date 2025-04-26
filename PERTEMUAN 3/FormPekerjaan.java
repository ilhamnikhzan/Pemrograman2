package formpekerjaan;//ILHAM NURUL IKHSAN

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

class JobManagementApp extends JFrame {
    private JTextField kodeField, namaField;
    private JComboBox<Integer> jumlahTugas;
    private DefaultTableModel tableModel;
    private JTable table;
    
    public JobManagementApp() {
        setTitle("Aplikasi Gaji Karyawan");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel panelForm = new JPanel(new GridLayout(3, 2));
        panelForm.setBackground(new Color(200, 255, 200));
        panelForm.setBorder(BorderFactory.createTitledBorder("Data Pekerjaan"));
        
        kodeField = new JTextField();
        namaField = new JTextField();
        jumlahTugas = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        
        panelForm.add(new JLabel("Kode Pekerjaan"));
        panelForm.add(kodeField);
        panelForm.add(new JLabel("Nama Pekerjaan"));
        panelForm.add(namaField);
        panelForm.add(new JLabel("Jumlah Tugas"));
        panelForm.add(jumlahTugas);
        
        JPanel panelButton = new JPanel();
        panelButton.setBackground(new Color(255, 200, 200));
        JButton simpanBtn = new JButton("Simpan");
        JButton hapusBtn = new JButton("Hapus");
        JButton tutupBtn = new JButton("Tutup");
        panelButton.add(simpanBtn);
        panelButton.add(hapusBtn);
        panelButton.add(tutupBtn);
        
        String[] columnNames = {"Kode", "Nama Pekerjaan"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane tablePane = new JScrollPane(table);
        
        simpanBtn.addActionListener(e -> tambahData());
        hapusBtn.addActionListener(e -> hapusData());
        tutupBtn.addActionListener(e -> System.exit(0));
        
        add(panelForm, BorderLayout.NORTH);
        add(tablePane, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);
    }
    
    private void tambahData() {
        String kode = kodeField.getText();
        String nama = namaField.getText();
        if (!kode.isEmpty() && !nama.isEmpty()) {
            tableModel.addRow(new Object[]{kode, nama});
            kodeField.setText("");
            namaField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Isi semua field terlebih dahulu.");
        }
    }
    
    private void hapusData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JobManagementApp().setVisible(true));
    }
}
