package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main
 * <p>
 * wersja: 1
 * <p>
 * edytor: Szymon Drogos
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
 * opis zmian:  inicjalizacja mapy o parametrach ustalonych odgórnie
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 3
 * <p>
 * edytor: Szymon Drogos
 * <p>
 * data: 06.06.2021
 * <p>
 * opis zmian: wykomentowanie czesci z tworzeniem mapy; dodanie czesci potrzebnej do bfs
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 4
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 06.06.2021
 * <p>
 * opis zmian: dodanie szkieletu cyklu dnia, dodanie metod nocne aktywnosci i rusz istoty
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 5
 * <p>
 * edytor: Arkadia i Szymon
 * <p>
 * data: 08.06.2021
 * <p>
 * opis zmian: statyczna zmienna ileRoslin, zmienne ilepierwotnie roslinozernych itd, dodanie tworzenia istot
 * wiadomosc koncowa, dodanie metody zasiej
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 6
 * <p>
 * edytoer: Arkadia Kowalczyk:
 * <p>
 * data: 08 - 09.06.2021
 * <p>
 * opis zmian:
 * dodanie statycznych pozycji domów, dodanie statycznej pozycji losowej,
 * <p>
 * main: pozycje istot sa losowane za pomoca funkcj losujpozycje, odkomentowanie nocneAktywnosci
 * <p>
 * ruszIstoty: dodanie komunikatu by wiadomo było że to kolejna istota sie rusza
 * <p>
 * zasiej: nie losujemy jaka roslina sie zasieje, losujemy pozycje za pomoca metody losuj pozycje
 * <p>
 * losuj pozycje: losujemy pozycje tak, aby nie znalazla sie ona w domu
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 7
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 11.06.2021
 * <p>
 * opis zmian: losowa pozycja losuje tylko te pozycje, które na mapie sa jeszcze nie zajete, edycja komunikatów
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 8
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 12.06.2021
 * <p>
 * opis zmian: dodanie zapisu do pliku; wyeliminowanie błędu ktory sprawial, ze jesli np istota 3 umierala to istota 4
 * nie wykonywala ruchu (bo stawala sie nowa 3ka, a ruch wykonywala nowa 4ka czyli dawna 5tka)
 * rozmieszczenie domow/ilosc roslin mozna zmieniac i nie martwic sie, ze wyjda poza mape
 * <p>
 * ------------------------------
 * <p>
 * Wersja: 9
 * <p>
 * edytor: Maciej Dziewisz
 * <p>
 * data: 13.06.2021
 * <p>
 * opis zmian: po odpaleniu programu w konsoli użytkownik teraz może wybierać sobie ilość dni przez jaką będzie symulacja się dobywać,
 * ilość istot każdego gatunku z osobna, zmniejszona zostala ilosc roslin generowanych kazdego dnia o polowe.
 */


public class Main {

    //informacje o wielkosci naszej mapy i gdzie ma sie wyswietlac; kolumny i wiersze mozna zmieniac, ale powinny byc 10 lub wiecej
    static int scianka = 30, pierwszyX = 23, pierwszyY = 37, kolumny = 12, wiersze = 13;
    static Mapa mapa = new Mapa(kolumny, wiersze, scianka, pierwszyX, pierwszyY);

    //gdzie są domy, zmienna x w x*kolumny; x*wiersze powinna być miedzy 1 a 10
    static int rx1 = (1 * kolumny) / 10, rx2 = (1 * kolumny) / 10, ry1 = (1 * wiersze) / 10, ry2 = (1 * wiersze) / 10;
    static int wx1 = (3 * kolumny) / 10, wx2 = (4 * kolumny) / 10, wy1 = (5 * wiersze) / 10, wy2 = (7 * wiersze) / 10;
    static int mx1 = (9 * kolumny) / 10, mx2 = (10 * kolumny) / 10, my1 = (9 * wiersze) / 10, my2 = (10 * wiersze) / 10;


    static Pozycja domRP = new Pozycja(rx1, rx2, ry1, ry2);
    static Pozycja domWP = new Pozycja(wx1, wx2, wy1, wy2);
    static Pozycja domMP = new Pozycja(mx1, mx2, my1, my2);

