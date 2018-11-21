package com.sda.fakturownia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy--MM-dd");

        DrukarkaFaktur drukarkaFaktur1 = new DrukarkaFaktur(null, "Faktura Vat nr 122/2018", LocalDate.now(),
                LocalDate.now().plusMonths(3L), 255.08, "213-122-33-44", "123-335-56-78", null);

        FakturaDao fakturaDao = new FakturaDao();
        fakturaDao.savesInvoiceIntoDatabase(drukarkaFaktur1);
        System.out.println(fakturaDao.getAllnvoicesFromDatabase());

    }
}
