import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikasiBiodataMahasiswa extends JFrame {

    // Komponen Input
    private JTextField txtNIM, txtNama, txtProdi;
    // Komponen Tombol
    private JButton btnTampilkan, btnReset;
    // Komponen Output
    private JTextArea txtOutput;

    public AplikasiBiodataMahasiswa() {
        // Mengatur properti JFrame
        setTitle("Aplikasi Biodata Mahasiswa");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Utama Input Data
        JPanel panelInput = new JPanel();
        panelInput.setBorder(BorderFactory.createTitledBorder("Input Data"));
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label dan TextField NIM
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.1;
        panelInput.add(new JLabel("NIM"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.9;
        txtNIM = new JTextField();
        panelInput.add(txtNIM, gbc);

        // Label dan TextField Nama
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.1;
        panelInput.add(new JLabel("Nama"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.9;
        txtNama = new JTextField();
        panelInput.add(txtNama, gbc);

        // Label dan TextField Program Studi
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.1;
        panelInput.add(new JLabel("Program Studi"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.9;
        txtProdi = new JTextField();
        panelInput.add(txtProdi, gbc);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnTampilkan = new JButton("Tampilkan");
        btnReset = new JButton("Reset");
        panelTombol.add(btnTampilkan);
        panelTombol.add(btnReset);

        // Gabungkan Panel Input dan Tombol ke bagian atas (North)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // Panel Output
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.setBorder(BorderFactory.createTitledBorder("Output"));
        
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Menggunakan font Monospaced agar format titik dua rapi
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        // Menambahkan seluruh panel ke Frame
        add(panelAtas, BorderLayout.NORTH);
        add(panelOutput, BorderLayout.CENTER);

        // --- LOGIKA EVENT HANDLER (ACTION LISTENER) ---

        // Aksi ketika tombol Tampilkan diklik
        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNIM.getText();
                String nama = txtNama.getText();
                String prodi = txtProdi.getText();

                // Format teks output sesuai gambar
                String hasil = "========== BIODATA MAHASISWA ==========\n\n"
                             + "NIM           : " + nim + "\n"
                             + "Nama          : " + nama + "\n"
                             + "Program Studi : " + prodi;
                
                txtOutput.setText(hasil);
            }
        });

        // Aksi ketika tombol Reset diklik
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNIM.setText("");
                txtNama.setText("");
                txtProdi.setText("");
                txtOutput.setText("");
                txtNIM.requestFocus(); // Mengembalikan fokus kursor ke field NIM
            }
        });
    }

    public static void main(String[] args) {
        // Menjalankan GUI di thread yang aman (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikasiBiodataMahasiswa().setVisible(true);
            }
        });
    }
}