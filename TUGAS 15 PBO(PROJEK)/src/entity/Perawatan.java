package entity;

public class Perawatan {
    private int idPerawatan;
    private String idUnit;
    private String tanggal;
    private String teknisi;
    private double biaya;

    public Perawatan(int idPerawatan, String idUnit, String tanggal, String teknisi, double biaya) {
        this.idPerawatan = idPerawatan;
        this.idUnit = idUnit;
        this.tanggal = tanggal;
        this.teknisi = teknisi;
        this.biaya = biaya;
    }

    // Getter dan Setter
    public int getIdPerawatan() { return idPerawatan; }
    public String getIdUnit() { return idUnit; }
    public String getTanggal() { return tanggal; }
    public String getTeknisi() { return teknisi; }
    public double getBiaya() { return biaya; }
}