# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data mahasiswa menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa spesifikasi motor jadul (merk, tahun keluaran, harga dasar, kondisi, dan status pajak), dan memberikan output berupa informasi detail motor beserta estimasi harga jual normal dan harga jual promo yang telah dikalkulasikan secara otomatis. Aplikasi ini juga dilengkapi fitur untuk mengupdate harga dasar motor di dalam garasi.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. Class adalah template atau blueprint dari object. Pada kode ini, Motor, MotorJadul, dan Main adalah contoh dari class.  


public class Motor {
    ...
}

public class MotorJadul extends Motor {
    ...
}

public class Main {
    ...
}

2. Object adalah instance dari class. Pada kode ini, new MotorJadul(...) adalah contoh pembuatan object yang langsung dimasukkan ke dalam array. 

gudang[jumlahMotor] = new MotorJadul(merk, tahun, harga, kondisi, pajak);

3. Atribut adalah variabel yang ada dalam class. Pada kode ini, merk, tahun, dan hargaBase adalah contoh atribut.  

private String merk;
private int tahun;
private double hargaBase;

4. Constructor adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class Motor dan MotorJadul.

public Motor(String merk, int tahun, double hargaBase) {
    this.merk = merk;
    this.tahun = tahun;
    this.hargaBase = hargaBase;
}

public MotorJadul(String merk, int tahun, double hargaBase, String kondisi, boolean pajakHidup) {
    super(merk, tahun, hargaBase);
    this.kondisi = kondisi;
    this.pajakHidup = pajakHidup;
}

5. Mutator atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, setHargaBase adalah contoh method mutator.

public void setHargaBase(double hargaBase) {
    this.hargaBase = hargaBase;
}

6. Accessor atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, getMerk, getTahun, dan getHargaBase adalah contoh method accessor.

public String getMerk() {
    return merk;
}

public double getHargaBase() {
    return hargaBase;
}

7. Encapsulation adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses atau diubah melalui method. Pada kode ini, atribut pada class Motor dienkapsulasi.

private String merk;
private int tahun;
private double hargaBase;

8. Inheritance adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, MotorJadul mewarisi Motor dengan sintaks extends.

public class MotorJadul extends Motor {
    ...
}

9. Polymorphism adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method hitungHargaJual(double persentaseDiskon) merupakan overloading dari method hitungHargaJual(), dan method tampilkanInfo() di MotorJadul merupakan override dari method tampilkanInfo() di class Motor.

// Overriding
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.printf("| %-10s | %-11s |\n", kondisi, (pajakHidup ? "Hidup" : "Mati/Telat"));
}

// Overloading
public double hitungHargaJual() { ... }
public double hitungHargaJual(double persentaseDiskon) { ... }

10. Seleksi adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi if else (untuk mengecek kondisi motor, ketersediaan array, dan kelengkapan pajak) serta seleksi switch (untuk navigasi menu utama).

if (kondisi.equalsIgnoreCase("Mulus")) {
    estimasi += 7000000;
} else if (kondisi.equalsIgnoreCase("Restorasi")) {
    estimasi += 4000000;
}

switch (pilihan) {
    case 1:
        // ...
        break;
    case 2:
        // ...
        break;
}

11. Perulangan adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop do-while untuk menahan menu agar terus tampil dan for untuk iterasi menampilkan data dari dalam array.

do {
    // Menampilkan Menu
} while (jalan);

for (int i = 0; i < jumlahMotor; i++) {
    gudang[i].tampilkanInfo(); 
}

12. Input Output Sederhana digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class Scanner untuk menerima input dan method System.out.println serta System.out.printf untuk menampilkan output.

Scanner input = new Scanner(System.in);
System.out.print("Merk Motor (Cth: Honda CB 100) : ");
String merk = input.nextLine();

System.out.printf("  > Est. Jual Normal : Rp %.0f\n", gudang[i].hitungHargaJual());

13. Array adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, MotorJadul[] gudang = new MotorJadul[10]; adalah contoh penggunaan array of objects.

MotorJadul[] gudang = new MotorJadul[10];

14. Error Handling digunakan untuk menangani error yang mungkin terjadi saat runtime (misal jika user menginputkan huruf pada kolom angka). Pada kode ini, digunakan try-catch dan throw new Exception untuk menangani error

try {
    int pilihan = input.nextInt();
    // ... code ...
    if (tahun < 1900 || tahun > 2024) throw new Exception("Tahun tidak masuk akal!");
} catch (InputMismatchException e) {
    System.out.println("\n[!] FATAL ERROR: Input yang Anda masukkan salah format!");
    input.nextLine();
} catch (Exception e) {
    System.out.println("\n[!] ERROR: " + e.getMessage());
}

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Muhammad Wildan
NPM: 2410010148
