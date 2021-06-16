package com;

/**
 * Klasa: Trujace
 * <p>
 * wersja: 1
 * <p>
 * edytor: Maciej Dziewisz
 * <p>
 * data: 19.05.2021
 * <p>
 * ------------------------------
 * <p>
 * wersja: 2
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 31.05.2021
 * <p>
 * opis zmian: dodanie w konstruktorze przedstaw jako=4 (zwiazane z utworzeniem klasy Istniejace)
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

public class Trujace extends Jadalne {

    private static int ileZyje = 0;

    public Trujace(double energiaAdd, int posX, int posY, Mapa mapa) {
        super(energiaAdd, posX, posY, mapa);
        ileZyje++;
        czyZyje = true;
        przedstawJako = 4;
        czyTruje = true;
    }

    public static int getIleZyje() {
        return ileZyje;
    }


}
