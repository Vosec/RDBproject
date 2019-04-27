package cz.tul.rdb.model;

import com.opencsv.CSVReader;
import cz.tul.rdb.dao.*;
import cz.tul.rdb.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;

@Component
public class Parser {

    private final AutobusDao autobusDao;
    private final JizdaDao jizdaDao;
    private final JizdenkaDao jizdenkaDao;
    private final KlientDao klientDao;
    private final KontaktDao kontaktDao;
    private final LokalitaDao lokalitaDao;
    private final MezizastavkaDao mezizastavkaDao;
    private final RidicDao ridicDao;
    private final TrasyDao trasyDao;
    private final TypKontaktuDao typKontaktuDao;
    private final ZnackaDao znackaDao;

    @Autowired
    public Parser(AutobusDao autobusDao, JizdaDao jizdaDao, JizdenkaDao jizdenkaDao, KlientDao klientDao, KontaktDao kontaktDao, LokalitaDao lokalitaDao, MezizastavkaDao mezizastavkaDao, RidicDao ridicDao, TrasyDao trasyDao, TypKontaktuDao typKontaktuDao, ZnackaDao znackaDao) {
        this.autobusDao = autobusDao;
        this.jizdaDao = jizdaDao;
        this.jizdenkaDao = jizdenkaDao;
        this.klientDao = klientDao;
        this.kontaktDao = kontaktDao;
        this.lokalitaDao = lokalitaDao;
        this.mezizastavkaDao = mezizastavkaDao;
        this.ridicDao = ridicDao;
        this.trasyDao = trasyDao;
        this.typKontaktuDao = typKontaktuDao;
        this.znackaDao = znackaDao;
    }


    /**
     * Parses given CSV file to db entities
     *
     * @param file input CSV
     * @return DataVerifier result
     */
    public boolean parse(File file) {

        try {
            List<Autobus> autobusy = parseAutobus(file.getPath());
            for (Autobus bus: autobusy) {
                autobusDao.createAutobus(bus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Jizdenka> jizdenky = parseJizdenka(file.getPath());
            for (Jizdenka jizdenka: jizdenky) {
                jizdenkaDao.createJizdenka(jizdenka);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Jizda> jizdy = parseJizda(file.getPath());
            for (Jizda jizda : jizdy) {
                jizdaDao.createJizda(jizda);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Klient> klienti = parseKlient(file.getPath());
            for (Klient klient : klienti) {
                klientDao.createKlient(klient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Kontakt> kontakty = parseKontakt(file.getPath());
            for (Kontakt kontakt : kontakty) {
                kontaktDao.createKontakt(kontakt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Lokalita> lokality = parseLokalita(file.getPath());
            for (Lokalita lokalita : lokality) {
                lokalitaDao.createLokalita(lokalita);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Mezizastavka> mezizastavky = parseMezizastavka(file.getPath());
            for (Mezizastavka mezizastavka : mezizastavky) {
                mezizastavkaDao.createMezizastavka(mezizastavka);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Ridic> ridici = parseRidic(file.getPath());
            for (Ridic ridic : ridici) {
                ridicDao.createRidic(ridic);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Trasy> trasy= parseTrasa(file.getPath());
            for (Trasy trasa : trasy) {
                trasyDao.createTrasy(trasa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<TypKontaktu> typyKontaktu= parseTypKontaktu(file.getPath());
            for (TypKontaktu typKontaktu : typyKontaktu) {
                typKontaktuDao.createTypKontaktu(typKontaktu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Znacka> znacky= parseZnacka(file.getPath());
            for (Znacka znacka : znacky) {
                znackaDao.createZnacka(znacka);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    Date parsedDate = null;
    try {
      parsedDate = dateFormat.parse("2019-03-19 11:30:00.000");
      if (parsedDate.getMinutes()%10 == 0) {
        parsedDate.setSeconds(7*(int)(parsedDate.getMinutes()/10));
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());*/

        List<Jizda> jizdy = jizdaDao.listJizda();
        //TODO možná kontrolovat i jizdenky timestamp

        return DataVerifier.verifyData(jizdy);
    }


    public List<Jizda> parseJizda(String jizdyCSVPath) throws IOException {
        List<Jizda> jizdy = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(jizdyCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            double time;
            while ((nextRecord = csvReader.readNext()) != null) {
                time = Double.parseDouble(nextRecord[3]) * 1000;
                jizdy.add(new Jizda(nextRecord[0], nextRecord[1], nextRecord[2], new Timestamp((long) time)));
            }
        }
        return jizdy;
    }

    public List<Autobus> parseAutobus(String autobusCSVPath) throws IOException {
        List<Autobus> autobusy = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(autobusCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                autobusy.add(new Autobus(nextRecord[0], nextRecord[1]));
            }
        }
        return autobusy;
    }

    public List<Jizdenka> parseJizdenka(String jizdenkaCSVPath) throws IOException {
        List<Jizdenka> jizdenky = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(jizdenkaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            double time;
            String email;
            while ((nextRecord = csvReader.readNext()) != null) {
                time = Double.parseDouble(nextRecord[2]) * 1000;
                if(nextRecord[1].equals("\\N")){
                    email = "null";
                }else{
                    email = nextRecord[1];
                }
                jizdenky.add(new Jizdenka(nextRecord[0],email,new Timestamp((long) time),BigInteger.valueOf(Long.valueOf(nextRecord[3]))));
            }
        }
        return jizdenky;
    }

    public List<Klient> parseKlient(String klientCSVPath) throws IOException {
        List<Klient> klienti = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(klientCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                klienti.add(new Klient(nextRecord[0],nextRecord[1],nextRecord[2]));
            }
        }
        return klienti;
    }

    public List<Kontakt> parseKontakt(String kontaktCSVPath) throws IOException {
        List<Kontakt> kontakty = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(kontaktCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                kontakty.add(new Kontakt(nextRecord[0],nextRecord[1],nextRecord[2]));
            }
        }
        return kontakty;
    }

    public List<Lokalita> parseLokalita(String lokalitaCSVPath) throws IOException {
        List<Lokalita> lokality = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(lokalitaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                lokality.add(new Lokalita(nextRecord[0]));
            }
        }
        return lokality;
    }

    public List<Mezizastavka> parseMezizastavka(String mezizastavkaCSVPath) throws IOException {
        List<Mezizastavka> mezizastavky = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(mezizastavkaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                mezizastavky.add(new Mezizastavka(nextRecord[0],nextRecord[1]));
            }
        }
        return mezizastavky;
    }

    public List<Ridic> parseRidic(String ridicCSVPath) throws IOException {
        List<Ridic> ridici = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(ridicCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                ridici.add(new Ridic(nextRecord[0],nextRecord[1],nextRecord[2]));
            }
        }
        return ridici;
    }

    public List<Trasy> parseTrasa(String trasaCSVPath) throws IOException {
        List<Trasy> trasy = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(trasaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                trasy.add(new Trasy(nextRecord[0],nextRecord[1],nextRecord[2]));
            }
        }
        return trasy;
    }

    public List<TypKontaktu> parseTypKontaktu(String typKontaktuCSVPath) throws IOException {
        List<TypKontaktu> typyKontaktu = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(typKontaktuCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                typyKontaktu.add(new TypKontaktu(nextRecord[0]));
            }
        }
        return typyKontaktu;
    }

    public List<Znacka> parseZnacka(String znackaCSVPath) throws IOException {
        List<Znacka> znacky = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(znackaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                znacky.add(new Znacka(nextRecord[0]));
            }
        }
        return znacky;
    }

}


