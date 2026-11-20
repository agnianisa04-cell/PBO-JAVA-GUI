import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormMahasiswa extends JFrame implements ActionListener {

    // Deklarasi Atomic Components
    private JLabel lblJudul, lblNama, lblNim, lblProdi, lblStatus;
    private JTextField txtNama, txtNim;
    private JComboBox<String> cmbProdi;
    private JCheckBox chkSetuju;
    private JButton btnSimpan, btnReset;

    public FormMahasiswa() {
        // 1. Konfigurasi Top-Level Container (JFrame)[cite: 11, 22, 23]
        setTitle("Form Data Mahasiswa - PBO");
        setSize(420, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Menempatkan window di tengah layar

        // Menggunakan Layout Manager ke-1: BorderLayout pada JFrame[cite: 12, 48, 54]
        setLayout(new BorderLayout(10, 10));

        // 2. Intermediate Container 1: Panel Header (Menggunakan FlowLayout)[cite: 11, 12, 53]
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblJudul = new JLabel("INPUT DATA MAHASISWA");
        lblJudul.setFont(new Font("Arial", Font.BOLD, 16));
        panelHeader.add(lblJudul);

        // 3. Intermediate Container 2: Panel Form (Menggunakan Layout Manager ke-2: GridLayout)[cite: 11, 12, 54]
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Inisialisasi & penambahan Atomic Components ke panelForm
        lblNama = new JLabel("Nama Lengkap:");
        txtNama = new JTextField();

        lblNim = new JLabel("NIM:");
        txtNim = new JTextField();

        lblProdi = new JLabel("Program Studi:");
        String[] daftarProdi = {"Teknik Informatika", "Teknik Elektro", "Teknik Sipil", "Teknik Mesin"};
        cmbProdi = new JComboBox<>(daftarProdi);

        lblStatus = new JLabel("Konfirmasi:");
        chkSetuju = new JCheckBox("Data sudah benar");

        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblNim);
        panelForm.add(txtNim);
        panelForm.add(lblProdi);
        panelForm.add(cmbProdi);
        panelForm.add(lblStatus);
        panelForm.add(chkSetuju);

        // 4. Intermediate Container 3: Panel Tombol (Menggunakan Layout Manager ke-3: FlowLayout)[cite: 11, 12, 54]
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSimpan = new JButton("Simpan");
        btnReset = new JButton("Reset");

        // Mendaftarkan Event Listener ke tombol[cite: 12]
        btnSimpan.addActionListener(this);
        btnReset.addActionListener(this);

        // Contoh penggunaan Event Adapter Class (MouseAdapter) untuk efek hover pada tombol[cite: 12]
        btnSimpan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSimpan.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSimpan.setForeground(Color.BLACK);
            }
        });

        panelTombol.add(btnSimpan);
        panelTombol.add(btnReset);

        // Menggabungkan semua Intermediate Container ke dalam Top-Level Container[cite: 13, 54]
        add(panelHeader, BorderLayout.NORTH);
        add(panelForm, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);
    }

    // 5. Event Handling: Override method dari interface ActionListener[cite: 12]
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSimpan) {
            if (!chkSetuju.isSelected()) {
                // Menggunakan Top-Level Container Dialog (JOptionPane)
                JOptionPane.showMessageDialog(this, 
                    "Silakan centang persetujuan data terlebih dahulu!", 
                    "Peringatan", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nama = txtNama.getText();
            String nim = txtNim.getText();
            String prodi = (String) cmbProdi.getSelectedItem();

            String pesan = "Data Berhasil Disimpan:\n"
                         + "Nama : " + nama + "\n"
                         + "NIM    : " + nim + "\n"
                         + "Prodi  : " + prodi;

            JOptionPane.showMessageDialog(this, pesan, "Informasi", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == btnReset) {
            // Mengosongkan kembali semua inputan[cite: 19]
            txtNama.setText("");
            txtNim.setText("");
            cmbProdi.setSelectedIndex(0);
            chkSetuju.setSelected(false);
        }
    }

    public static void main(String[] args) {
        // Menjalankan GUI di dalam Event Dispatch Thread (EDT) sesuai standar Swing[cite: 55]
        SwingUtilities.invokeLater(() -> {
            FormMahasiswa app = new FormMahasiswa();
            app.setVisible(true);
        });
    }
}