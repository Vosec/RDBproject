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
        File selectedFile = new File(file.getPath()+"/autobus.csv");
        if (selectedFile.exists()) {
                try {
                    parseAutobus(selectedFile.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        selectedFile = new File(file.getPath()+"/jizdenka.csv");
        if (selectedFile.exists()) {
            try {
                parseJizdenka(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        selectedFile = new File(file.getPath()+"/jizda.csv");
        if (selectedFile.exists()) {
            try {
                List<Jizda> jizdy = parseJizda(selectedFile.getPath());
                for (Jizda jizda : jizdy) {
                    jizdaDao.createJizda(jizda);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath()+"/klient.csv");
        if (selectedFile.exists()) {
            try {
                parseKlient(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath()+"/kontakt.csv");
        if (selectedFile.exists()) {
            try {
                parseKontakt(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath()+"/lokalita.csv");
        if (selectedFile.exists()) {
            try {
                parseLokalita(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath()+"/mezizastavka.csv");
        if (selectedFile.exists()) {
            try {
                parseMezizastavka(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath()+"/ridic.csv");
        if (selectedFile.exists()) {
            try {
                parseRidic(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath()+"/trasy.csv");
        if (selectedFile.exists()) {
            try {
                parseTrasa(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath()+"/typkontaktu.csv");
        if (selectedFile.exists()) {
            try {
                parseTypKontaktu(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath()+"/znacka.csv");
        if (selectedFile.exists()) {
            try {
                parseZnacka(selectedFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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

    public void parseAutobus(String autobusCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(autobusCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                autobusDao.createAutobus(new Autobus(nextRecord[0], nextRecord[1]));
            }
        }
    }

    public void parseJizdenka(String jizdenkaCSVPath) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(jizdenkaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            double time;
            String email;
            while ((nextRecord = csvReader.readNext()) != null) {
                time = Double.parseDouble(nextRecord[2]) * 1000;
                if(nextRecord[1].equals("N")){
                    email = "null";
                }else{
                    email = nextRecord[1];
                }
                jizdenkaDao.createJizdenka(new Jizdenka(nextRecord[0],email,new Timestamp((long) time),BigInteger.valueOf(Long.valueOf(nextRecord[3]))));
            }
        }
    }

    public void parseKlient(String klientCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(klientCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                klientDao.createKlient(new Klient(nextRecord[0],nextRecord[1],nextRecord[2]));
            }
        }
    }

    public void parseKontakt(String kontaktCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(kontaktCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                kontaktDao.createKontakt(new Kontakt(nextRecord[0],nextRecord[1],nextRecord[2]));
            }
        }
    }

    public void parseLokalita(String lokalitaCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(lokalitaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                lokalitaDao.createLokalita(new Lokalita(nextRecord[0]));
            }
        }
    }

    public void parseMezizastavka(String mezizastavkaCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(mezizastavkaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                mezizastavkaDao.createMezizastavka(new Mezizastavka(nextRecord[0],nextRecord[1]));
            }
        }
    }

    public void parseRidic(String ridicCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(ridicCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                ridicDao.createRidic(new Ridic(nextRecord[0],nextRecord[1],nextRecord[2]));
            }
        }
    }

    public void parseTrasa(String trasaCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(trasaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                trasyDao.createTrasy(new Trasy(nextRecord[0],nextRecord[1],nextRecord[2]));
            }
        }
    }

    public void parseTypKontaktu(String typKontaktuCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(typKontaktuCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                typKontaktuDao.createTypKontaktu(new TypKontaktu(nextRecord[0]));
            }
        }
    }

    public void parseZnacka(String znackaCSVPath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(znackaCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                znackaDao.createZnacka(new Znacka(nextRecord[0]));
            }
        }
    }

}


