package com;

/**
 * Klasa: Jadalne
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
 * opis zmian:  klasa dziedziczy po klasie Istniejace
 * <p>
 * ------------------------------
 * <p>
 * wersja: 3
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 04.06.2021
 * <p>
 * zmiany: dodanie argumentu killer w metodzie jestZjadane, implementacja metody jest zjadane, dodanie czytruje
 * czyZyje nie jest argumentem konstruktora
 * <p>
 * zmiany powiazane:    usuniecie zmiennej pozycja oraz metody getPozycja, patrz: Istniejace wersja 2
 * zmiany w klasach dziedziczących związane z klasą jestZjadane
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 4
 * <p>
 * edytor: Szymon Drogos, Arkadia Kowalczyk, Maciej Dziewisz
 * <p>
 * data: 06.06.2021
 * <p>
 * opis zmian: dodanie mapa; zmiana w metodzie umiera  dodanie mapa.delete;
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 5
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 08-09.06.2021
 * <p>
 * opis zmian: wprowadzenie komunikatów gdy umiera; czyszczenie mapy, ale tylko wtedy gdy jest to potrzebne
 */

public abstract class Jadalne extends Istniejace {
    protected double energiaAdd;
    protected boolean czyZyje;
    protected boolean czyTruje;

    public Jadalne(double energiaAdd, int posX, int posY, Mapa mapa) {
        super(mapa, new Pozycja(posX, posY));
        this.energiaAdd = energiaAdd;
        this.czyZyje = true;

    }

    protected void umiera() {
        System.out.println("\numieram :c " + this);
        czyZyje = false;

        if (mapa.tuJest(pozycja) == this) {
            mapa.delete(pozycja);
        }

        pozycja = null;

    }

    public double getEnergiaAdd() {
        return energiaAdd;
    }

    public void jestZjadane(Istota killer) {
        System.out.println("\nJestem zjadane: " + this + " oddaje tyle energii: " + energiaAdd);
        umiera();

        if (czyTruje) killer.dostalTrucizne(energiaAdd);
        else killer.setEnergia(killer.getEnergia() + energiaAdd);
    }
}
