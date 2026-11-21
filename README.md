1.	Top-Level Container
•	JFrame (FormMahasiswa): Jendela utama aplikasi desktop yang mewarisi JFrame. Mengatur judul jendela ("Form Data Mahasiswa - PBO"), ukuran (420x280), perilaku penutupan (EXIT_ON_CLOSE), posisi tengah layar (setLocationRelativeTo(null)), serta menampung panel-panel utama menggunakan BorderLayout.
•	JOptionPane: Komponen dialog pop-up bawaan Swing yang dipanggil saat tombol Simpan ditekan untuk menampilkan pesan peringatan (WARNING_MESSAGE) jika checkbox belum dicentang, atau pesan informasi (INFORMATION_MESSAGE) berisi ringkasan data mahasiswa yang disimpan.

2.	Intermediate Container
•	JPanel (panelHeader): Wadah penampung bagian atas (BorderLayout.NORTH) yang mengatur judul form di tengah menggunakan FlowLayout(FlowLayout.CENTER).
•	JPanel (panelForm): Wadah utama di bagian tengah (BorderLayout.CENTER) yang menyusun pasangan label dan input secara teratur dalam grid 4 baris × 2 kolom (GridLayout(4, 2, 8, 8)) dengan padding luar menggunakan BorderFactory.createEmptyBorder(10, 20, 10, 20).
•	JPanel (panelTombol): Wadah bagian bawah (BorderLayout.SOUTH) yang meratakan tombol aksi ke sisi kanan menggunakan FlowLayout(FlowLayout.RIGHT).

3.	Atomic Components (Komponen Dasar / Kontrol)
•	JLabel (lblJudul, lblNama, lblNim, lblProdi, lblStatus): Menampilkan teks statis, baik sebagai judul form ("INPUT DATA MAHASISWA" dengan font Arial Bold 16pt) maupun label penjelas untuk setiap kolom input.
•	JTextField (txtNama, txtNim): Kolom input teks satu baris untuk mengisi Nama Lengkap dan NIM mahasiswa, serta direset kembali menjadi string kosong ("") saat tombol Reset diklik.
•	JComboBox<String> (cmbProdi): Komponen dropdown pilihan program studi ("Teknik Informatika", "Teknik Elektro", "Teknik Sipil", "Teknik Mesin"), yang nilai terpilihnya diambil lewat getSelectedItem() dan dikembalikan ke indeks 0 saat di-reset.

•	JCheckBox (chkSetuju): Kotak centang konfirmasi ("Data sudah benar") yang statusnya diperiksa melalui isSelected() sebelum data disimpan dan dikosongkan (false) saat di-reset.
•	JButton (btnSimpan, btnReset): Tombol aksi interaktif untuk memproses penyimpanan data (Simpan) dan mengembalikan seluruh isian form ke kondisi awal (Reset).

4.	Layout Manager & Event Handling (Pendukung Interaksi)
•	BorderLayout: Membagi area JFrame ke zona NORTH (panelHeader), CENTER (panelForm), dan SOUTH (panelTombol) dengan jarak antar komponen (hgap=10, vgap=10).
•	GridLayout: Mengatur tata letak panelForm menjadi 4 baris dan 2 kolom berukuran seragam dengan jarak 8px.
•	FlowLayout: Mengatur aliran komponen secara horizontal pada panelHeader (rata tengah) dan panelTombol (rata kanan).
•	ActionListener (actionPerformed): Menangani klik pada btnSimpan (validasi checkbox dan tampilkan data) serta btnReset (bersihkan seluruh field input).
•	MouseAdapter (mouseEntered & mouseExited): Memberikan efek perubahan warna teks (Color.BLUE saat kursor masuk dan Color.BLACK saat kursor keluar) khusus pada btnSimpan.


<img width="302" height="203" alt="image" src="https://github.com/user-attachments/assets/648b1c7a-1168-49aa-9254-fecf2f9485d3" />

