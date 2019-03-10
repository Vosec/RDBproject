import java.sql.Timestamp;

public class Jizda {
    private String linka;
    private String spz;
    private String cislo_rp;
    private Timestamp cas;

    public void setLinka(String linka) {
        this.linka = linka;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public void setCislo_rp(String cislo_rp) {
        this.cislo_rp = cislo_rp;
    }

    public void setCas(Timestamp cas) {
        this.cas = cas;
    }

    public String getLinka() {
        return linka;
    }

    public String getSpz() {
        return spz;
    }

    public String getCislo_rp() {
        return cislo_rp;
    }

    public Timestamp getCas() {
        return cas;
    }

    public Jizda(String linka, String spz, String cislo_rp, Timestamp cas) {
        this.linka = linka;
        this.spz = spz;
        this.cislo_rp = cislo_rp;
        this.cas = cas;
    }
}
