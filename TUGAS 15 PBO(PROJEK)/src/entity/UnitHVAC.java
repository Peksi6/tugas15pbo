package entity;

public class UnitHVAC {
    private String idUnit;
    private String namaUnit;
    private String lokasi;
    private String kapasitas;
    private String jenis;

    public UnitHVAC(String idUnit, String namaUnit, String lokasi, String kapasitas, String jenis) {
        this.idUnit = idUnit;
        this.namaUnit = namaUnit;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
        this.jenis = jenis;
    }

    // Getter dan Setter
    public String getIdUnit() { return idUnit; }
    public void setIdUnit(String idUnit) { this.idUnit = idUnit; }
    public String getNamaUnit() { return namaUnit; }
    public void setNamaUnit(String namaUnit) { this.namaUnit = namaUnit; }
    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    public String getKapasitas() { return kapasitas; }
    public void setKapasitas(String kapasitas) { this.kapasitas = kapasitas; }
    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public void tampilInfo() {
        System.out.println("[" + jenis + "] " + idUnit + " - " + namaUnit + " di " + lokasi);
    }
}