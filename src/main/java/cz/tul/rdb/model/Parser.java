package cz.tul.rdb.model;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import cz.tul.rdb.dao.AutobusDao;
import cz.tul.rdb.dao.JizdaDao;
import cz.tul.rdb.entity.Jizda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

@Component
public class Parser {

    private final AutobusDao autobusDao;
    private final JizdaDao jizdaDao;

    @Autowired
    public Parser(AutobusDao autobusDao, JizdaDao jizdaDao) {
        this.autobusDao = autobusDao;
        this.jizdaDao = jizdaDao;
    }


    /**
     * Parses given CSV file to db entities
     *
     * @param file input CSV
     * @return DataVerifier result
     */
    public boolean parse(File file) {

        try {
            List<Jizda> jizdy = parseJizda(file.getPath());
            for (Jizda jizda : jizdy) {
                jizdaDao.createJizda(jizda);
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
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(jizdyCSVPath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            double time = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
                time = Double.parseDouble(nextRecord[3]) * 1000;
                jizdy.add(new Jizda(nextRecord[0], nextRecord[1], nextRecord[2], new Timestamp((long) time)));
            }
        }
        return jizdy;
    }


}


