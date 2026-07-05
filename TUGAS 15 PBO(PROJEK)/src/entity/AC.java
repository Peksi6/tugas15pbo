package entity;

public class AC extends UnitHVAC {
    private String refrigerant;

    public AC(String idUnit, String namaUnit, String lokasi, String kapasitas, String refrigerant) {
        super(idUnit, namaUnit, lokasi, kapasitas, "AC");
        this.refrigerant = refrigerant;
    }

    public String getRefrigerant() { return refrigerant; }
    public void setRefrigerant(String refrigerant) { this.refrigerant = refrigerant; }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("   Refrigerant: " + refrigerant);
    }
}