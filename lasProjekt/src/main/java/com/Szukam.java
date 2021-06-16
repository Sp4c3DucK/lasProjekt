package com;

import java.util.*;

/**
 * Klasa:Szukam
 * <p>
 * Wersja: 1
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 12.06.2021
 * <p>
 * opis zmian: zrobienie wszystkiego, zajelo mi to niespelna 3h podczas gdy osoba ktora poprzednio zajmowala sie
 * wyszukiwaniem, spedzila nad tym 3 dni i stwierdzila ze nie jest w stanie tego wykonac,
 * ja nie bede mowic kto ale ta osoba dobrze wie o kogo mi chodzi
 */

public class Szukam {

    private static volatile Szukam instance = null;

    private boolean czyOdwiedzone[][];
    private Mapa mapa;

    private int kolumny, wiersze, dlaKogo;

    private Pozycja odpowiedz = new Pozycja(0, 0);
    private Pozycja szukana;
    private Pozycja sprawdzana = new Pozycja(0, 0);

    private Queue<Pozycja> doSprawdzenia = new ArrayDeque<>();


    private Szukam(int kolumny, int wiersze, Mapa mapa) {

        czyOdwiedzone = new boolean[kolumny + 1][wiersze + 1];

        this.kolumny = kolumny;
        this.wiersze = wiersze;
        this.mapa = mapa;

        //isInstance=true;
    }

    public static Szukam dajSzukam(int kolumny, int wiersze, Mapa mapa) {
        if (instance == null) {
            synchronized (Szukam.class) {
                if (instance == null) {
                    instance = new Szukam(kolumny, wiersze, mapa);
                }
            }
        }
        return instance;
    }

    public Pozycja szukaj(Pozycja start, int dlaKogo) {

        System.out.println("rozpoczynmy poszukiwania");
        this.dlaKogo = dlaKogo;

        for (int i = 0; i < kolumny; i++) {
            for (int j = 0; j < wiersze; j++) {
                czyOdwiedzone[i][j] = false;

            }
        }

        // System.out.println("wyczyszczone");

        odpowiedz.setPos(start.getPosX1(), start.getPosY1());
        doSprawdzenia.add(odpowiedz);

        while (!doSprawdzenia.isEmpty()) {
            szukana = doSprawdzenia.remove();
            sprawdz(szukana.getPosX1(), szukana.getPosY1());
        }

        return odpowiedz;
    }

    private void sprawdz(int x, int y) {

        czyOdwiedzone[x][y] = true;

        // System.out.println("\nsprawdzam: "+x+" "+y);


        //w prawo
        //System.out.println("w prawo");
        if (x + 1 <= kolumny) {
            if (!czyOdwiedzone[x + 1][y]) {
                sprawdzana.setPos(x + 1, y);
                if (czyJedzenie(sprawdzana)) {
                    odpowiedz.setPos(x + 1, y);
                    doSprawdzenia.clear();
                    return;
                }
                //System.out.println("dodaje do listy "+(x+1)+" "+y);
                czyOdwiedzone[x + 1][y] = true;
                doSprawdzenia.add(new Pozycja(x + 1, y));

                // System.out.println("dodalem do listy");
            }
        }

        //w lewo
        //System.out.println("w lewo");
        if (x >= 2) {
            if (!czyOdwiedzone[x - 1][y]) {
                sprawdzana.setPos(x - 1, y);
                if (czyJedzenie(sprawdzana)) {
                    odpowiedz.setPos(x - 1, y);
                    doSprawdzenia.clear();
                    return;
                }
                //System.out.println("dodaje do listy "+ (x-1) +" "+y);
                czyOdwiedzone[x - 1][y] = true;

                doSprawdzenia.add(new Pozycja(x - 1, y));
                //System.out.println("dodalem do listy");
            }
        }

        //w dol
        //System.out.println("w dol");
        if (y + 1 <= wiersze) {
            if (!czyOdwiedzone[x][y + 1]) {
                sprawdzana.setPos(x, y + 1);
                if (czyJedzenie(sprawdzana)) {
                    odpowiedz.setPos(x, y + 1);
                    doSprawdzenia.clear();
                    return;
                }
                //System.out.println("dodaje do listy "+ x +" "+(y+1));
                czyOdwiedzone[x][y + 1] = true;

                doSprawdzenia.add(new Pozycja(x, y + 1));
            }
        }

        //w gore
        //System.out.println("w gore");
        if (y >= 2) {
            if (!czyOdwiedzone[x][y - 1]) {
                sprawdzana.setPos(x, y - 1);
                if (czyJedzenie(sprawdzana)) {
                    odpowiedz.setPos(x, y - 1);
                    doSprawdzenia.clear();
                    return;
                }
                // System.out.println("dodaje do listy "+ x +" "+(y-1));
                czyOdwiedzone[x][y - 1] = true;
                doSprawdzenia.add(new Pozycja(x, y - 1));
            }
        }
    }

    private boolean czyJedzenie(Pozycja sprawdzam) {

        if (mapa.tuJest(sprawdzam) != null) {

            switch (dlaKogo) {
                case 6:
                    if (mapa.tuJest(sprawdzam).getPrzedstaw() >= 3 && mapa.tuJest(sprawdzam).getPrzedstaw() <= 8 && mapa.tuJest(sprawdzam).getPrzedstaw() != 6) {
                        return true;
                    }
                    return false;

                case 7: {
                    //System.out.println("sprawdzam "+sprawdzam.getPosX1()+sprawdzam.getPosY1()+" "+mapa.tuJest(sprawdzam).getPrzedstaw()+" "+mapa.tuJest(sprawdzam));
                    if (mapa.tuJest(sprawdzam).getPrzedstaw() == 3 || mapa.tuJest(sprawdzam).getPrzedstaw() == 4 || mapa.tuJest(sprawdzam).getPrzedstaw() == 5) {

                        return true;
                    }
                    return false;
                }

                case 8:
                    if (mapa.tuJest(sprawdzam).getPrzedstaw() == 6 || mapa.tuJest(sprawdzam).getPrzedstaw() == 7) {
                        return true;
                    }
                    return false;
            }
        }
        return false;
    }

}
