package cz.tul.rdb.dao;

import cz.tul.rdb.entity.Ridic;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RidicDao {

  private final SessionFactory sessionFactory;


  @Autowired
  public RidicDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Creates ridic db record
   *
   * @return primary key
   */
  public String createRidic(String cislo_rp, String jmeno, String prijmeni) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      Ridic ridic = new Ridic(cislo_rp, jmeno, prijmeni);
      cislo_rp = (String) session.save(ridic);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return cislo_rp;
  }

  public String createRidic(Ridic ridic) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    String cislo_rp = null;

    try {
      tx = session.beginTransaction();
      cislo_rp = (String) session.save(ridic);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return cislo_rp;
  }

    public List<Ridic> listRidic() {
      Session session = sessionFactory.openSession();
      String hql = "FROM Ridic";
      Query query = session.createQuery(hql);
      List results = query.list();
      session.close();
      return results;
    }
}
