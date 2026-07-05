package dao;

import config.DatabaseConnection;
import java.sql.*;

public class PerawatanDAO {
    
    // Poin 10: Menggunakan Stored Procedure
    public void tambahPerawatan(String idUnit, String tanggal, String teknisi, double biaya) {
        String sql = "{CALL sp_tambah_perawatan(?, ?, ?, ?)}";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, idUnit);
            cs.setString(2, tanggal);
            cs.setString(3, teknisi);
            cs.setDouble(4, biaya);
            cs.execute();
            System.out.println("✅ Data perawatan berhasil disimpan!");
        } catch (SQLException e) {
            // Poin 17: Akan menangkap error trigger jika biaya negatif
            System.out.println("⚠️ Gagal menyimpan perawatan: " + e.getMessage());
        }
    }

    // Poin 11: Menggunakan Function
    public double hitungTotalBiaya(String idUnit) {
        String sql = "{? = call fn_total_biaya(?)}";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.DECIMAL);
            cs.setString(2, idUnit);
            cs.execute();
            return cs.getDouble(1);
        } catch (SQLException e) {
            System.out.println("⚠️ Gagal memanggil fungsi: " + e.getMessage());
            return 0;
        }
    }

    // Poin 12: Menggunakan View
    public void tampilLaporanView() {
        String sql = "SELECT * FROM vw_laporan_perawatan";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n=== LAPORAN PERAWATAN (VIEW) ===");
            System.out.printf("%-4s | %-6s | %-15s | %-10s | %-12s | %-10s | %-10s\n", 
                "ID", "UnitID", "Nama Unit", "Jenis", "Tanggal", "Teknisi", "Biaya");
            System.out.println("--------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-4d | %-6s | %-15s | %-10s | %-12s | %-10s | Rp%,.2f\n",
                    rs.getInt("id_perawatan"),
                    rs.getString("id_unit"),
                    rs.getString("nama_unit"),
                    rs.getString("jenis"),
                    rs.getString("tanggal"),
                    rs.getString("teknisi"),
                    rs.getDouble("biaya")
                );
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Gagal memuat view: " + e.getMessage());
        }
    }
}