package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Mezizastavka;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

  public Mezizastavka createMezizastavka(Mezizastavka mezizastavka) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      mezizastavka = (Mezizastavka) session.save(mezizastavka);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return mezizastavka;
  }

    public List<Mezizastavka> listMezizastavka() {
      Session session = sessionFactory.openSession();
      String hql = "FROM Mezizastavka";
      Query query = session.createQuery(hql);
      List results = query.list();
      session.close();
      return results;
    }
}
