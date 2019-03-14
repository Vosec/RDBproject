package cz.tul.rdb.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("cz.tul.rdb")
public class DBConfiguration {

  /**
   * @return SessionFactory instance for session opening
   */
  @Bean
  public SessionFactory sessionFactory() {
    return new Configuration().configure("/hibernate/hibernate.cfg.xml").buildSessionFactory();
  }
}
