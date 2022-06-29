package com.example.restservice;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Service zum Abrufen von Betriebsstellen anhand des Betriebsstellen-Codes
 */
@Service
public class BsvService {
    private Map<String, Bsv> data;

    /**
     * Liest CSV Datei vom Pfad ein und stellt sie als Bsv Objekte in einer HashMap bereit
     */
    @PostConstruct
    public void init() {
        data = new HashMap<>();
        File file = new File("dbchallenge/rest-service/src/main/resources/Data.csv");

        try {
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader reader = new CSVReaderBuilder(new FileReader(file, StandardCharsets.UTF_8)).withCSVParser(parser).withSkipLines(1).build();
            String[] nextline;
            while ((nextline = reader.readNext()) != null) {
                if (nextline != null) {
                    data.put(nextline[1], new Bsv(nextline));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Liefert ein BSV Objekt anhand des Betriebsstellenverzeichnisses zurück
     * @param code der Betriebsstelle
     * @return Repräsentation der Betriebsstelle als BSV Objekt
     */
    public Bsv getBsvByCode(String code) {
        return data.get(code.toUpperCase());
    }
}