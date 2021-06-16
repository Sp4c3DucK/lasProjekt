package com;

/**
 * Klasa: Istota
 * <p>
 * wersja: 1
 * <p>
 * edytor: Maciej Dziewisz
 * <p>
 * data: 19.05.2021
 * <p>
 * --------------------------------
 * <p>
 * wersja: 2
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 04.06.2021
 * <p>
 * opis zmian:  usunięcie zmiennej socjalnosc; metoda Ide zalezy od zmiennej Pozycja a nie 4 zmiennych int,
 * metoda Gdzie isc zwraca pozycje a nie dwa inty, i nie przyjmuje argumentów; Implementacja metody Ide;
 * zmiana typu zmiennej predkosc z double na int - przemieszczac mozna sie jedynie o pelne pola
 * dodanie setEnergia getEnergia. test Ide; implementacja dostlTrucizne, dostalLek,
 * zjada, rozszerzenie metody umiera
 * <p>
 * --------------------------------
 * <p>
 * Wersja: 3
 * <p>
 * edytor: Szymon Drogos
 * <p>
 * data: 05.06.2021
 * <p>
 * opis zmian: dodanie metody rodzi
 * <p>
 * --------------------------------
 * <p>
 * Wersja: 4
 * <p>
 * edytor: Szymon Drogos, Arkadia Kowalczyk, Maciej Dziewisz
 * <p>
 * data: 06.06.2021
 * <p>
 * opis zmian:  usuniecie z konstruktora czyZyje, dodanie do konstruktora dom; całkowita zmiana metody ide,
 * bo nie brała pod uwage przeszkód; zmiana metody zjada, tak by zmieniała stan czyUrodzi;
 * praca nad metodą Rodzi, dodanie metody abstrakcyjnej daPotomka;
 * <p>
 * --------------------------------
 * <p>
 * Wersja: 5
 * <p>
 * edytor: Arkadia Kowalczyk, Maciej Dziewisz
 * <p>
 * data: 07.06.2021
 * <p>
 * opis zmian:  dodanie do konstruktora ktoryWDomu; dodanie metody setKtoryWDomu (wykorzystane w domu w ktosUmarl);
 * dodanie do konstruktora argumentu energiaMax; dodanie argumentu maxi do metody daPotomka,
 * aktualizacja metody rodzi; zmiana nazwy metody rodzi na nocneAktywnosci, dodanie do tej metody
 * umierania gdy spi poza domem; szkielet metody turaDzienna; dodanie zmiennych coJem i coSzukam;
 * <p>
 * --------------------------------
 * <p>
 * Wersja: 6
 * <p>
 * edytor: Arkadia Kowalczyk, Maciej Dziewisz, Szymon Drogos
 * <p>
 * data: 08.06.2021
 * <p>
 * opis zmian:  dodanie metody szukajCel, dokonczenie metody ide, tura dzienna wykonuje sie tylko gdy zyje
 * rezygnacja z bfs
 * <p>
 * komunikaty: gdy zje ofiare, oraz gdy umrze, gdy umrze w nocy, gdy znajdzie ofiare
 * <p>
 * --------------------------------
 * <p>
 * Wersja: 7
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: o8-09.06.2021
 * <p>
 * opis zmian:
 * <p>
 * dodanie zmiennej deptam, jesli szukam domu co szukam odrazu zwraca adres naszego domu, i jesli nie znalazlismy jedzenia,
 * <p>
 * ide:    na poczatku ide ustawiamy sie na pozycji z ktorej ruszamy (na wypadek gdyby cos nas zdeptało lub zasłonił nas dom),
 * dodanie komunikatow w prawo w lewo w gore w dol, usuniecie problemu przeskakiwania i powracania,
 * oddelegowanie stawiania kroku metodzie wykonuje krok, zmienna temp zmienia sie poprawnie oddelegownie
 * zuzycia energii metodzie zuzywam energie, jesli szukal jedzenie, to zwraca to co wlasnie zdeptał,
 * dodanie metod zuzywam energie i wykonuje krok
 * <p>
 * zjada:  zabezpieczenie sie przed sytuacja, gdy przekazany argument byłby null, dodanie komunikatu co zjadam
 * i urodze, po zjedzeniu deptam ustawiamy na null
 * <p>
 * dodatnie komunikatów daje energie i otrzymuje energie wraz z wartosciami
 * <p>
 * nocneAktywnosci:    dodanie komunikatu "noc" i kto wykonuje, oraz jestem w domu; czyUrodzi = false na
 * poczatku a nie na koncu nocy, zatrzymanie czasu przed narodzinami, zabezpieczenie
 * sie przed usunieciem domu z mapy, oraz istot ktore spia na tym samym polu co my
 * <p>
 * turaDzienna:    usuniecie zmiennej dl; dodanie komunikatow; jesli szukalismy domu to stawiamy dom na mapie
 * <p>
 * <p>
 * --------------------------------
 * <p>
 * Wersja: 8
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 11.06.2021
 * <p>
 * opis zmian: naprawienie błędu który powodował że istota nie chowała się w domu, przez co mogła zostać zjedzona będąc w domu
 * jesli istota nie musi wychodzic z domu to nie rozpoczyna ruchu - nie wychodzi przed dom (kolejne zabezpieczenie przed
 * wspomnianym błędem), komunikaty, sprawdzanie czy umarl przez brak energi w metodzie zabierz energie a nie w ide
 * <p>
 * --------------------------------
 * <p>
 * Wersja: 9
 * <p>
 * edytor: Arkadia Kowalczyk
 * <p>
 * data: 12.06.2021
 * <p>
 * opis zmian: wyeliminowanie błędu ktory sprawial, ze jesli np istota 3 umierala to istota 4
 * nie wykonywala ruchu (bo stawala sie nowa 3ka, a ruch wykonywala nowa 4ka czyli dawna 5tka)
 * nowa implementacja metody szukajCel
 */

