package cz.tul.rdb.model;

import cz.tul.rdb.dao.AutobusDao;
import cz.tul.rdb.dao.JizdaDao;
import cz.tul.rdb.entity.Jizda;
import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parser {

  private final AutobusDao autobusDao;
  private final JizdaDao jizdaDao;

  @Autowired
  public Parser(AutobusDao autobusDao, JizdaDao jizdaDao) {
    this.autobusDao = autobusDao;
    this.jizdaDao = jizdaDao;
  }

  /**
   * Parses given CSV file to db entities
   *
   * @param file input CSV
   * @return DataVerifier result
   */
  public boolean parse(File file) {
    //TODO parse csv

    /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    Date parsedDate = null;
    try {
      parsedDate = dateFormat.parse("2019-03-19 11:30:00.000");
      if (parsedDate.getMinutes()%10 == 0) {
        parsedDate.setSeconds(7*(int)(parsedDate.getMinutes()/10));
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());*/

    List<Jizda> jizdy = jizdaDao.listJizda();
    //TODO možná kontrolovat i jizdenky timestamp

    return DataVerifier.verifyData(jizdy);
  }
}
