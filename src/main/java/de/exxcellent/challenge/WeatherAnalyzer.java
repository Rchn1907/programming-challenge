package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;

public class WeatherAnalyzer {

    public static void main(String[] args) {
        String filePath = "src/main/resources/de/exxcellent/challenge/weather.csv";
        int dayWithSmallestSpread = findDayWithSmallestTempSpread(filePath);
        System.out.printf("Day with smallest temperature spread: %d%n", dayWithSmallestSpread);
    }
    
    public static int findDayWithSmallestTempSpread(String filePath) {
        // initial value which should return if not modified (Wrong format/ Empty file)
        int minSpreadDay = -1;
        double minSpread = Double.MAX_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Skip the header part of csv File

            while ((line = br.readLine()) != null) {
                String[] columns = line.trim().split(",");
                int day = Integer.parseInt(columns[0]);
                double maxTemp = Double.parseDouble(columns[1]);
                double minTemp = Double.parseDouble(columns[2]);
                double spread = maxTemp - minTemp;

                if(spread < minSpread) {
                    minSpread = spread;
                    minSpreadDay = day;
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return minSpreadDay;
    }
}
