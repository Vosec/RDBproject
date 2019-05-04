package cz.tul.rdb.entity;

public class Znacka implements Entity {

  private String znacka;

  public Znacka(String znacka) {
    this.znacka = znacka;
  }

  public Znacka() {
  }

  public String getZnacka() {
    return znacka;
  }

  public void setZnacka(String znacka) {
    this.znacka = znacka;
  }

  @Override
  public String toString() {
    return this.znacka + "\n";
  }
}
