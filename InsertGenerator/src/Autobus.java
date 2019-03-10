public class Autobus {
    private String spz;

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public String getSpz() {
        return spz;
    }

    public String getZnacka() {
        return znacka;
    }

    public Autobus(String spz, String znacka) {
        this.spz = spz;
        this.znacka = znacka;
    }

    private String znacka;
}