public abstract class Istota extends Jadalne {

    private double energia;
    private double energiaMax;
    private boolean czyUrodzi;
    protected boolean czyTruje;
    private boolean czyMaLek;
    protected int predkosc;
    protected double zuzycie;
    protected Dom dom;
    private int ktoryWDomu;
    protected static int ileZyje = 0;
    private Pozycja cel = new Pozycja(0, 0);
    private Pozycja temp = new Pozycja(0, 0);
    private double maxiPotomka = energiaMax / 2;
    private final int coJem; //zgodnie z przedstawJako: 6- wszystko 7- roslina 8- mieso
    private int coSzukam; //0 - dom inne - jedzenie
    private Jadalne ofiara;
    private Istniejace deptam = null;
    private Szukam szukam;


    private boolean czyRuszone = false;

    public Istota(double energiaAdd, int posX, int posY, boolean czyTruje, int predkosc, double zuzycie, Mapa mapa, Dom dom, double energiaMax, int coJem) {
        super(energiaAdd, posX, posY, mapa);

        System.out.println("\nHello World!!! narodzilem sie " + this + " " + posX + " " + posY);

        ileZyje++;
        pozycja = new Pozycja(posX, posY);

        this.czyTruje = czyTruje;
        this.predkosc = predkosc;
        this.zuzycie = zuzycie;
        this.dom = dom;
        this.energiaMax = energiaMax;
        this.coJem = coJem;
        energia = this.energiaMax - this.zuzycie;

        dom.nowyDomownik(this);
        ktoryWDomu = dom.getIleIstot();

        //po narodzinach na chwile widzimy kto sie urodzil, ale potem znow widzimy tylko dom - tak ma byc
        mapa.setOnMap(dom.getPozycja(), dom);

        szukam = szukam.dajSzukam(mapa.getX(), mapa.getY(), mapa);
    }

    // test metody ide
    void tIde(Pozycja p) {
        cel = p;
        ide(true);
    }

    private Pozycja szukajCel(int x, int y) {
        if (coSzukam == 0) return dom.getPozycja();

        cel = szukam.szukaj(pozycja, przedstawJako);

        if (!pozycja.porownaj(cel)) return cel;

        coSzukam = 0; //b istotne! jesli tego nie bedzie to gdy nie znajdzie jedzenia spróbuje zjesc dom
        return dom.getPozycja();
    }


