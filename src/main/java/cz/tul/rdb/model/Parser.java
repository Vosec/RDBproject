package cz.tul.rdb.model;

import cz.tul.rdb.dao.AutobusDao;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parser {

  private final AutobusDao autobusDao;

  @Autowired
  public Parser(AutobusDao autobusDao) {
    this.autobusDao = autobusDao;
  }

  /**
   * Parses given CSV file to db entities
   *
   * @param file input CSV
   * @return DataVerifier result
   */
  public boolean parse(File file) {
    //TODO parse csv
    //TODO repair csv

    //autobusDao.addAutobus("3L33333", "Mercedes");

    return DataVerifier.verifyData();
  }
}
