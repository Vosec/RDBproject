package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Kontakt;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KontaktDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public KontaktDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates kontakt db record
   *
   * @return primary key
   */
  public String createKontakt(String hodnota, String typ, String cislo_rp) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      Kontakt kontakt = new Kontakt(hodnota, typ, cislo_rp);
      hodnota = (String) session.save(kontakt);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return hodnota;
  }

  public String createKontakt(Kontakt kontakt) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    String hodnota = null;
    try {
      tx = session.beginTransaction();
      hodnota = (String) session.save(kontakt);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return hodnota;
  }

    public List<Kontakt> listKontakt() {
      Session session = sessionFactory.openSession();
      String hql = "FROM Kontakt";
      Query query = session.createQuery(hql);
      List results = query.list();
      session.close();
      return results;
    }
}
