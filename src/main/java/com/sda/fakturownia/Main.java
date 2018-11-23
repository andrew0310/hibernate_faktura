package com.sda.fakturownia;

import com.sda.firma.Platnik;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("1 - Dodaj płatnika,");
        System.out.println("2 - Usuń płatnika,");
        System.out.println("3 - Pokaż dane płatnika,");
        System.out.println("4 - Pokaż wszystkich płatników,");
        System.out.println("5 - Dodaj fakturę,");
        System.out.println("6 - Usuń fakturę,");
        System.out.println("7 - Dodaj firmę,");
        System.out.println("8 - Usuń firmę,");
        System.out.println("9 - Powiąż płatnika z firmą.");

        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                dodajPlatnika();
            case 2:
            case 3:
            case 4:
                FakturaDao fakturaDao = new FakturaDao();
                System.out.println(fakturaDao.getAllPlatnikFromDatabase());
        }

/*
        FakturaDao fakturaDao = new FakturaDao();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy--MM-dd");
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj dane do faktury: ");
        System.out.print("* numer faktury: ");
        String numerFaktury = sc.next();

        System.out.print("* kwota: ");
        double kwota = Double.parseDouble(sc.next());

        System.out.print("* NIP firmy: ");
        String nipFirmy = sc.next();

        System.out.print("* NIP platnika: ");
        String nipPlatnika = sc.next();

        DrukarkaFaktur faktura = new DrukarkaFaktur(null, "Faktura Vat nr: " + numerFaktury, LocalDate.now(),
                LocalDate.now().plusMonths(3L), kwota, nipFirmy, nipPlatnika, null);

        fakturaDao.savesIntoDatabase(faktura);
*/

    }

    public static void dodajPlatnika() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj dane płatnika:");

        System.out.print("* imię: ");
        String imie = sc.next();

        System.out.print("* nazwisko: ");
        String nazwisko = sc.next();

        System.out.print("* NIP platnika: ");
        String nipPlatnika = sc.next();

        Platnik platnik = new Platnik(null, imie, nazwisko, nipPlatnika, null);

        FakturaDao fakturaDao = new FakturaDao();
        fakturaDao.savesIntoDatabase(platnik);
    }
}