    private Jadalne ide(boolean czySzukamJedzenia) {
        // porusz sie w kierunku celu o predkosc i zabierz zuzycie energii

        //predkosc to dlugosc ktroku
        //zuzycie to 1 krok

        //sprawdzamy czy nie deptamy czegos juz na samym poczatku, np domu
        temp.setPos(pozycja.getPosX1(), pozycja.getPosY1());
        wykonujeKrok();
        System.out.println("\nRozpoczynam podróż ku celu: " + cel.getPosX1() + " " + cel.getPosY1());
        System.out.println("");


        try {
            Thread.sleep(500);

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


        //Ruch w osi OX

        if (pozycja.getPosX1() < cel.getPosX1()) //1) istota musi isc w prawo
        {
            while (pozycja.getPosX1() < cel.getPosX1()) {

                for (int i = predkosc; i > 0; i--) {
                    if (temp.getPosX1() < cel.getPosX1()) {
                        temp.setPos(temp.getPosX1() + 1, pozycja.getPosY1());
                    }
                    wykonujeKrok();
                }
                if (!zuzywamEnergie()) return null;
            }
        } else //2) istota musi is w lewo
        {
            while (pozycja.getPosX1() > cel.getPosX2()) {

                for (int i = predkosc; i > 0; i--) {
                    if (temp.getPosX1() > cel.getPosX1()) {
                        temp.setPos(temp.getPosX1() - 1, pozycja.getPosY1());
                    }
                    wykonujeKrok();
                }
                if (!zuzywamEnergie()) return null;
            }
        }


        //Ruch w osi OY
        if (pozycja.getPosY1() < cel.getPosY1()) //1) istota musi isc w dol
        {
            while (pozycja.getPosY1() < cel.getPosY1()) {

                for (int i = predkosc; i > 0; i--) {
                    if (temp.getPosY1() < cel.getPosY1()) {
                        temp.setPos(pozycja.getPosX1(), temp.getPosY1() + 1);
                    }
                    wykonujeKrok();
                }
                if (!zuzywamEnergie()) return null;
            }
        } else //2) istota musi is w gore
        {
            while (pozycja.getPosY1() > cel.getPosY2()) {
                for (int i = predkosc; i > 0; i--) {

                    if (temp.getPosY1() > cel.getPosY1()) {

                        temp.setPos(pozycja.getPosX1(), temp.getPosY1() - 1);

                    }
                    wykonujeKrok();
                }
                if (!zuzywamEnergie()) return null;
            }
        }

        System.out.print("Dotarlem do celu, ");
        if (czySzukamJedzenia) {
            System.out.println("teraz moge zjesc");
            return (Jadalne) deptam;
        }

        System.out.println("nie ma to jak w domu ");
        coSzukam = 0;
        return null;

    }

    private boolean zuzywamEnergie() {
        System.out.print("zuzywam energie " + energia + " - " + zuzycie + " = ");

        energia -= zuzycie;
        System.out.println(energia);


        if (energia <= 0) {
            System.out.println("Zabrakło mi energii " + this);
            umiera();
            cel = pozycja;
            return false;
        }

        return true;
    }

    private void wykonujeKrok() {

        //zabezpie3czenie przed wyjsciem poza mape
        if (temp.getPosX1() <= 0) temp.setPos(1, temp.getPosY1());
        if (temp.getPosX1() >= mapa.getX()) temp.setPos(mapa.getX(), temp.getPosY1());
        if (temp.getPosY1() <= 0) temp.setPos(temp.getPosX1(), 1);
        if (temp.getPosY1() >= mapa.getY()) temp.setPos(temp.getPosX1(), mapa.getY());

        mapa.setOnMap(dom.getPozycja(), dom);

        if (deptam == null) {
            mapa.delete(pozycja);
        } else {
            mapa.setOnMap(pozycja, deptam);
        }

        pozycja.setPos(temp.getPosX1(), temp.getPosY1());
        deptam = mapa.tuJest(pozycja);
        mapa.setOnMap(pozycja, this);

        try {
            Thread.sleep(100);

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    private void zjada(Jadalne jadalne) {
        if (jadalne != null) {
            System.out.println("zjadam: " + jadalne);
            jadalne.jestZjadane(this);
            deptam = null;

            System.out.println("musze to przetrawić");

            zuzywamEnergie();
        }
    }

    public void dostalTrucizne(double a) {
        System.out.print("O nie, otruli mnie ");
        if (czyMaLek) {

            System.out.println("ale mam lekarstwo ;)");

            czyMaLek = false;
            this.setEnergia(a);
        } else {
            energia -= a;
            System.out.print("i niestety nie mam lekarstwa, zabrali mi tyle energii: " + a + " a ja, ");
        }

    }

    public void dostalLek() {
        System.out.println("Dostałem lekarstwo, ale super");
        czyMaLek = true;
    }

    public void setEnergia(double energia) {

        System.out.println("\nto znowu ja, " + this);
        System.out.print("teraz mam tyle energii: " + energia);

        this.energia = energia;
        if (this.energia > energiaMax) {

            System.out.println(" ale wszystkiego nie zmieszcze");

            this.energia = energiaMax;
        }
        if (this.energia == energiaMax) {
            czyUrodzi = true;
            System.out.println("urodze");
        }
    }

    public double getEnergia() {
        return energia;
    }

    @Override
    protected void umiera() {

        super.umiera();
        dom.ktosUmarl(this);

    }

    protected void nocneAktywnosci() { //todo testy
        if (czyZyje) {
            czyRuszone = true;
            System.out.println("\nwpis do dziennika, moja noc -" + this);
            if (pozycja.porownaj(dom.getPozycja())) {
                System.out.println("jestem w domu ");


                //jesli jest miejsce obok nas w domu to rodzimy tam, a jesli nie, to pod siebie
                if (czyUrodzi) {
                    czyUrodzi = false;

                    try {
                        Thread.sleep(100);

                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Ja rodze!!! 500+ juz jest moje " + this);


                    if (energia <= energiaMax / 2) maxiPotomka = energiaMax / 2;
                    else maxiPotomka = energiaMax;
                    energia = energia / 2;

                    temp.setPos(pozycja.getPosX1(), pozycja.getPosY1() + 1);
                    if (temp.porownaj(dom.getPozycja())) {
                        dajPotomka(temp, maxiPotomka);
                        return;
                    }


                    temp.setPos(pozycja.getPosX1(), pozycja.getPosY1() - 1);
                    if (temp.porownaj(dom.getPozycja())) {
                        dajPotomka(temp, maxiPotomka);
                        return;
                    }

                    temp.setPos(pozycja.getPosX1() + 1, pozycja.getPosY1());
                    if (temp.porownaj(dom.getPozycja())) {
                        dajPotomka(temp, maxiPotomka);
                        return;
                    }

                    temp.setPos(pozycja.getPosX1() - 1, pozycja.getPosY1());
                    if (temp.porownaj(dom.getPozycja())) {
                        dajPotomka(temp, maxiPotomka);
                        return;
                    }

                    dajPotomka(pozycja, maxiPotomka);


                }


                if (ktoryWDomu == dom.getIleIstot()) {
                    deptam = dom;
                } else {
                    for (int i = 1; i < ktoryWDomu; i++) {
                        if (pozycja.porownaj(dom.getTuMieszka(i).getPozycja())) {
                            deptam = dom.getTuMieszka(i);
                        }
                    }
                }


            } else {

                System.out.println("spie poza domem, strasznie tu zimno brrr");
                umiera();

            }//jest noc a istota nie jest w domu - umiera z zimna,
            // to dzieje sie gdy jest duzo malego jedzenia, wiec istota wie gdzie szukac jedzenia ale nie najada sie na tyle by urodzic
        }
    }

    protected abstract Istota dajPotomka(Pozycja kolyska, double maxi);

    public void setKtoryWDomu(int n) {
        if (n > 0 || n < ktoryWDomu) ktoryWDomu = n;
    }

    public boolean isCzyRuszone() {
        return czyRuszone;
    }

    public void setCzyRuszone(boolean czyRuszone) {
        this.czyRuszone = czyRuszone;
    }

    public void turaDzienna() {
        if (czyZyje) {

            czyRuszone = true;

            //czegoszukam //0 - dom 1 - jedzenie
            if (czyUrodzi) coSzukam = 0;
            else coSzukam = coJem;

            //szukam

            cel = szukajCel(mapa.getX(), mapa.getY());
            System.out.print("znalazlem cel: " + cel.getPosX1() + " " + cel.getPosY1());


            //ide

            if (!pozycja.porownaj(cel)) {
                if (coSzukam == 0) {
                    System.out.println(" to jest dom");
                    ide(false);
                } else {
                    System.out.println(" to jest jedzenie");
                    ofiara = ide(true);
                }
            }

            //if czegoszukam!= dom zjedz
            if (coSzukam != 0) {
                System.out.println("mam tyle energii przed zjedzeniem: " + energia);
                zjada(ofiara);
            }

            mapa.setOnMap(dom.getPozycja(), dom);

        }
    }
}