package com;

/**
 * Klasa: Miesozerne
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
 * opis zmian: dodanie w konstruktorze przedstaw jako=8 (zwiazane z utworzeniem klasy Istniejace)
 * <p>
 * ------------------------------
 * <p>
 * wersja: 3
 * <p>
 * edytor: Szymon Drogos
 * <p>
 * data: 05.06.2021
 * <p>
 * opis zmian: dodanie metody rodzi
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 4
 * <p>
 * edytor: Szymon Drogos, Arkadia Kowalczyk, Maciej Dziewisz
 * <p>
 * data: 06.06.2021
 * <p>
 * opis zmian: usuniecie z konstruktora czyZyje, dodanie do konstruktora dom;
 * usuniecie metody Rodzi zamiast tego metoda dajPotomka;
 * <p>
 * ------------------------------
 * <p>
 * wersja: 5
 * <p>
 * edytor: Maciej Dziewisz
 * <p>
 * data: 07.06.2021
 * <p>
 * opis zmian:
 * (MD) Zmiana estetyczna-zadbanie aby metody zaczynały się z małej litery;
 * <p>
 * (AK)    dodanie energiaMax w konstruktorze, zmiana daj potomka; coJem w konstruktorze super
 */

public class Miesozerne extends Istota {

    public Miesozerne(double energiaAdd, int posX, int posY, boolean czyTruje, int predkosc, double zuzycie, Mapa mapa, Dom dom, double energiaMax) {
        super(energiaAdd, posX, posY, czyTruje, predkosc, zuzycie, mapa, dom, energiaMax, 8);
        przedstawJako = 8;
    }

    public static int getIleZyje() {
        return ileZyje;
    }

    @Override
    protected Istota dajPotomka(Pozycja kolyska, double maxi) {
        return new Miesozerne(energiaAdd, kolyska.getPosX1(), kolyska.getPosY1(), this.czyTruje, this.predkosc, this.zuzycie, this.mapa, this.dom, maxi);
    }

}
  
