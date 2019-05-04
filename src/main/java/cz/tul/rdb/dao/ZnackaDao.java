package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Znacka;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ZnackaDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public ZnackaDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates znacka db record
   *
   * @param znacka znacka - primary key
   * @return primary key
   */
  public String createZnacka(String znacka) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      Znacka znacka1 = new Znacka(znacka);
      znacka = (String) session.save(znacka);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return znacka;
  }

  public String createZnacka(Znacka znacka) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    String nazev_znacky = null;
    try {
      tx = session.beginTransaction();
      nazev_znacky = (String) session.save(znacka);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return nazev_znacky;
  }

    public List<Znacka> listZnacka() {
      Session session = sessionFactory.openSession();
      String hql = "FROM Znacka";
      Query query = session.createQuery(hql);
      List results = query.list();
      session.close();
      return results;
    }
}