    static Dom domR = new Dom(domRP, "Roslinozerne", mapa);
    static Dom domW = new Dom(domWP, "Wszystkozerne", mapa);
    static Dom domM = new Dom(domMP, "Miesozerne", mapa);

    static int ileRoslin = (15 * kolumny * wiersze) / 100;   //zamiast 15 bylo 30

    static Pozycja losowa = new Pozycja(0, 0);

    static FileWriter plik = null;

    static int nrDnia = 0;

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);

        //to mozna zmieniac
        System.out.println("\n Prosze podac ileDniDziala: ");
        int ileDniDziala = scanner.nextInt();                           //=5;
        System.out.println("\n Prosze podac ilePRoslinozernych: ");
        int ilePRoslinozernych = scanner.nextInt();                     //=20;
        System.out.println("\n Prosze podac ilePWszystkozernych: ");
        int ilePWszystkozernych = scanner.nextInt();                    //=5;
        System.out.println("\n Prosze podac ilePMiesozernych: ");
        int ilePMiesozernych = scanner.nextInt();                       //=5;


        //stworz istoty

        for (int i = 0; i < ilePRoslinozernych; i++) {
            Random rand = new Random();
            boolean tox = rand.nextBoolean();
            losujPozycje();
            System.out.println("Pozycja roslinozernego: " + losowa.getPosX1() + losowa.getPosY1());
            new Roslinozerne((double) Math.floor(Math.random() * (25 - 5 + 1) + 5), losowa.getPosX1(), losowa.getPosY1(), tox, (int) Math.floor(Math.random() * (5 - 1 + 1) + 1), (int) Math.floor(Math.random() * (5 - 1 + 1) + 1), mapa, domR, 1000);
        }
        for (int i = 0; i < ilePWszystkozernych; i++) {
            Random rand = new Random();
            boolean tox = rand.nextBoolean();
            losujPozycje();
            System.out.println("Pozycja wszystkozernego: " + losowa.getPosX1() + losowa.getPosY1());
            new Wszystkozerne((double) Math.floor(Math.random() * (25 - 5 + 1) + 5), losowa.getPosX1(), losowa.getPosY1(), tox, (int) Math.floor(Math.random() * (5 - 1 + 1) + 1), (int) Math.floor(Math.random() * (5 - 1 + 1) + 1), mapa, domW, 5000);
        }
        for (int i = 0; i < ilePMiesozernych; i++) {
            Random rand = new Random();
            boolean tox = rand.nextBoolean();
            losujPozycje();
            System.out.println("Pozycja miesoozernego: " + losowa.getPosX1() + losowa.getPosY1());
            new Miesozerne((double) Math.floor(Math.random() * (25 - 5 + 1) + 5), losowa.getPosX1(), losowa.getPosY1(), tox, (int) Math.floor(Math.random() * (5 - 1 + 1) + 1), (int) Math.floor(Math.random() * (5 - 1 + 1) + 1), mapa, domM, 1000);
        }

        try {
            plik = new FileWriter("historia.txt");
            plik.write("\nSymulacja lasu. Statystyki\n");
        } finally {
            if (plik != null) {
                plik.close();
            }
        }


        while (nrDnia < ileDniDziala) {

            //Dzien:
            nrDnia++;
            System.out.println("Dzien: " + nrDnia);
            statystyki();

            //1) utworz rosliny
            zasiej();

            //2) ranek - ruszIstoty
            ruszIstoty();
            //3) popoludnie
            ruszIstoty();
            //4) wieczor - j.w
            ruszIstoty();

            //5) noc - rodzą lub giną czyli nocne aktywnosci
            nocneAktywnosci();

        }


        System.out.println("Koniec Symulacji. Statystki: \n");
        System.out.println("Dane poczatkowe: \n \t roslinozernych istot bylo: " + ilePRoslinozernych +
                "\n \t wszystkozernych istot bylo: " + ilePWszystkozernych +
                "\n \t miesozernych istot bylo: " + ilePMiesozernych);

        System.out.println("\nDane koncowe:   \n \t roslinozernych istot jest: " + domR.getIleIstot() +
                "\n \t wszystkozernych istot jest: " + domW.getIleIstot() +
                "\n \t miesozernych istot jest: " + domM.getIleIstot());


    }

    private static void ruszIstoty() {


        System.out.println("Ruch roslin");
        for (int i = 0; i < domR.getIleIstot(); i++) {
            domR.getTuMieszka(i).setCzyRuszone(false);
        }
        for (int i = 0; i < domR.getIleIstot(); ) {
            System.out.println("\nRuch roslin " + i);
            domR.getTuMieszka(i).turaDzienna();
            if (domR.getTuMieszka(i).isCzyRuszone()) i++;
        }

        System.out.println("\nRuch wszysrtko");
        for (int i = 0; i < domW.getIleIstot(); i++) {
            domW.getTuMieszka(i).setCzyRuszone(false);
        }
        for (int i = 0; i < domW.getIleIstot(); ) {


            System.out.println("\nRuch wszysrtko " + i);
            domW.getTuMieszka(i).turaDzienna();
            if (domW.getTuMieszka(i).isCzyRuszone()) i++;
        }

        System.out.println("\nRuch mieso");
        for (int i = 0; i < domM.getIleIstot(); i++) {
            domM.getTuMieszka(i).setCzyRuszone(false);
        }
        for (int i = 0; i < domM.getIleIstot(); ) {

            System.out.println("\nRuch mieso " + i);
            domM.getTuMieszka(i).turaDzienna();
            if (domM.getTuMieszka(i).isCzyRuszone()) i++;
        }
    }

    private static void nocneAktywnosci() {

        System.out.println("\nZAPADLA NOC");

        System.out.println("\nnoc roslinozernych");
        for (int i = 0; i < domR.getIleIstot(); i++) {
            domR.getTuMieszka(i).setCzyRuszone(false);
        }
        for (int i = 0; i < domR.getIleIstot(); ) {
            System.out.println("\nRuch roslin " + i);
            domR.getTuMieszka(i).nocneAktywnosci();
            if (domR.getTuMieszka(i).isCzyRuszone()) i++;
        }

        System.out.println("\nnoc wszystkozernych");
        for (int i = 0; i < domW.getIleIstot(); i++) {
            domW.getTuMieszka(i).setCzyRuszone(false);
        }
        for (int i = 0; i < domW.getIleIstot(); ) {


            System.out.println("\nRuch wszysrtko " + i);
            domW.getTuMieszka(i).nocneAktywnosci();
            if (domW.getTuMieszka(i).isCzyRuszone()) i++;
        }

        System.out.println("\nnoc miesozernych");
        for (int i = 0; i < domM.getIleIstot(); i++) {
            domM.getTuMieszka(i).setCzyRuszone(false);
        }
        for (int i = 0; i < domM.getIleIstot(); ) {

            System.out.println("\nRuch mieso " + i);
            domM.getTuMieszka(i).nocneAktywnosci();
            if (domM.getTuMieszka(i).isCzyRuszone()) i++;
        }
    }

    private static void zasiej() {
        while (Roslina.getIleZyje() < ileRoslin) {

            losujPozycje();
            new Roslina((double) Math.floor(Math.random() * (25 - 5 + 1) + 5), losowa.getPosX1(), losowa.getPosY1(), mapa);


            losujPozycje();
            new Leczace((double) Math.floor(Math.random() * (25 - 5 + 1) + 5), losowa.getPosX1(), losowa.getPosY1(), mapa);


            losujPozycje();
            new Trujace((double) Math.floor(Math.random() * (25 - 5 + 1) + 5), losowa.getPosX1(), losowa.getPosY1(), mapa);

        }
    }

    private static void losujPozycje() {

        do {
            losowa.setPos((int) Math.floor(Math.random() * (kolumny) + 1), (int) Math.floor(Math.random() * (wiersze) + 1));
        }
        while (mapa.tuJest(losowa) != null);

    }

    private static void statystyki() throws IOException {
        try {
            plik = new FileWriter("historia.txt", true);
            plik.write("\n\nDzien: " + nrDnia);
            plik.write("\n \t roslinozernych istot jest: " + domR.getIleIstot() +
                    "\n \t wszystkozernych istot jest: " + domW.getIleIstot() +
                    "\n \t miesozernych istot jest: " + domM.getIleIstot());

        } finally {
            if (plik != null) {
                plik.close();
            }
        }
    }

}
