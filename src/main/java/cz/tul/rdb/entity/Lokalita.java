package cz.tul.rdb.entity;

public class Lokalita implements Entity {

  private String nazev;

  public Lokalita(String nazev) {
    this.nazev = nazev;
  }

  public Lokalita() {
  }

  public String getNazev() {
    return nazev;
  }

  public void setNazev(String nazev) {
    this.nazev = nazev;
  }

  @Override
  public String toString() {
    return this.nazev + "\n";
  }
}
