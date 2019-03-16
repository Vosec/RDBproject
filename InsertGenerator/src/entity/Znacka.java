package entity;

public class Znacka implements Entity {

  private String znacka;

  public Znacka(String znacka) {
    this.znacka = znacka;
  }

  public String getZnacka() {
    return znacka;
  }

  public void setZnacka(String znacka) {
    this.znacka = znacka;
  }

  @Override
  public String toString() {
    return " INSERT INTO Znacka(znacka) VALUES ('" + this.znacka + "')";
  }
}
