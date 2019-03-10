package entity;

public class Ridic implements Entity {

  private String cislo_rp;
  private String jmeno;
  private String prijmeni;

  public Ridic(String cislo_rp, String jmeno, String prijmeni) {
    this.cislo_rp = cislo_rp;
    this.jmeno = jmeno;
    this.prijmeni = prijmeni;
  }

  public String getCislo_rp() {
    return cislo_rp;
  }

  public void setCislo_rp(String cislo_rp) {
    this.cislo_rp = cislo_rp;
  }

  public String getJmeno() {
    return jmeno;
  }

  public void setJmeno(String jmeno) {
    this.jmeno = jmeno;
  }

  public String getPrijmeni() {
    return prijmeni;
  }

  public void setPrijmeni(String prijmeni) {
    this.prijmeni = prijmeni;
  }

  @Override
  public String toString() {
    return " INSERT INTO Ridic(cislo_rp, jmeno, prijmeni) VALUES (" + this.cislo_rp + "," + this.jmeno + "," + this.prijmeni + ")";
  }
}
