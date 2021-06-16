package com;

import java.util.LinkedList;
import java.util.List;


/**
 * Klasa: Dom
 * <p>
 * wersja: 1
 * <p>
 * edytor: Szymon Drogos
 * <p>
 * data: 19.05.2021
 * <p>
 * --------------------------------
 * <p>
 * wersja:2
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 04.06.2021
 * <p>
 * opis zmian:  zaimplementowanie getPozycja, getIleIstot, getTuMieszka, nowyDomownik, ktosUmarl;
 * dodanie listy kto tu mieszka
 * usuniecie zmiennej dlugosc listy
 * napisanie testu DomTest
 * <p>
 * zmiana powiazana:    usuniecie zmiennej pozycja i metody getPozycja, dodanie w konstruktorze przedstawJako=2
 * patrz: Istniejace wersja 2
 * <p>
 * --------------------------------
 * <p>
 * wersja: 3
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 07.06.2021
 * <p>
 * opis zmian: dodanie setKtoryWDomu w metodzie ktosUmarl, dodanie nazwy domu, dodanie komunikatu gdy wszyscy w domu umra
 */

public class Dom extends Istniejace {
    private List<Istota> ktotumieszka;
    private int ileIstot = 0;
    private final String nazwa;

    public Dom(Pozycja poz, String nazwa, Mapa mapa) {
        super(mapa, poz);
        ktotumieszka = new LinkedList<>();
        this.nazwa = nazwa;

        przedstawJako = 2;
    }

    public void nowyDomownik(Istota a) {

        ileIstot++;
        ktotumieszka.add(a);

    }

    public void ktosUmarl(Istota a) {

        ileIstot--;
        ktotumieszka.remove(a);

        for (int i = 0; i < ktotumieszka.size(); i++) ktotumieszka.get(i).setKtoryWDomu(i + 1);

        if (ileIstot == 0) System.out.println("\nDom o nazwie " + nazwa + " stoi pusty.");

    }

    public int getIleIstot() {
        return ileIstot;
    }

    public Istota getTuMieszka(int a) {

        if (a < 0 || a >= ileIstot) return null;
        return ktotumieszka.get(a);

    }
}
