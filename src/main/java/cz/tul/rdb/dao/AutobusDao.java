package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Autobus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutobusDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public AutobusDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates autobus db record
   *
   * @param spz spy - primary key
   * @param znacka znacka
   * @return primary key
   */
  public String addAutobus(String spz, String znacka) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      Autobus autobus = new Autobus(spz, znacka);
      spz = (String) session.save(autobus);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace(); //tohle nedělat, mělo by se zalogovat
    } finally {
      session.close();
    }

    return spz;
  }
}
