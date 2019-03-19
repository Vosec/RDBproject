package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Lokalita;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LokalitaDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public LokalitaDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates autobus db record
   *
   * @return primary key
   */
  public String createLokalita(String nazev) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      Lokalita lokalita = new Lokalita(nazev);
      nazev = (String) session.save(lokalita);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return nazev;
  }
}
