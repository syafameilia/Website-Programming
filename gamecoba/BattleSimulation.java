import java.util.ArrayList; // Mengimpor kelas ArrayList untuk implementasi array dinamis
import java.util.List; // Mengimpor antarmuka List untuk keamanan tipe
import java.util.Random; // Mengimpor kelas Random untuk pembuatan angka acak

public class BattleSimulation { // Mendeklarasikan kelas BattleSimulation
    public static void main(String[] args) { // Metode utama di mana eksekusi program dimulai
        // Membuat karakter dengan nilai spesifik
        Hero arthur = new Hero("Arthur", 100, 20, 5); // Membuat objek Hero baru bernama Arthur dengan kesehatan 100, kekuatan 20, dan perisai 5
        Hero lancelot = new Hero("Lancelot", 90, 25, 3); // Membuat objek Hero baru bernama Lancelot dengan kesehatan 90, kekuatan 25, dan perisai 3
        Monster goblin = new Monster("Goblin",70, 15, 2); // Membuat objek Monster baru bernama Goblin dengan kesehatan 70, kekuatan 15, dan level 2
        Monster orc = new Monster("Orc", 80, 18, 3); // Membuat objek Monster baru bernama Orc dengan kesehatan 80, kekuatan 18, dan level 3

        // Monster mengamuk sebelum pertempuran
        goblin.enrage(); // Meningkatkan kekuatan Goblin sebesar level * 2
        orc.enrage(); // Meningkatkan kekuatan Orc sebesar level * 2

        // Menambahkan karakter ke dalam hutan
        List<Character> forest = new ArrayList<>(); // Membuat ArrayList kosong untuk menyimpan objek Character, bernama forest
        forest.add(arthur); // Menambahkan Hero Arthur ke dalam forest
        forest.add(lancelot); // Menambahkan Hero Lancelot ke dalam forest
        forest.add(goblin); // Menambahkan Monster Goblin ke dalam forest
        forest.add(orc); // Menambahkan Monster Orc ke dalam forest

        // Memulai pertempuran
        battle(forest); // Memanggil metode battle dengan daftar forest sebagai argumen
    }

    public static void battle(List<Character> characters) { // Mendefinisikan metode battle yang mengambil daftar objek Character sebagai argumen
        Random rand = new Random(); // Membuat objek Random untuk pembuatan angka acak

        while (characters.size() > 1) { // Melanjutkan loop selama ada lebih dari satu karakter dalam daftar
            // Memilih penyerang dan target secara acak
            int attackerIndex = rand.nextInt(characters.size()); // Memilih indeks acak untuk penyerang
            int targetIndex; // Mendeklarasikan variabel untuk indeks target
            do {
                targetIndex = rand.nextInt(characters.size()); // Memilih indeks acak untuk target
            } while (attackerIndex == targetIndex); // Memastikan bahwa penyerang dan target bukan karakter yang sama

            Character attacker = characters.get(attackerIndex); // Mendapatkan karakter penyerang dari daftar
            Character target = characters.get(targetIndex); // Mendapatkan karakter target dari daftar

            // Melakukan serangan
            System.out.println(attacker.getName() + " menyerang " + target.getName() + "!"); // Mencetak aksi serangan
            attacker.attack(target); // Memanggil metode attack pada penyerang, dengan target sebagai sasaran
            System.out.println(target.getName() + " memiliki " + target.getHealth() + " kesehatan tersisa."); // Mencetak sisa kesehatan target

            // Menghapus karakter yang mati
            if (!target.isAlive()) { // Memeriksa apakah target mati (kesehatan <= 0)
                System.out.println(target.getName() + " mati!"); // Mencetak bahwa target mati
                characters.remove(targetIndex); // Menghapus karakter yang mati dari daftar
            }

            System.out.println("----------------------------------"); // Mencetak garis pemisah untuk keterbacaan
        }

        // Menyatakan pemenang
        System.out.println(characters.get(0).getName() + " adalah pemenangnya dengan " + characters.get(0).getHealth() + " kesehatan tersisa!"); // Mencetak nama karakter terakhir yang tersisa sebagai pemenang dengan sisa kesehatannya
    }
}
