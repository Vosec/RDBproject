package cz.tul.rdb.entity;

public class Mezizastavka implements Entity {

  private String nazev;
  private String linka;

  public Mezizastavka(String nazev, String linka) {
    this.nazev = nazev;
    this.linka = linka;
  }

  public String getNazev() {
    return nazev;
  }

  public void setNazev(String nazev) {
    this.nazev = nazev;
  }

  public String getLinka() {
    return linka;
  }

  public void setLinka(String linka) {
    this.linka = linka;
  }

  @Override
  public String toString() {
    return " INSERT INTO Mezizastavka(nazev, linka) VALUES (" + this.nazev + "," + this.linka + ")";
  }
}
