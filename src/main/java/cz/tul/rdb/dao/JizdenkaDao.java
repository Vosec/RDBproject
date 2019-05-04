package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Jizdenka;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Component
public class JizdenkaDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public JizdenkaDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates jizdenka db record
   *
   * @return primary key
   */
  public BigInteger createJizdenka(String linka, String email, Timestamp cas, BigInteger cislo) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      Jizdenka jizdenka = new Jizdenka(linka, email, cas, cislo);
      cislo = (BigInteger) session.save(jizdenka);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return cislo;
  }

  public BigInteger createJizdenka(Jizdenka jizdenka) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    BigInteger cislo = null;
    try {
      tx = session.beginTransaction();
      cislo = (BigInteger) session.save(jizdenka);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return cislo;
  }

    public List<Jizdenka> listJizdenka() {
      Session session = sessionFactory.openSession();
      String hql = "FROM Jizdenka";
      Query query = session.createQuery(hql);
      List results = query.list();
      session.close();
      return results;
    }
}
