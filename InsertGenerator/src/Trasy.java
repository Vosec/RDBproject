public class Trasy {
    private String linka;
    private String odkud;
    private String kam;

    public void setLinka(String linka) {
        this.linka = linka;
    }

    public void setOdkud(String odkud) {
        this.odkud = odkud;
    }

    public void setKam(String kam) {
        this.kam = kam;
    }

    public String getLinka() {
        return linka;
    }

    public String getOdkud() {
        return odkud;
    }

    public String getKam() {
        return kam;
    }

    public Trasy(String linka, String odkud, String kam) {
        this.linka = linka;
        this.odkud = odkud;
        this.kam = kam;
    }
}
