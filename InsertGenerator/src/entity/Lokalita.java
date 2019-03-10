package entity;

public class Lokalita implements Entity {

  private String nazev;

  public Lokalita(String nazev) {
    this.nazev = nazev;
  }

  public String getNazev() {
    return nazev;
  }

  public void setNazev(String nazev) {
    this.nazev = nazev;
  }

  @Override
  public String toString() {
    return " INSERT INTO Lokalita(nazev) VALUES (" + this.nazev + ")";
  }
}
