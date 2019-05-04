package cz.tul.rdb.entity;

import java.io.Serializable;

public class Mezizastavka implements Entity, Serializable {

  private String nazev;
  private String linka;

  public Mezizastavka(String nazev, String linka) {
    this.nazev = nazev;
    this.linka = linka;
  }

  public Mezizastavka() {
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
    return this.nazev + "," + this.linka + "\n";
  }
}
