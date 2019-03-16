package entity;

public class Trasy implements Entity {

  private String linka;
  private String odkud;
  private String kam;

  public Trasy(String linka, String odkud, String kam) {
    this.linka = linka;
    this.odkud = odkud;
    this.kam = kam;
  }

  public String getLinka() {
    return linka;
  }

  public void setLinka(String linka) {
    this.linka = linka;
  }

  public String getOdkud() {
    return odkud;
  }

  public void setOdkud(String odkud) {
    this.odkud = odkud;
  }

  public String getKam() {
    return kam;
  }

  public void setKam(String kam) {
    this.kam = kam;
  }

  @Override
  public String toString() {
    return " INSERT INTO Trasy(linka, odkud, kam) VALUES ('" + this.linka + "','" + this.odkud + "','" + this.kam + "')";
  }
}
