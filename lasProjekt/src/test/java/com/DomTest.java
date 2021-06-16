package com;

import org.junit.jupiter.api.Test;

class DomTest {

    Pozycja pozycja=new Pozycja(2,3,5,6);
    Mapa mapa = new Mapa(10,10,30,1,1);
    Dom dom = new Dom(pozycja, "roslinozerne", mapa );
    Istota a = new Roslinozerne(2,1,1,true,3,3,mapa,dom,100);
    Istota b = new Roslinozerne(2,1,2,true,3,3,mapa,dom,100);
    Istota c = new Roslinozerne(2,2,3,true,3,3,mapa,dom,100);

    @Test
    void getPozycja() {
        Pozycja testPozycja = dom.getPozycja();
        assert (testPozycja==pozycja);
    }

    @Test
    void nowyDomownik() {
        System.out.println("Ile istot 1: "+dom.getIleIstot());


        /*
        dom.nowyDomownik(a);
        System.out.println("\n zamieszkal a");
        dom.nowyDomownik(b);
        System.out.println("\n zamieszkal b");
        dom.nowyDomownik(c);
        System.out.println("\n zamieszkal c");
         */

        assert dom.getTuMieszka(0)==a;
        assert dom.getTuMieszka(1)==b;
        assert dom.getTuMieszka(2)==c;

        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }


        System.out.println("Ile istot 2: "+dom.getIleIstot());
        assert dom.getIleIstot()==3;
    }

    @Test
    void ktosUmarl() {
        System.out.println("test: ktos umarl");

        System.out.println("\n umarl b");
        dom.ktosUmarl(b);

        assert dom.getTuMieszka(0)==a;
        assert dom.getTuMieszka(1)==c;
        assert dom.getIleIstot()==2;


        System.out.println("\n umarl a");
        dom.ktosUmarl(a);

        assert dom.getTuMieszka(0)==c;
        assert dom.getIleIstot()==1;


        System.out.println("\n umarl c");
        dom.ktosUmarl(c);

        assert dom.getIleIstot()==0;
    }

}