package de.exxcellent.challenge;

import java.util.List;

public class WeatherAnalyzer implements DataAnalyzer{

    @Override
    public String analyze(String filePath) {
        // Extract data from CSV File with our CSVFileReader Class
        List<String[]> data = CSVFileReader.readCsv(filePath);
        
        // initial value which should return if not modified (Wrong format/ Empty file)
        int minSpreadDay = -1;
        double minSpread = Double.MAX_VALUE;

        for (String[] row : data) {
            int day = Integer.parseInt(row[0]);
            double maxTemp = Double.parseDouble(row[1]);
            double minTemp = Double.parseDouble(row[2]);
            double spread = maxTemp - minTemp;

            if(spread < minSpread) {
                minSpread = spread;
                minSpreadDay = day;
            }
        }

        return String.valueOf(minSpreadDay);
    }
}
