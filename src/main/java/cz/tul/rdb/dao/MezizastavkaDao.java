package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Mezizastavka;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MezizastavkaDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public MezizastavkaDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates autobus db record
   *
   * @return primary key
   */
  public Mezizastavka createMezizastavka(String nazev, String linka) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    Mezizastavka mezizastavka = null;
    try {
      tx = session.beginTransaction();
      mezizastavka = new Mezizastavka(nazev, linka);
      mezizastavka = (Mezizastavka) session.save(mezizastavka);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return mezizastavka;
  }
}
