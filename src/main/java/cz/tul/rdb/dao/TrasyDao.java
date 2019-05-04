package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Trasy;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrasyDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public TrasyDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates trasy db record
   *
   * @return primary key
   */
  public String createTrasy(String linka, String odkud, String kam) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      Trasy trasy = new Trasy(linka, odkud, kam);
      linka = (String) session.save(trasy);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return linka;
  }

  public String createTrasy(Trasy trasy) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    String linka = null;

    try {
      tx = session.beginTransaction();
      linka = (String) session.save(trasy);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return linka;
  }

    public List<Trasy> listTrasy() {
      Session session = sessionFactory.openSession();
      String hql = "FROM Trasy";
      Query query = session.createQuery(hql);
      List results = query.list();
      session.close();
      return results;
    }
}
