public class LampuPintar extends PerangkatIoT implements KoneksiJaringan, KendaliDaya {
    private int tingkatKecerahan;

    public LampuPintar(String macAddress, String namaPerangkat) {
        super(macAddress, namaPerangkat);
        this.tingkatKecerahan = 0;
    }

    @Override
    public void hubungkanWifi(String ssid) {
        System.out.println(getNamaPerangkat() + " terhubung ke Wifi: " + ssid);
    }

    @Override
    public void nyalakan() {
        setStatusMenyala(true);
        this.tingkatKecerahan = 100;
        System.out.println(getNamaPerangkat() + " dinyalakan. Kecerahan: " + this.tingkatKecerahan + "%");
    }

    @Override
    public void matikan() {
        setStatusMenyala(false);
        this.tingkatKecerahan = 0;
        System.out.println(getNamaPerangkat() + " dimatikan");
    }

    @Override
    public void prosesDataSensor(int cahayaSekitar) {
        System.out.println("\n[Sensor Cahaya mendeteksi nilai: " + cahayaSekitar + "]");
        if (cahayaSekitar < 30) {
            System.out.println("Kondisi gelap. Lampu otomatis menyala");
            nyalakan();
        } else {
            System.out.println("Kondisi cukup terang. Lampu otomatis mati");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kecerahan: " + this.tingkatKecerahan + "%");
    }
}
