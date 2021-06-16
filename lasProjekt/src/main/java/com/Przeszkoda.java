package com;

/**
 * Klasa: Przeszkoda
 * <p>
 * wersja: 1
 * <p>
 * edytor: Szymon Drogos
 * <p>
 * data: 19.05.2021
 * <p>
 * --------------------------------
 * <p>
 * wersja: 2
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 31.05.2021
 * <p>
 * opis zmian:  klasa dziedziczy po klasie Istniejace, w konstruktorze dodano przedstawjako=1
 * <p>
 * ------------------------------
 * <p>
 * wersja: 3
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 04.06.2021
 * <p>
 * zmiany powiazane: usuniecie zmiennej pozycja oraz metody getPozycja, patrz: Istniejace wersja 2
 * <p>
 * ------------------------------
 * <p>
 * wersja: 4
 * <p>
 * edytrzy: Arkadia Kowalczyk, Szymon Drogos
 * <p>
 * data: 08.06.2021
 * <p>
 * zmiana: decyzja o nie wykorzystywaniu przeszkody w naszym projekcie
 */


public class Przeszkoda extends Istniejace {


    public Przeszkoda(Pozycja poz, Mapa mapa) {
        super(mapa, poz);
        przedstawJako = 1;
    }

}
