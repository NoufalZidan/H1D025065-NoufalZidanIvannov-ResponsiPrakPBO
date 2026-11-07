public class PintuPintar extends PerangkatIoT implements KoneksiJaringan, KendaliDaya {
    private boolean isTerkunci;

    public PintuPintar(String macAddress, String namaPerangkat) {
        super(macAddress, namaPerangkat);
        this.isTerkunci = true;
        setStatusMenyala(true);
    }

    @Override
    public void hubungkanWifi(String ssid) {
        System.out.println(getNamaPerangkat() + " terhubung ke Wifi: " + ssid);
    }

    @Override
    public void nyalakan() {
        setStatusMenyala(true);
        this.isTerkunci = true;
        System.out.println(getNamaPerangkat() + " sistem aktif. Pintu terkunci.");
    }

    @Override
    public void matikan() {
        setStatusMenyala(false);
        this.isTerkunci = false;
        System.out.println(getNamaPerangkat() + " sistem nonaktif. Pintu terbuka.");
    }

    @Override
    public void prosesDataSensor(int jarakOrangCm) {
        System.out.println("\n[Sensor Jarak mendeteksi pergerakan pada jarak: " + jarakOrangCm + " cm]");
        if (jarakOrangCm <= 15) {
            System.out.println("Ada orang terdeteksi sangat dekat. Membuka kunci...");
            matikan();
        } else {
            System.out.println("Tidak ada orang di dekat pintu. Mengamankan pintu...");
            nyalakan();
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Status Pintu: " + (this.isTerkunci ? "TERKUNCI" : "TERBUKA"));
    }
}