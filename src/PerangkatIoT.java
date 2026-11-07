public abstract class PerangkatIoT {
    public static final String PROTOKOL = "MQTT";
    private final String macAddress;
    private String namaPerangkat;
    private boolean isMenyala;

    public PerangkatIoT(String macAddress) {
        this.macAddress = macAddress;
        this.namaPerangkat = "Perangkat Tanpa Nama";
        this.isMenyala = false;
    }

    public PerangkatIoT(String macAddress, String namaPerangkat) {
        this.macAddress = macAddress;
        this.namaPerangkat = namaPerangkat;
        this.isMenyala = false;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getNamaPerangkat() {
        return this.namaPerangkat;
    }

    public void setNamaPerangkat(String namaPerangkat) {
        this.namaPerangkat = namaPerangkat;
    }

    public boolean getStatusMenyala() {
        return this.isMenyala;
    }

    public void setStatusMenyala(boolean isMenyala) {
        this.isMenyala = isMenyala;
    }

    public abstract void prosesDataSensor(int nilaiSensor);

    public void tampilkanInfo() {
        System.out.println("INFO " + this.namaPerangkat);
        System.out.println("MAC Address: " + this.macAddress);
        System.out.println("Protokol: " + PROTOKOL);
        System.out.println("Status Daya: " + (this.isMenyala ? "ON" : "OFF"));
    }
}
