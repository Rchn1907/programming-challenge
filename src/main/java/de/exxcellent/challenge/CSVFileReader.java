package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

// Generic Csv File Reader class for using in multiple classes
public class CSVFileReader {
    public static List<String[]> readCsv(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Skip the header part of csv File

            while ((line = br.readLine()) != null) {
                data.add(line.trim().split(","));
            }
        } catch (Exception e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return data;
    }
}
