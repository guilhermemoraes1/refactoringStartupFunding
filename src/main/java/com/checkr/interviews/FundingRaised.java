package com.checkr.interviews;

import java.util.*;
import java.io.IOException;

public class FundingRaised {

    public static List<String[]> iterate(int ind, List<String[]> csvData, String option) {
        List<String[]> results = new ArrayList<>();
            
        for(int i = 0; i < csvData.size(); i++) {
            if(csvData.get(i)[ind].equals(option)) {
                results.add(csvData.get(i));
            }
        }
        return results;
    }

    private static Map<String, String> createMap(String[] row) {
        Map<String, String> mapped = new HashMap<>();
        mapped.put("permalink", row[0]);
        mapped.put("company_name", row[1]);
        mapped.put("number_employees", row[2]);
        mapped.put("category", row[3]);
        mapped.put("city", row[4]);
        mapped.put("state", row[5]);
        mapped.put("funded_date", row[6]);
        mapped.put("raised_amount", row[7]);
        mapped.put("raised_currency", row[8]);
        mapped.put("round", row[9]);

        return mapped;
        // {round=a, city=Palo Alto, company_name=Facebook, funded_date=1-May-05, number_employees=450, state=CA, permalink=facebook, category=web, raised_amount=12700000, raised_currency=USD}
    }


    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        // codigo refatorado
        List<String[]> csvData = readFile.getCsvData();

        if(options.containsKey("company_name")) {
            // codigo vira metodo
            csvData = iterate(1, csvData, options.get("company_name"));
        }

        if(options.containsKey("city")) {
            csvData = iterate(4, csvData, options.get("city"));
        }

        if(options.containsKey("state")) {
            csvData = iterate(5, csvData, options.get("state"));
        }

        if(options.containsKey("round")) {
            csvData = iterate(9, csvData, options.get("round"));
        }

        List<Map<String, String>> output = new ArrayList<>();
        for (String[] row : csvData) {
            output.add(createMap(row));
        }
        
        return output;
    }

    public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<String[]> csvData = readFile.getCsvData();

        Map<String, String> mapped = new HashMap<String, String> ();

        for(int i = 0; i < csvData.size(); i++) {
            if(options.containsKey("company_name")) {
                if(csvData.get(i)[1].equals(options.get("company_name"))) {
                    mapped.put("permalink", csvData.get(i)[0]);
                    mapped.put("company_name", csvData.get(i)[1]);
                    mapped.put("number_employees", csvData.get(i)[2]);
                    mapped.put("category", csvData.get(i)[3]);
                    mapped.put("city", csvData.get(i)[4]);
                    mapped.put("state", csvData.get(i)[5]);
                    mapped.put("funded_date", csvData.get(i)[6]);
                    mapped.put("raised_amount", csvData.get(i)[7]);
                    mapped.put("raised_currency", csvData.get(i)[8]);
                    mapped.put("round", csvData.get(i)[9]);
                } else {
                    continue;
                }
            }

            if(options.containsKey("city")) {
                if(csvData.get(i)[4].equals(options.get("city"))) {
                    mapped.put("permalink", csvData.get(i)[0]);
                    mapped.put("company_name", csvData.get(i)[1]);
                    mapped.put("number_employees", csvData.get(i)[2]);
                    mapped.put("category", csvData.get(i)[3]);
                    mapped.put("city", csvData.get(i)[4]);
                    mapped.put("state", csvData.get(i)[5]);
                    mapped.put("funded_date", csvData.get(i)[6]);
                    mapped.put("raised_amount", csvData.get(i)[7]);
                    mapped.put("raised_currency", csvData.get(i)[8]);
                    mapped.put("round", csvData.get(i)[9]);
                } else {
                    continue;
                }
            }

            if(options.containsKey("state")) {
                if(csvData.get(i)[5].equals(options.get("state"))) {
                    mapped.put("permalink", csvData.get(i)[0]);
                    mapped.put("company_name", csvData.get(i)[1]);
                    mapped.put("number_employees", csvData.get(i)[2]);
                    mapped.put("category", csvData.get(i)[3]);
                    mapped.put("city", csvData.get(i)[4]);
                    mapped.put("state", csvData.get(i)[5]);
                    mapped.put("funded_date", csvData.get(i)[6]);
                    mapped.put("raised_amount", csvData.get(i)[7]);
                    mapped.put("raised_currency", csvData.get(i)[8]);
                    mapped.put("round", csvData.get(i)[9]);
                } else {
                    continue;
                }
            }

            if(options.containsKey("round")) {
                if(csvData.get(i)[9].equals(options.get("round"))) {
                    mapped.put("permalink", csvData.get(i)[0]);
                    mapped.put("company_name", csvData.get(i)[1]);
                    mapped.put("number_employees", csvData.get(i)[2]);
                    mapped.put("category", csvData.get(i)[3]);
                    mapped.put("city", csvData.get(i)[4]);
                    mapped.put("state", csvData.get(i)[5]);
                    mapped.put("funded_date", csvData.get(i)[6]);
                    mapped.put("raised_amount", csvData.get(i)[7]);
                    mapped.put("raised_currency", csvData.get(i)[8]);
                    mapped.put("round", csvData.get(i)[9]);
                } else {
                    continue;
                }
            }

            return mapped;
        }

        throw new NoSuchEntryException();
    }

    public static void main(String[] args) {
        try {
            Map<String, String> options = new HashMap<String, String> ();
            options.put("company_name", "Facebook");
            options.put("round", "a");
            System.out.print("\n");
            System.out.print(FundingRaised.where(options).size());
        } catch(IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}

class NoSuchEntryException extends Exception {}
