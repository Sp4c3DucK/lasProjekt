package com;


import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Klasa: Plansza
 * <p>
 * wersja: 1
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data:  30.05.2021
 * <p>
 * opis:  plansza wyrysowuje na ekranie siatkę - plansze na której bedzie dziać się nasza animacja
 * <p>
 * ------------------------------
 * <p>
 * wersja: 2
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 1.06.2021
 * <p>
 * opis zmian:  rysowanie siatki jest osobna metoda, wywoływana w paintComponent; plansza wyrysowuje też istniejace,
 * na podstawie ich pozycji na mapie. Jeżeli zostaniemy przy kolorowych kropkach, to case bedzie
 * jedynie zmieniał kolor, a po switch ale jeszcze w if bedzie rysujIkone, lub poprostu fil oval
 */

public class Plansza extends JPanel {

    int iKolumn, iWierszy; //wymiary mapy
    int s; //dlugosc scianki pola
    int pierwszyX, pierwszyY;
    int kto = 1;
    Pozycja temp = new Pozycja(0, 0);
    Mapa mapa;


    Plansza(int s, int pierwszyX, int pierwszyY, int iKolumn, int iWierszy, Mapa mapa) {
        this.iKolumn = iKolumn;
        this.iWierszy = iWierszy;
        this.s = s;
        this.pierwszyX = pierwszyX;
        this.pierwszyY = pierwszyY;
        this.mapa = mapa;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        rysujSiatke(g);


        for (int kol = 0; kol <= iKolumn; kol++) {
            for (int wier = 0; wier <= iWierszy; wier++) {
                temp.setPos(kol, wier);
                if (mapa.tuJest(temp) != null) {
                    kol--;
                    wier--;

                    kto = mapa.tuJest(temp).getPrzedstaw();

                /*
                1 - przeszkoda (zrezygnowalismy)
                2 - dom
                3 - leczaca roslina
                4 - trujaca roslina
                5 - zwykla roslina
                6 - wszystkozerny
                7 - roslinozerny
                8 - miesozerny
                 */

                    switch (kto) {
                        //case 1:
                        //rysujP(g, kol, wier);break;
                        case 2:
                            rysujD(g, kol, wier);
                            break;
                        case 3:
                            rysujL(g, kol, wier);
                            break;
                        case 4:
                            rysujT(g, kol, wier);
                            break;
                        case 5:
                            rysujZ(g, kol, wier);
                            break;
                        case 6:
                            rysujW(g, kol, wier);
                            break;
                        case 7:
                            rysujR(g, kol, wier);
                            break;
                        case 8:
                            rysujM(g, kol, wier);
                            break;
                    }
                    kol++;
                    wier++;
                }
            }

        }

    }


    void rysujSiatke(Graphics g) {

        for (int i = 0; i <= iWierszy; i++) {
            g.drawLine(pierwszyX, pierwszyY + i * s, pierwszyX + iKolumn * s, pierwszyY + i * s);
        }
        for (int i = 0; i <= iKolumn; i++) {
            g.drawLine(pierwszyX + i * s, pierwszyY, pierwszyX + i * s, pierwszyY + iWierszy * s);
        }
    }


    private void rysujP(Graphics g, int kol, int wier) {
        g.setColor(Color.gray);
        rysujIkone(g, kol, wier);
    }

    private void rysujD(Graphics g, int kol, int wier) {
        g.setColor(Color.pink);
        rysujIkone(g, kol, wier);

    }

    private void rysujL(Graphics g, int kol, int wier) {
        g.setColor(Color.green);
        rysujIkone(g, kol, wier);

    }

    private void rysujT(Graphics g, int kol, int wier) {
        g.setColor(Color.green);
        rysujIkone(g, kol, wier);

    }

    private void rysujZ(Graphics g, int kol, int wier) {
        g.setColor(Color.green);
        rysujIkone(g, kol, wier);

    }

    private void rysujW(Graphics g, int kol, int wier) {
        g.setColor(Color.black);
        rysujIkone(g, kol, wier);

    }

    private void rysujR(Graphics g, int kol, int wier) {
        g.setColor(Color.cyan);
        rysujIkone(g, kol, wier);

    }

    private void rysujM(Graphics g, int kol, int wier) {
        g.setColor(Color.blue);
        rysujIkone(g, kol, wier);
    }

    private void rysujIkone(Graphics g, int kol, int wier) {

        g.fillOval(pierwszyX + kol * s, pierwszyY + wier * s, s, s);
    }

}

