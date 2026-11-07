public class Main {
    public static void main(String[] args) {
        System.out.println("SIMULASI SMART HOME\n");
        KendaliDaya lampuTeras = new LampuPintar("AA:BB:CC:DD:EE:11", "Lampu Teras Depan");
        KendaliDaya pintuUtama = new PintuPintar("AA:BB:CC:99:88:77", "Pintu Pintar Utama");
        PerangkatIoT acKamar = new SistemAC("FF:EE:DD:CC:BB:22");
        if (lampuTeras instanceof KoneksiJaringan) {
            ((KoneksiJaringan) lampuTeras).hubungkanWifi("Zidan_Network");
        }
        ((KoneksiJaringan) pintuUtama).hubungkanWifi("Zidan_Network");

        System.out.println("\nInfo Awal");
        ((PerangkatIoT) lampuTeras).tampilkanInfo();
        System.out.println();
        acKamar.tampilkanInfo();
        System.out.println();
        ((PerangkatIoT) pintuUtama).tampilkanInfo();
        System.out.println();

        System.out.println("Simulasi Sensor Bekerja (Logika State & Percabangan)");
        ((PerangkatIoT) lampuTeras).prosesDataSensor(15);
        ((PerangkatIoT) lampuTeras).prosesDataSensor(85);

        acKamar.prosesDataSensor(32);
        acKamar.prosesDataSensor(20);

        ((PerangkatIoT) pintuUtama).prosesDataSensor(10);
        ((PerangkatIoT) pintuUtama).prosesDataSensor(25);

        System.out.println("\nInfo Akhir");
        ((PerangkatIoT) lampuTeras).tampilkanInfo();
        System.out.println();
        acKamar.tampilkanInfo();
        System.out.println();
        ((PerangkatIoT) pintuUtama).tampilkanInfo();
    }
}
