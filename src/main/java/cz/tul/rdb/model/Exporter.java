package cz.tul.rdb.model;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import cz.tul.rdb.dao.*;
import cz.tul.rdb.entity.Jizda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class Exporter {
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
    public Exporter(AutobusDao autobusDao, JizdaDao jizdaDao, JizdenkaDao jizdenkaDao, KlientDao klientDao, KontaktDao kontaktDao, LokalitaDao lokalitaDao, MezizastavkaDao mezizastavkaDao, RidicDao ridicDao, TrasyDao trasyDao, TypKontaktuDao typKontaktuDao, ZnackaDao znackaDao) {
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

    public boolean export(File file) {
        boolean success = true;
        File selectedFile = new File(file.getPath() + "/jizda.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, jizdaDao.listJizda());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, jizdaDao.listJizda());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath() + "/autobus.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, autobusDao.listAutobus());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, autobusDao.listAutobus());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath() + "/jizdenka.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, jizdenkaDao.listJizdenka());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, jizdenkaDao.listJizdenka());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

       selectedFile = new File(file.getPath() + "/klient.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, klientDao.listKlient());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, klientDao.listKlient());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath() + "/kontakt.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, kontaktDao.listKontakt());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, kontaktDao.listKontakt());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath() + "/lokalita.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, lokalitaDao.listLokalita());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, lokalitaDao.listLokalita());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath() + "/mezizastavka.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, mezizastavkaDao.listMezizastavka());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, mezizastavkaDao.listMezizastavka());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

       selectedFile = new File(file.getPath() + "/ridic.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, ridicDao.listRidic());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, ridicDao.listRidic());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath() + "/trasy.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, trasyDao.listTrasy());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, trasyDao.listTrasy());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath() + "/typkontaktu.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, typKontaktuDao.listTypKontaktu());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, typKontaktuDao.listTypKontaktu());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }

        selectedFile = new File(file.getPath() + "/znacka.csv");
        if (selectedFile.exists()) {
            exportObject(selectedFile, znackaDao.listZnacka());
        } else {
            try {
                selectedFile.createNewFile();
                exportObject(selectedFile, znackaDao.listZnacka());
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            }
        }
        return success;
    }

    public <T> void exportObject(File file, List<T> objects) {
        try (FileWriter writer = new FileWriter(file.getPath());
             BufferedWriter bw = new BufferedWriter(writer)) {
            for (int i = 0; i < objects.size(); i++) {
                bw.write(objects.get(i).toString());
            }
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }


    }
}

