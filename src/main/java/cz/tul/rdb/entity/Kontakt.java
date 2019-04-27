package cz.tul.rdb.entity;

public class Kontakt implements Entity {

  private String hodnota;
  private String typ;
  private String cislo_rp;

  public Kontakt(String hodnota, String typ, String cislo_rp) {
    this.hodnota = hodnota;
    this.typ = typ;
    this.cislo_rp = cislo_rp;
  }

  public Kontakt() {
  }

  public String getHodnota() {
    return hodnota;
  }

  public void setHodnota(String hodnota) {
    this.hodnota = hodnota;
  }

  public String getTyp() {
    return typ;
  }

  public void setTyp(String typ) {
    this.typ = typ;
  }

  public String getCislo_rp() {
    return cislo_rp;
  }

  public void setCislo_rp(String cislo_rp) {
    this.cislo_rp = cislo_rp;
  }

  @Override
  public String toString() {
    return " INSERT INTO Kontakt(hodnota, typ, cislo_rp) VALUES (" + this.hodnota + "," + this.typ + "," + this.cislo_rp + ")";
  }
}
