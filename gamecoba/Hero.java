public class Hero extends Character { // Mendeklarasikan kelas Hero yang merupakan subclass dari Character
    protected int shield; // Mendeklarasikan variabel shield yang dilindungi

    // Konstruktor dari kelas Hero
    public Hero(String name, int health, int strength, int shield) {
        super(name, health, strength); // Memanggil konstruktor dari kelas induk Character
        this.shield = shield; // Menginisialisasi variabel shield dengan nilai yang diberikan
    }

    @Override
    public void takeDamage(int damage) { // Menimpa metode takeDamage dari kelas induk
        int reducedDamage = damage - shield; // Menghitung kerusakan yang dikurangi dengan nilai shield
        if (reducedDamage < 0) reducedDamage = 0; // Jika kerusakan yang dikurangi menjadi negatif, setel menjadi 0
        super.takeDamage(reducedDamage); // Memanggil metode takeDamage dari kelas induk dengan kerusakan yang dikurangi
    }
}
