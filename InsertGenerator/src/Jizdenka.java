import java.sql.Timestamp;

public class Jizdenka {
    private String linka;
    private String email;
    private Timestamp cas;
    private Integer cislo;

    public void setLinka(String linka) {
        this.linka = linka;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCas(Timestamp cas) {
        this.cas = cas;
    }

    public void setCislo(Integer cislo) {
        this.cislo = cislo;
    }

    public String getLinka() {
        return linka;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getCas() {
        return cas;
    }

    public Integer getCislo() {
        return cislo;
    }

    public Jizdenka(String linka, String email, Timestamp cas, Integer cislo) {
        this.linka = linka;
        this.email = email;
        this.cas = cas;
        this.cislo = cislo;
    }
}
