package com.sda.fakturownia;


import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FakturaDao {

    public boolean savesInvoiceIntoDatabase(DrukarkaFaktur drukarkaFaktur) {

        //pobieram session factory (fabryka połączenia z bazą)
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {

            //otwieram transakcję
            transaction = session.beginTransaction();
            session.save(drukarkaFaktur);  //dokonujemy zapisu w bazie
            transaction.commit();          //zamykam transakcję i zatwierdzam zmiany

        } catch (SessionException se) {
            //w razie błędu przywróć stan sprzed transakcji
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    public List<DrukarkaFaktur> getAllnvoicesFromDatabase() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            //stwórz zapytanie
            Query<DrukarkaFaktur> query = session.createQuery("from DrukarkaFaktur df", DrukarkaFaktur.class);
            //wywołaj zapytanie
            List<DrukarkaFaktur> drukarkaFaktur = query.list();
            //zwróć wynik
            return drukarkaFaktur;

        } catch (SessionException se) {
            //jeśli coś pójdzie nie tak - wypiszemy komunikat loggerem:
            System.err.println("Nie udało się pobrać z bazy!");
        }
        //jeśli nie uda się znaleźć zwraca pustą listę
        return new ArrayList<>();

    }
}
