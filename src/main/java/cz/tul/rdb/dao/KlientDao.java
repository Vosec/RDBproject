package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Klient;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KlientDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public KlientDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates klient db record
   *
   * @return primary key
   */
  public String createKlient(String email, String jmeno, String prijmeni) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      Klient klient = new Klient(email, jmeno, prijmeni);
      email = (String) session.save(klient);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return email;
  }

  public String createKlient(Klient klient) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    String email = null;

    try {
      tx = session.beginTransaction();
      email = (String) session.save(klient);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return email;
  }

}
