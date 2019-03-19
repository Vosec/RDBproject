package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Jizdenka;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;

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
}
