package cz.tul.rdb.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;

public class Jizdenka implements Entity {

  private String linka;
  private String email;
  private Timestamp cas;
  private BigInteger cislo;

  public Jizdenka(String linka, String email, Timestamp cas, BigInteger cislo) {
    this.linka = linka;
    this.email = email;
    this.cas = cas;
    this.cislo = cislo;
  }

  public Jizdenka() {
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

  public BigInteger getCislo() {
    return cislo;
  }

  public void setCislo(BigInteger cislo) {
    this.cislo = cislo;
  }

  @Override
  public String toString() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(cas);
    double time = calendar.getTimeInMillis();
    if(this.email.equals("null")){
      email = "\\N";
    }

    return  this.linka + "," + this.email + "," + String.format (Locale.ROOT,"%.3f", time/1000.0) + "," + this.cislo + "\n";
  }
}
