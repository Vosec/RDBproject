public class Klient {
    private String email;
    private String jmeno;
    private String prijmeni;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getEmail() {
        return email;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public Klient(String email, String jmeno, String prijmeni) {
        this.email = email;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }
}
