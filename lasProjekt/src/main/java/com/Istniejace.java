package com;

/**
 * Klasa: Istniejace
 * <p>
 * wersja: 1
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 31.05.2021
 * <p>
 * opis: zmienna przedstaw jako oraz zaimplementowana metoda getPrzedstaw
 * <p>
 * --------------------------------
 * <p>
 * wersja: 2
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 04.06.2021
 * <p>
 * opis zmian: dodalam zmienna pozycja, dodalam i zaimplementowalam getPozycja; dodalam zmienna mapa;
 * <p>
 * zmiany powiazane: usunelam z klas potomnych (Jadalne, Dom, Przeszkoda) zmienne pozycja i metody getPozycja;
 * <p>
 * uwaga:   nie ma setPozycja ponieważ w naszej symulacji nie ma przesuwania obiektow, to obiekt sam decyduje czy chce
 * zmienic pozycje, i moze to zrobic poprzez interakcje ze zmienna pozycja
 * <p>
 * --------------------------------
 * <p>
 * wersja: 3
 * <p>
 * edytor: Arkadia Kowalczyk, Szymon Drogos
 * <p>
 * opis zmian: dodanie setOnMap do konstruktora
 */

public abstract class Istniejace {
    protected int przedstawJako;
    protected Pozycja pozycja;
    protected Mapa mapa;

    public Istniejace(Mapa mapa, Pozycja pozycja) {
        this.mapa = mapa;
        this.pozycja = pozycja;
        mapa.setOnMap(pozycja, this);

    }

    public int getPrzedstaw() {
        return przedstawJako;
    }

    public Pozycja getPozycja() {
        return pozycja;
    }

    public void setPrzedstawJako(int przedstawJako) {
        this.przedstawJako = przedstawJako;
    }
}