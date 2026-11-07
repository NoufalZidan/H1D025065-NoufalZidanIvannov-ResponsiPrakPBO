public class SistemAC extends PerangkatIoT implements KendaliDaya {
    private int suhuTarget;

    public SistemAC(String macAddress) {
        super(macAddress);
        setNamaPerangkat("AC Pintar Ruang Tamu");
        this.suhuTarget = 24;
    }

    @Override
    public void nyalakan() {
        setStatusMenyala(true);
        System.out.println(getNamaPerangkat() + " dinyalakan. Suhu target: " + this.suhuTarget + "C");
    }

    @Override
    public void matikan() {
        setStatusMenyala(false);
        System.out.println(getNamaPerangkat() + " dimatikan");
    }

    @Override
    public void prosesDataSensor(int suhuRuangan) {
        System.out.println("\n[Sensor Suhu mendeteksi: " + suhuRuangan + "C]");
        if (suhuRuangan > 28) {
            System.out.println("Suhu panas. AC menyala");
            nyalakan();
        } else if (suhuRuangan < 22) {
            System.out.println("Suhu terlalu dingin. AC dimatikan sementara");
            matikan();
        } else {
            System.out.println("Suhu normal. AC standby (Status daya: " + (getStatusMenyala() ? "ON" : "OFF") + ")");
        }
    }
}
