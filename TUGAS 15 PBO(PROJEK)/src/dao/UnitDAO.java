package dao;

import config.DatabaseConnection;
import entity.UnitHVAC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDAO {
    public void tambahUnit(UnitHVAC unit) {
        String sql = "INSERT INTO unit_hvac VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, unit.getIdUnit());
            ps.setString(2, unit.getNamaUnit());
            ps.setString(3, unit.getLokasi());
            ps.setString(4, unit.getKapasitas());
            ps.setString(5, unit.getJenis());
            ps.executeUpdate();
            System.out.println("✅ Unit HVAC berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("⚠️ Gagal tambah unit: " + e.getMessage());
        }
    }

    public List<UnitHVAC> tampilUnit() {
        List<UnitHVAC> list = new ArrayList<>();
        String sql = "SELECT * FROM unit_hvac";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new UnitHVAC(
                    rs.getString("id_unit"),
                    rs.getString("nama_unit"),
                    rs.getString("lokasi"),
                    rs.getString("kapasitas"),
                    rs.getString("jenis")
                ));
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Gagal mengambil data unit: " + e.getMessage());
        }
        return list;
    }
}