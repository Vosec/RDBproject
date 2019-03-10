public class Kontakt {
    private String hodnota;
    private String typ;
    private String cislo_rp;

    public void setHodnota(String hodnota) {
        this.hodnota = hodnota;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setCislo_rp(String cislo_rp) {
        this.cislo_rp = cislo_rp;
    }

    public String getHodnota() {
        return hodnota;
    }

    public String getTyp() {
        return typ;
    }

    public String getCislo_rp() {
        return cislo_rp;
    }

    public Kontakt(String hodnota, String typ, String cislo_rp) {
        this.hodnota = hodnota;
        this.typ = typ;
        this.cislo_rp = cislo_rp;
    }
}
