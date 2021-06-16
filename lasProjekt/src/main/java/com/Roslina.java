package com;

/**
 * Klasa: Roslina
 * <p>
 * wersja: 1
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 09.05.2021
 * <p>
 * ------------------------------
 * <p>
 * wersja: 2
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 31.05.2021
 * <p>
 * opis zmian: dodanie w konstruktorze przedstaw jako=5 (zwiazane z utworzeniem klasy Istniejace)
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 3
 * <p>
 * edytor: Szymon Drogos, Arkadia Kowalczyk, Maciej Dziewisz
 * <p>
 * data: 06.06.2021
 * <p>
 * opis zmian: usuniecie z konstruktora czyZyje;
 */


public class Roslina extends Jadalne {

    private static int ileZyje = 0;

    public Roslina(double energiaAdd, int posX, int posY, Mapa mapa) {
        super(energiaAdd, posX, posY, mapa);
        ileZyje++;
        przedstawJako = 5;
    }

    public static int getIleZyje() {
        return ileZyje;
    }


    @Override
    protected void umiera() {
        super.umiera();
        ileZyje--;
    }
}
