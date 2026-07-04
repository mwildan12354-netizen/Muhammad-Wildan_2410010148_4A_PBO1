package uasmotorjadul;

// Import library yang dibutuhkan
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        
        // 13. ARRAY: Tempat penyimpanan data menggunakan array of objects (Maksimal 10)
        try ( // 12. IO SEDERHANA: Scanner untuk menerima inputan keyboard
                Scanner input = new Scanner(System.in)) {
            // 13. ARRAY: Tempat penyimpanan data menggunakan array of objects (Maksimal 10)
            MotorJadul[] gudang = new MotorJadul[10];
            int jumlahMotor = 0;
            boolean jalan = true;
            
            // 11. PERULANGAN: Loop Do-While untuk menu utama aplikasi
            do {
                System.out.println("\n=======================================================");
                System.out.println("||        GARASI KLASIK - SISTEM MOTOR JADUL         ||");
                System.out.println("=======================================================");
                System.out.println("1. Tambah Koleksi Motor Baru");
                System.out.println("2. Tampilkan Daftar Motor & Estimasi Harga");
                System.out.println("3. Update Harga Dasar (Gunakan Mutator)");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu [1-4]: ");
                
                // 14. ERROR HANDLING: Melindungi program dari input user yang sembarangan
                try {
                    int pilihan = input.nextInt();
                    input.nextLine(); // Bersihkan sisa enter/newline
                    
                    // 10. SELEKSI: Switch-case untuk navigasi menu
                    switch (pilihan) {
                        case 1:
                            if (jumlahMotor < gudang.length) {
                                System.out.println("\n--- INPUT DATA MOTOR JADUL ---");
                                System.out.print("Merk Motor (Cth: Honda CB 100) : ");
                                String merk = input.nextLine();
                                
                                System.out.print("Tahun Keluaran                 : ");
                                int tahun = input.nextInt();
                                if (tahun < 1900 || tahun > 2024) throw new Exception("Tahun tidak masuk akal!");
                                
                                System.out.print("Harga Beli/Modal Dasar (Rp)    : ");
                                double harga = input.nextDouble();
                                input.nextLine();
                                
                                System.out.print("Kondisi (Mulus/Restorasi/Bahan): ");
                                String kondisi = input.nextLine();
                                
                                System.out.print("Pajak Hidup? (true/false)      : ");
                                boolean pajak = input.nextBoolean();
                                
                                // 2. OBJECT: Proses instansiasi pembuatan objek baru
                                gudang[jumlahMotor] = new MotorJadul(merk, tahun, harga, kondisi, pajak);
                                jumlahMotor++;
                                
                                System.out.println("\n[!] SUCCESS: Data motor berhasil masuk ke garasi.");
                            } else {
                                System.out.println("\n[!] FAILED: Kapasitas garasi penuh!");
                            }
                            break;
                            
                        case 2:
                            System.out.println("\n=======================================================================================");
                            System.out.println("| MERK MOTOR           | TAHUN  | HARGA DASAR      | KONDISI    | PAJAK       |");
                            System.out.println("=======================================================================================");
                            
                            if (jumlahMotor == 0) {
                                System.out.println("|                       GARASI MASIH KOSONG BELUM ADA DATA                            |");
                            } else {
                                // 11. PERULANGAN: Looping For untuk membaca seluruh isi Array
                                for (int i = 0; i < jumlahMotor; i++) {
                                    // Memanggil Override Method
                                    gudang[i].tampilkanInfo();
                                    
                                    // Memanggil Overloading Method
                                    System.out.printf("  > Est. Jual Normal : Rp %.0f\n", gudang[i].hitungHargaJual());
                                    System.out.printf("  > Jual Promo (10%%) : Rp %.0f\n", gudang[i].hitungHargaJual(10.0));
                                    System.out.println("---------------------------------------------------------------------------------------");
                                }
                            }
                            break;
                            
                        case 3:
                            // 10. SELEKSI: Validasi menggunakan IF
                            if (jumlahMotor == 0) {
                                System.out.println("\n[!] Garasi kosong, tidak ada harga yang bisa diubah.");
                            } else {
                                System.out.print("\nMasukkan indeks motor yang ingin diubah (1 - " + jumlahMotor + "): ");
                                int index = input.nextInt() - 1; // Dikurangi 1 karena array mulai dari 0
                                
                                if (index >= 0 && index < jumlahMotor) {
                                    System.out.print("Masukkan Harga Dasar Baru (Rp): ");
                                    double hargaBaru = input.nextDouble();
                                    
                                    // IMPLEMENTASI PENILAIAN NOMOR 5 (MUTATOR / SETTER)
                                    gudang[index].setHargaBase(hargaBaru);
                                    System.out.println("[!] SUCCESS: Harga dasar berhasil diupdate!");
                                } else {
                                    System.out.println("[!] ERROR: Indeks motor tidak ditemukan!");
                                }
                            }
                            break;
                            
                        case 4:
                            jalan = false;
                            System.out.println("\nMenutup Sistem Garasi Klasik. Terima Kasih!");
                            break;
                            
                        default:
                            System.out.println("\n[!] ERROR: Pilihan menu tidak valid!");
                            break;
                    }
                    
                } catch (InputMismatchException e) {
                    System.out.println("\n[!] FATAL ERROR: Input yang Anda masukkan salah format (harus angka/boolean)!");
                    input.nextLine(); // Membersihkan sampah inputan (wajib agar tidak error looping terus menerus)
                } catch (Exception e) {
                    System.out.println("\n[!] ERROR: " + e.getMessage());
                }
            } while (jalan);
        }
    }
}