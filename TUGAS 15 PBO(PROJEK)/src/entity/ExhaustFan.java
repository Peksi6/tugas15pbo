package entity;

public class ExhaustFan extends UnitHVAC {
    private int kecepatanMotor;

    public ExhaustFan(String idUnit, String namaUnit, String lokasi, String kapasitas, int kecepatanMotor) {
        super(idUnit, namaUnit, lokasi, kapasitas, "ExhaustFan");
        this.kecepatanMotor = kecepatanMotor;
    }

    public int getKecepatanMotor() { return kecepatanMotor; }
    public void setKecepatanMotor(int kecepatanMotor) { this.kecepatanMotor = kecepatanMotor; }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("   Kecepatan Motor: " + kecepatanMotor + " RPM");
    }
}