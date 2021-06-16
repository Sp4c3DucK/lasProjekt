package com;

import javax.swing.JFrame;

/**
 * Klasa: Mapa
 * <p>
 * wersja: 1
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 09.05.2021
 * <p>
 * opis:    zmienne wymiarX, wymiarY, tablica; konstruktor ze wspomnianymi zmiennymi; metody getX getY oraz
 * TuJest - zwraca obiekt klasy Object o danych współrzednych; pusta metoda rysuj
 * <p>
 * ------------------------------
 * <p>
 * wersja: 2
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 30.05.2021
 * <p>
 * opis zmian:  dodanie zmiennych s, pierwszy X, pierwszyY, frame. to mapa rysuje plansze a nie main;
 * <p>
 * dodana metoda setOnMap, praca nad metoda rysuj; TuJest zwraca obiket klasy Istniejace a nie Object;
 * <p>
 * ------------------------------
 * <p>
 * wersja: 3
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 1.06.2021
 * <p>
 * opis zmian:  usniecie metody rysuj, metoda setOnMap już nie rysuje; dodanie testów; testy nie zawsze przechodza
 * - obiekty nie zawsze sie rysuja, nie wiem czemu;
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 4
 * <p>
 * edytor: Szymon Drogos, Arkadia Kowalczyk, Maciej Dziewisz
 * <p>
 * data: 06.06.2021
 * <p>
 * opis zmian: dodanie metody delete; dodanie plansza.repaint w metodzie setOnMap;
 */

public class Mapa {
    private final int wymiarX;
    private final int wymiarY;
    public Istniejace[][] tablica;
    private int s, pierwszyX, pierwszyY;
    JFrame frame;
    Plansza plansza;


    public Mapa(int wymiarX, int wymiarY, int s, int pierwszyX, int pierwszyY) {
        this.wymiarX = wymiarX;
        this.wymiarY = wymiarY;
        this.s = s;
        this.pierwszyX = pierwszyX;
        this.pierwszyY = pierwszyY;
        tablica = new Istniejace[wymiarX + 1][wymiarY + 1];

        //stworz okienko
        this.frame = new JFrame("Symulator przetrwania");
        frame.setSize(700, 700);
        this.plansza = new Plansza(s, pierwszyX, pierwszyY, wymiarX, wymiarY, this);

        //narysuj w okienku
        frame.add(plansza);
        frame.setVisible(true);
    }

    public Istniejace tuJest(Pozycja pos) {
        return tablica[pos.getPosX1()][pos.getPosY1()];
    }

    public int getX() {
        return wymiarX;
    }

    public int getY() {
        return wymiarY;
    }

    public void setOnMap(Pozycja pos, Istniejace ist) {
        int x1 = pos.getPosX1();
        int x2 = pos.getPosX2();
        int y1 = pos.getPosY1();
        int y2 = pos.getPosY2();

        for (; x1 <= x2; x1++) {
            for (int wys = y1; wys <= y2; wys++) {
                tablica[x1][wys] = ist;
            }
        }

        //odswiez okienko
        plansza.repaint();
    }

    public void delete(Pozycja pos) {
        int x1 = pos.getPosX1();
        int x2 = pos.getPosX2();
        int y1 = pos.getPosY1();
        int y2 = pos.getPosY2();

        for (; x1 <= x2; x1++) {
            for (int wys = y1; wys <= y2; wys++) {
                tablica[x1][wys] = null;
            }
        }

        //odswiez okienko
        plansza.repaint();
    }

}
