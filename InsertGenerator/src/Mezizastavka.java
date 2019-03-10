public class Mezizastavka {
    private String nazev;
    private String linka;

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setLinka(String linka) {
        this.linka = linka;
    }

    public String getNazev() {
        return nazev;
    }

    public String getLinka() {
        return linka;
    }

    public Mezizastavka(String nazev, String linka) {
        this.nazev = nazev;
        this.linka = linka;
    }
}
