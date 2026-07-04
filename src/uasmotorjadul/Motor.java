package uasmotorjadul;

// 1. CLASS: Blueprint dari entitas dasar Motor
public class Motor {
    
    // 3. ATRIBUT: Karakteristik yang dimiliki objek
    // 7. ENCAPSULATION: Menggunakan 'private' agar data aman dan tidak bisa diubah sembarangan
    private final String merk;
    private final int tahun;
    private double hargaBase;

    // 4. CONSTRUCTOR: Memberikan nilai awal saat objek diciptakan
    public Motor(String merk, int tahun, double hargaBase) {
        this.merk = merk;
        this.tahun = tahun;
        this.hargaBase = hargaBase;
    }

    // 6. ACCESSOR (GETTER): Method untuk mengambil nilai dari atribut private
    public String getMerk() {
        return merk;
    }

    public int getTahun() {
        return tahun;
    }

    public double getHargaBase() {
        return hargaBase;
    }

    // 5. MUTATOR (SETTER): Method untuk mengubah nilai atribut private dengan aman
    public void setHargaBase(double hargaBase) {
        this.hargaBase = hargaBase;
    }

    // Method ini akan ditimpa (override) di subclass
    public void tampilkanInfo() {
        // Menggunakan printf agar rapi seperti tabel
        System.out.printf("| %-20s | %-6d | Rp %-12.0f ", merk, tahun, hargaBase);
    }
}