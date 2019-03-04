package sample.model;

import java.io.File;

public class Parser {

  /**
   * Parses given CSV file to db entities
   *
   * @param file input CSV
   * @return DataVerifier result
   */
  public boolean parse(File file) {
    //TODO parse CSV

    return DataVerifier.verifyData();
  }
}
