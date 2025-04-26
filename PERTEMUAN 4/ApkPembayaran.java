package aplikasipembayaran12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiPembayaran12 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pembayaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 1 - NO. MEJA
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("NO. MEJA:"), gbc);

        gbc.gridx = 1;
        JTextField noMejaField = new JTextField(10);
        frame.add(noMejaField, gbc);

        // Row 2 - TOTAL PESANAN
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("TOTAL PESANAN:"), gbc);

        gbc.gridx = 1;
        JTextField totalPesananField = new JTextField(10);
        frame.add(totalPesananField, gbc);

        // Row 3 - PPN
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("PPN:"), gbc);

        gbc.gridx = 1;
        JTextField ppnField = new JTextField(10);
        frame.add(ppnField, gbc);

        // Row 4 - UANG PEMBAYARAN
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("UANG PEMBAYARAN:"), gbc);

        gbc.gridx = 1;
        JTextField uangPembayaranField = new JTextField(10);
        frame.add(uangPembayaranField, gbc);

        // Row 5 - UANG KEMBALI
        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(new JLabel("UANG KEMBALI:"), gbc);

        gbc.gridx = 1;
        JTextField uangKembaliField = new JTextField(10);
        uangKembaliField.setEditable(false);
        frame.add(uangKembaliField, gbc);

        // Row 6 - Button STRUK dan BAYAR
        gbc.gridx = 0;
        gbc.gridy = 5;
        JButton strukButton = new JButton("STRUK");
        frame.add(strukButton, gbc);

        gbc.gridx = 1;
        JButton bayarButton = new JButton("BAYAR");
        frame.add(bayarButton, gbc);

        // Row 7 - Area STRUK
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JTextArea strukArea = new JTextArea(8, 20);
        strukArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(strukArea);
        frame.add(scrollPane, gbc);

        // Row 8 - TOTAL PENDAPATAN
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        frame.add(new JLabel("TOTAL PENDAPATAN:"), gbc);

        gbc.gridx = 1;
        JTextField totalPendapatanField = new JTextField(10);
        totalPendapatanField.setEditable(false);
        frame.add(totalPendapatanField, gbc);

        // Logic
        final int[] totalPendapatan = {0};

        bayarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int totalPesanan = Integer.parseInt(totalPesananField.getText());
                    int ppn = Integer.parseInt(ppnField.getText());
                    int uangPembayaran = Integer.parseInt(uangPembayaranField.getText());

                    int totalHarga = totalPesanan + ppn;
                    int uangKembali = uangPembayaran - totalHarga;

                    uangKembaliField.setText(String.valueOf(uangKembali));

                    totalPendapatan[0] += totalHarga;
                    totalPendapatanField.setText(String.valueOf(totalPendapatan[0]));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        strukButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder struk = new StringBuilder();
                struk.append("Total Pesanan: ").append(totalPesananField.getText()).append("\n");
                struk.append("PPN: ").append(ppnField.getText()).append("\n");
                struk.append("Uang Pembayaran: ").append(uangPembayaranField.getText()).append("\n");
                struk.append("Uang Kembali: ").append(uangKembaliField.getText()).append("\n");
                struk.append("STRUK\n");
                strukArea.setText(struk.toString());
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
