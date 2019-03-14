package cz.tul.rdb.entity;

public class Klient implements Entity {

  private String email;
  private String jmeno;
  private String prijmeni;

  public Klient(String email, String jmeno, String prijmeni) {
    this.email = email;
    this.jmeno = jmeno;
    this.prijmeni = prijmeni;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
    return " INSERT INTO Klient(email, jmeno, prijmeni) VALUES (" + this.email + "," + this.jmeno + "," + this.prijmeni + ")";
  }
}
