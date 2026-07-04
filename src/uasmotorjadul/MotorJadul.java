package uasmotorjadul;

// 8. INHERITANCE: Kata kunci 'extends' membuat MotorJadul mewarisi sifat Motor
public class MotorJadul extends Motor {
    
    private final String kondisi; // Contoh: Mulus, Restorasi, Bahan
   private final boolean pajakHidup;

    public MotorJadul(String merk, int tahun, double hargaBase, String kondisi, boolean pajakHidup) {
        super(merk, tahun, hargaBase); // Memanggil constructor dari Superclass
        this.kondisi = kondisi;
        this.pajakHidup = pajakHidup;
    }

    // 9. POLYMORPHISM (OVERRIDING): Menimpa perilaku method dari superclass
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil cetakan tabel dari superclass
        System.out.printf("| %-10s | %-11s |\n", kondisi, (pajakHidup ? "Hidup" : "Mati/Telat"));
    }

    // 9. POLYMORPHISM (OVERLOADING - Versi 1): Method hitung harga normal
    public double hitungHargaJual() {
        double estimasi = super.getHargaBase();
        
        // Logika penambahan nilai berdasarkan kondisi
        if (kondisi.equalsIgnoreCase("Mulus")) {
            estimasi += 7000000;
        } else if (kondisi.equalsIgnoreCase("Restorasi")) {
            estimasi += 4000000;
        }

        // Logika pajak
        if (pajakHidup) {
            estimasi += 1500000;
        } else {
            estimasi -= 2000000; // Harga jatuh jika pajak mati
        }
        
        return estimasi;
    }

    // 9. POLYMORPHISM (OVERLOADING - Versi 2): Method hitung harga dengan parameter diskon (persentase)
    public double hitungHargaJual(double persentaseDiskon) {
        double hargaNormal = hitungHargaJual();
        double potongan = hargaNormal * (persentaseDiskon / 100);
        return hargaNormal - potongan;
    }
}