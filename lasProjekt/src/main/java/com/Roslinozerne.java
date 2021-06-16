package com;

/**
 * Klasa: Roslinozerne
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
 * opis zmian: dodanie w konstruktorze przedstaw jako=7 (zwiazane z utworzeniem klasy Istniejace)
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
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 07.06.2021
 * <p>
 * opis zmian:  dodanie energiaMax w konstruktorze, zmiana daj potomka; dodanie coJem
 */


public class Roslinozerne extends Istota {


    public Roslinozerne(double energiaAdd, int posX, int posY, boolean czyTruje, int predkosc, double zuzycie, Mapa mapa, Dom dom, double energiaMax) {
        super(energiaAdd, posX, posY, czyTruje, predkosc, zuzycie, mapa, dom, energiaMax, 7);

        przedstawJako = 7;
    }

    @Override
    protected Istota dajPotomka(Pozycja kolyska, double maxi) {

        Roslinozerne a = new Roslinozerne(energiaAdd, kolyska.getPosX1(), kolyska.getPosY1(), this.czyTruje, this.predkosc, this.zuzycie, this.mapa, this.dom, maxi);
        return a;
    }

}
  
