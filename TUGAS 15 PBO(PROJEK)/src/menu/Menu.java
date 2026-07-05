package menu;

import dao.UnitDAO;
import dao.PerawatanDAO;
import entity.UnitHVAC;
import entity.AC;
import entity.ExhaustFan;
import utils.InputHelper;

public class Menu {
    private final UnitDAO unitDAO = new UnitDAO();
    private final PerawatanDAO perawatanDAO = new PerawatanDAO();

    public void tampilMenuUtama() {
        int pilihan;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Data Unit HVAC");
            System.out.println("2. Data Perawatan");
            System.out.println("3. Laporan");
            System.out.println("0. Keluar");
            pilihan = InputHelper.readInt("Pilih menu: ");

            switch (pilihan) {
                case 1 -> submenuUnit();
                case 2 -> submenuPerawatan();
                case 3 -> submenuLaporan();
                case 0 -> System.out.println("Terima kasih, program selesai.");
                default -> System.out.println("⚠️ Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    private void submenuUnit() {
        int pilihan;
        do {
            System.out.println("\n-- SUBMENU DATA UNIT HVAC --");
            System.out.println("1. Tambah Unit");
            System.out.println("2. Lihat Data Unit");
            System.out.println("3. Kembali");
            pilihan = InputHelper.readInt("Pilih: ");

            if (pilihan == 1) {
                String id = InputHelper.readString("ID Unit: ");
                String nama = InputHelper.readString("Nama Unit: ");
                String lokasi = InputHelper.readString("Lokasi: ");
                String kapasitas = InputHelper.readString("Kapasitas: ");
                int jenisChoice = InputHelper.readInt("Jenis (1. AC, 2. Exhaust Fan): ");
                
                if (jenisChoice == 1) {
                    String ref = InputHelper.readString("Jenis Refrigerant: ");
                    unitDAO.tambahUnit(new AC(id, nama, lokasi, kapasitas, ref));
                } else {
                    int speed = InputHelper.readInt("Kecepatan Motor (RPM): ");
                    unitDAO.tambahUnit(new ExhaustFan(id, nama, lokasi, kapasitas, speed));
                }
            } else if (pilihan == 2) {
                // Poin 8: Polimorfisme dipanggil di sini
                System.out.println("\n--- DATA UNIT HVAC ---");
                for (UnitHVAC u : unitDAO.tampilUnit()) {
                    u.tampilInfo(); 
                }
            }
        } while (pilihan != 3);
    }

    private void submenuPerawatan() {
        int pilihan;
        do {
            System.out.println("\n-- SUBMENU DATA PERAWATAN --");
            System.out.println("1. Tambah Perawatan");
            System.out.println("2. Kembali");
            pilihan = InputHelper.readInt("Pilih: ");

            if (pilihan == 1) {
                String idUnit = InputHelper.readString("ID Unit: ");
                String tgl = InputHelper.readString("Tanggal (YYYY-MM-DD): ");
                String teknisi = InputHelper.readString("Nama Teknisi: ");
                double biaya = InputHelper.readDouble("Biaya Perawatan: ");
                
                perawatanDAO.tambahPerawatan(idUnit, tgl, teknisi, biaya);
            }
        } while (pilihan != 2);
    }

    private void submenuLaporan() {
        int pilihan;
        do {
            System.out.println("\n-- SUBMENU LAPORAN --");
            System.out.println("1. Lihat View Laporan");
            System.out.println("2. Hitung Total Biaya Perawatan");
            System.out.println("3. Kembali");
            pilihan = InputHelper.readInt("Pilih: ");

            if (pilihan == 1) {
                perawatanDAO.tampilLaporanView();
            } else if (pilihan == 2) {
                String idUnit = InputHelper.readString("Masukkan ID Unit: ");
                double total = perawatanDAO.hitungTotalBiaya(idUnit);
                System.out.printf("Total Biaya untuk Unit %s adalah: Rp%,.2f\n", idUnit, total);
            }
        } while (pilihan != 3);
    }
}