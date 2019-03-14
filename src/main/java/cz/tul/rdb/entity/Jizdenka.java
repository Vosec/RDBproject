package cz.tul.rdb.entity;

import java.sql.Timestamp;

public class Jizdenka implements Entity {

  private String linka;
  private String email;
  private Timestamp cas;
  private Integer cislo;

  public Jizdenka(String linka, String email, Timestamp cas, Integer cislo) {
    this.linka = linka;
    this.email = email;
    this.cas = cas;
    this.cislo = cislo;
  }

  public String getLinka() {
    return linka;
  }

  public void setLinka(String linka) {
    this.linka = linka;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Timestamp getCas() {
    return cas;
  }

  public void setCas(Timestamp cas) {
    this.cas = cas;
  }

  public Integer getCislo() {
    return cislo;
  }

  public void setCislo(Integer cislo) {
    this.cislo = cislo;
  }

  @Override
  public String toString() {
    return " INSERT INTO Jizdenka(linka, email, cas, cislo) VALUES (" + this.linka + "," + this.email + "," + this.cas + "," + this.cislo + ")";
  }
}
