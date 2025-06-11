public class Monster extends Character { // Mendeklarasikan kelas Monster yang merupakan subclass dari Character
    protected int level; // Mendeklarasikan variabel level yang dilindungi

    // Konstruktor dari kelas Monster
    public Monster(String name, int health, int strength, int level) {
        super(name, health, strength); // Memanggil konstruktor dari kelas induk Character
        this.level = level; // Menginisialisasi variabel level dengan nilai yang diberikan
    }

    public void enrage() { // Metode untuk meningkatkan kekuatan monster
        strength += level * 2; // Menambahkan kekuatan dengan perhitungan level * 2
    }
}

