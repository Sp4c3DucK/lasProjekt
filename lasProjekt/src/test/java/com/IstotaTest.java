/*package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IstotaTest {

    Mapa mapa = new Mapa(1, 1,1,1,1);
    Istota istota=new Roslinozerne(2,2,3,true,1,1,mapa,new Dom(new Pozycja(2,2),"roslinozerne",mapa ));
    Pozycja cel = new Pozycja(5,5);

    //ide w prawo i w dol
    @Test
    void TestPozycji1() {
        istota.setEnergia(100);
        istota.pozycja.setPos(4,3);
        istota.TIde(cel);

        assert istota.pozycja.Porownaj(cel);
    }

    @Test
    void TestZuzycia1() {
        istota.setEnergia(100);
        istota.pozycja.setPos(4,3);
        istota.TIde(cel);

        assert istota.getEnergia()==97;
    }

    //ide w lewo i w gore
    @Test
    void TestPozycji2() {
        istota.setEnergia(100);
        istota.pozycja.setPos(10,10);
        istota.TIde(cel);

        assert istota.pozycja.Porownaj(cel);
    }

    @Test
    void TestZuzycia2() {
        istota.setEnergia(100);
        istota.pozycja.setPos(10,10);
        istota.TIde(cel);

        assert istota.getEnergia()==90;
    }
}*/