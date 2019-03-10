import entity.Autobus;
import entity.Entity;
import entity.Jizda;
import entity.Jizdenka;
import entity.Klient;
import entity.Kontakt;
import entity.Lokalita;
import entity.Mezizastavka;
import entity.Ridic;
import entity.Trasy;
import entity.TypKontaktu;
import entity.Znacka;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    List<Entity> entity = new ArrayList<>();

    Znacka znacka = new Znacka("Karosa");
    Znacka znacka1 = new Znacka("Volvo");
    Znacka znacka2 = new Znacka("Mercedes");

    entity.addAll(Arrays.asList(znacka, znacka1, znacka2));

    Lokalita lok = new Lokalita("Liberec");
    Lokalita lok1 = new Lokalita("Praha");
    Lokalita lok4 = new Lokalita("Mladá Boleslav");
    Lokalita lok2 = new Lokalita("Brno");
    entity.addAll(Arrays.asList(lok, lok1, lok2, lok4));

    Autobus autobus = new Autobus("2L86542", znacka.getZnacka());
    Autobus autobus1 = new Autobus("5A68245", znacka1.getZnacka());

    entity.addAll(Arrays.asList(autobus, autobus1));

    Trasy trasa1 = new Trasy("1", lok.getNazev(), lok1.getNazev());
    Mezizastavka mezi1 = new Mezizastavka(lok4.getNazev(), trasa1.getLinka());

    Trasy trasa2 = new Trasy("2", lok1.getNazev(), lok2.getNazev());
    entity.addAll(Arrays.asList(trasa1, trasa2, mezi1));

    Ridic r = new Ridic("154a587", "Jan", "Blažek");
    Ridic r1 = new Ridic("154b587", "Tomáš", "Dušek");
    Ridic r2 = new Ridic("154c587", "Petr", "Navrátil");
    entity.addAll(Arrays.asList(r, r1, r2));

    TypKontaktu tk = new TypKontaktu("email");
    TypKontaktu tk1 = new TypKontaktu("mobil");
    entity.addAll(Arrays.asList(tk, tk1));

    Kontakt kont = new Kontakt("584695748", tk1.getTyp(), r.getCislo_rp());
    Kontakt kont2 = new Kontakt("126487422", tk1.getTyp(), r.getCislo_rp());
    Kontakt kont3 = new Kontakt("tom.dus@gmail.com", tk.getTyp(), r1.getCislo_rp());
    Kontakt kont4 = new Kontakt("p.n@gmail.com", tk.getTyp(), r2.getCislo_rp());
    entity.addAll(Arrays.asList(kont, kont2, kont3, kont4));

    Timestamp ts = new Timestamp(1254652);
    Timestamp ts1 = new Timestamp(59485465);
    Timestamp ts2 = new Timestamp(1121564);

    Jizda j = new Jizda(trasa1.getLinka(), autobus.getSpz(), r.getCislo_rp(), ts);
    Jizda j1 = new Jizda(trasa2.getLinka(), autobus1.getSpz(), r1.getCislo_rp(), ts1);
    entity.addAll(Arrays.asList(j, j1));

    Jizdenka jz = new Jizdenka(j.getLinka(), null, j.getCas(), 1);

    Klient k1 = new Klient("on@gmail.com", "Ondra", "Pasek");
    Jizdenka jz1 = new Jizdenka(j1.getLinka(), k1.getEmail(), j1.getCas(), 2);
    entity.addAll(Arrays.asList(jz, jz1, k1));

    List<String> inserts = new ArrayList<>();
    for (Entity e : entity) {
      inserts.add(e.toString());
    }
    saveToFile(inserts);

  }

  private static void saveToFile(List<String> inserts) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter("inserts.txt");
    for (String insert : inserts) {
      pw.write(insert + "\n");
    }
    pw.flush();
  }

}
