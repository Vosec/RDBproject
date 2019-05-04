package cz.tul.rdb.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;

public class Jizda implements Entity, Serializable {

  private String linka;
  private String spz;
  private String cislo_rp;
  private Timestamp cas;

  public Jizda(String linka, String spz, String cislo_rp, Timestamp cas) {
    this.linka = linka;
    this.spz = spz;
    this.cislo_rp = cislo_rp;
    this.cas = cas;
  }

  public Jizda() {
  }

  public String getLinka() {
    return linka;
  }

  public void setLinka(String linka) {
    this.linka = linka;
  }

  public String getSpz() {
    return spz;
  }

  public void setSpz(String spz) {
    this.spz = spz;
  }

  public String getCislo_rp() {
    return cislo_rp;
  }

  public void setCislo_rp(String cislo_rp) {
    this.cislo_rp = cislo_rp;
  }

  public Timestamp getCas() {
    return cas;
  }

  public void setCas(Timestamp cas) {
    this.cas = cas;
  }


  @Override
  public String toString() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(cas);
    double time = calendar.getTimeInMillis();
    return this.linka + "," + this.spz + "," + this.cislo_rp + "," +String.format (Locale.ROOT,"%.3f", time/1000.0)+"\n";
  }
}
