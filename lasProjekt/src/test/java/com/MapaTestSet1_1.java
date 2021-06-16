package com;

import org.junit.jupiter.api.Test;


/**
 * Test sprawdzający, czy wyswietla sie przeszkoda
 */

class MapaTestSet1_1 {

    Mapa mapa = new Mapa(10,10,30,40,40);
    Pozycja pos = new Pozycja(2,3);
    Przeszkoda przeszkoda=new Przeszkoda(pos,mapa);

    @Test
    void setOnMap() {
        mapa.setOnMap(pos,przeszkoda);

        System.out.print("Sprawdz, czy w polu 1 od lewej 1 od gory jest szara kropa ");
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        mapa.delete(pos);
        System.out.print("Sprawdz, czy mapa jest pusta");
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}