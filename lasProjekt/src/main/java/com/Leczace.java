package com;

/**
 * Klasa: Leczace
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
 * opis zmian: dodanie w konstruktorze przedstaw jako=3 (zwiazane z utworzeniem klasy Istniejace)
 * <p>
 * ------------------------------
 * <p>
 * wersja: 3
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 04.06.2021
 * <p>
 * opis zmian: zaimplementowanie jest zjadane
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 4
 * <p>
 * edytor: Szymon Drogos, Arkadia Kowalczyk, Maciej Dziewisz
 * <p>
 * data: 06.06.2021
 * <p>
 * opis zmian: usuniecie z konstruktora czyZyje, dodanie mapa;
 */

public class Leczace extends Roslina {

    private static int ileZyje = 0;

    public Leczace(double energiaAdd, int posX, int posY, Mapa mapa) {
        super(energiaAdd, posX, posY, mapa);
        ileZyje++;
        czyZyje = true;

        //przedstawJako=3;
    }

    public static int getIleZyje() {
        return ileZyje;
    }

    @Override
    public void jestZjadane(Istota killer) {
        super.jestZjadane(killer);
        killer.dostalLek();
    }

}
