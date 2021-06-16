package com;


import org.junit.jupiter.api.Test;

/**
 * Test sprawdzający, czy wyswietla sie dom
 */

class MapaTest1_2 {

    Mapa mapa = new Mapa(10,10,30,40,40);
    Pozycja pos = new Pozycja(4,2,5,3);
/*
_1 2 3 4 5
1
2
3  * * *
4  * * *
5  * * *

 */

    Dom dom=new Dom(pos, "dom", mapa);

    @Test
    void setOnMap() {
        mapa.setOnMap(pos,dom);
        System.out.print("Sprawdz, czy w polach sa rozowe kropy ");

        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}