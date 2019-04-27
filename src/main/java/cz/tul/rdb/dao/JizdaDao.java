package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Jizda;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JizdaDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public JizdaDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates jizda db record
   *
   * @return primary key
   */
  public Jizda createJizda(String linka, Timestamp cas, String spz, String cislo_rp) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    Jizda jizda = null;
    try {
      tx = session.beginTransaction();
      jizda = new Jizda(linka, spz, cislo_rp, cas);
      jizda = (Jizda) session.save(jizda);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return jizda;
  }

  public Jizda createJizda(Jizda j) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    Jizda jizda = null;
    try {
      tx = session.beginTransaction();
      jizda = j;
      jizda = (Jizda) session.save(jizda);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return jizda;
  }

  public List<Jizda> listJizda() {
    Session session = sessionFactory.openSession();
    String hql = "FROM Jizda";
    Query query = session.createQuery(hql);
    List results = query.list();
    session.close();
    return results;
  }
}
