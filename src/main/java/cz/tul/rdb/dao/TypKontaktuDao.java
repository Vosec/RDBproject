package cz.tul.rdb.dao;

import cz.tul.rdb.entity.TypKontaktu;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypKontaktuDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public TypKontaktuDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates typKontaktu db record
   *
   * @param typ contact type
   * @return primary key
   */
  public String createTypKontaktu(String typ) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      TypKontaktu typKontaktu = new TypKontaktu(typ);
      typ = (String) session.save(typKontaktu);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return typ;
  }

  public String createTypKontaktu(TypKontaktu typKontaktu) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    String typ = null;

    try {
      tx = session.beginTransaction();
      typ = (String) session.save(typKontaktu);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return typ;
  }
}
