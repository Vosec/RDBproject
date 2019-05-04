package cz.tul.rdb.entity;

public class TypKontaktu implements Entity {

  private String typ;

  public TypKontaktu(String typ) {
    this.typ = typ;
  }

  public TypKontaktu() {
  }

  public String getTyp() {
    return typ;
  }

  public void setTyp(String typ) {
    this.typ = typ;
  }

  @Override
  public String toString() {
    return this.typ + "\n";
  }
}
