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
        return success;
    }

    public <T> void exportObject(File file, List<T> objects) {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(file.getPath()));
        ) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            try {
                beanToCsv.write(objects);
            } catch (CsvDataTypeMismatchException e) {
                e.printStackTrace();
            } catch (CsvRequiredFieldEmptyException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

