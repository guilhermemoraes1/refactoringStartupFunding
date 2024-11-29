package com.checkr.interviews;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

import com.opencsv.CSVReader;

public class readFile  {

    public static ArrayList<String[]> getCsvData() throws IOException {
        ArrayList<String[]> csvData = new ArrayList<>();
        
        CSVReader reader = new CSVReader(new FileReader("startup_funding.csv"));
        String[] row;
    
        while((row = reader.readNext()) != null) {
            csvData.add(row);
        }
    
        reader.close();
        csvData.remove(0);
        
        return csvData;
    }

}
