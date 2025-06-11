public class Character { // Mendeklarasikan kelas Character
    protected String name; // Mendeklarasikan variabel name yang dilindungi
    protected int health; // Mendeklarasikan variabel health yang dilindungi
    protected int strength; // Mendeklarasikan variabel strength yang dilindungi

    public Character(String name, int health, int strength) { // Konstruktor dari kelas Character
        this.name = name; // Menginisialisasi variabel name dengan nilai yang diberikan
        this.health = health; // Menginisialisasi variabel health dengan nilai yang diberikan
        this.strength = strength; // Menginisialisasi variabel strength dengan nilai yang diberikan
    }

    public void attack(Character target) { // Metode untuk menyerang karakter lain
        target.takeDamage(strength); // Memanggil metode takeDamage pada target dengan kekuatan penyerang
    }

    public void takeDamage(int damage) { // Metode untuk menerima kerusakan
        health -= damage; // Mengurangi health dengan nilai kerusakan
        if (health < 0) health = 0; // Jika health menjadi negatif, setel menjadi 0
    }

    public boolean isAlive() { // Metode untuk memeriksa apakah karakter masih hidup
        return health > 0; // Mengembalikan true jika health lebih besar dari 0, sebaliknya false
    }

    public String getName() { // Metode untuk mendapatkan nama karakter
        return name; // Mengembalikan nilai name
    }

    public int getHealth() { // Metode untuk mendapatkan health karakter
        return health; // Mengembalikan nilai health
    }
}
