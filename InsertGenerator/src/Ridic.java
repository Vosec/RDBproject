public class Ridic {
    private String cislo_rp;
    private String jmeno;

    public void setCislo_rp(String cislo_rp) {
        this.cislo_rp = cislo_rp;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getCislo_rp() {
        return cislo_rp;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public Ridic(String cislo_rp, String jmeno, String prijmeni) {
        this.cislo_rp = cislo_rp;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }

    private String prijmeni;
}
