package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Lokalita;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

  public String createLokalita(Lokalita lokalita) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    String nazev = null;

    try {
      tx = session.beginTransaction();
      nazev = (String) session.save(lokalita);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return nazev;
  }

    public List<Lokalita> listLokalita() {
      Session session = sessionFactory.openSession();
      String hql = "FROM Lokalita";
      Query query = session.createQuery(hql);
      List results = query.list();
      session.close();
      return results;
    }
}
