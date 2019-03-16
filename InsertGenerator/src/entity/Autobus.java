package entity;

public class Autobus implements Entity {

  private String spz;
  private String znacka;


  public Autobus(String spz, String znacka) {
    this.spz = spz;
    this.znacka = znacka;
  }

  public String getSpz() {
    return spz;
  }

  public void setSpz(String spz) {
    this.spz = spz;
  }

  public String getZnacka() {
    return znacka;
  }

  public void setZnacka(String znacka) {
    this.znacka = znacka;
  }

  @Override
  public String toString() {
    return " INSERT INTO Autobus(spz, znacka) VALUES ('" + this.spz + "','" + this.znacka + "')";
  }
}
