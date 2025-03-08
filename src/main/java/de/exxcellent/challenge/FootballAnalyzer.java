package de.exxcellent.challenge;

import java.util.List;

public class FootballAnalyzer implements DataAnalyzer {
    @Override
    public String analyze(String filePath) {
        List<String[]> data = CSVFileReader.readCsv(filePath);
        
        // initial value which should return if not modified (Wrong format/ Empty file)
        String bestTeam = "No Team";
        int minGoalDiff = Integer.MAX_VALUE;

        for (String[] row : data) {
            String team = row[0];
            int goals = Integer.parseInt(row[5]);
            int goalsAllowed =  Integer.parseInt(row[6]);
            int goalDifference = Math.abs(goals - goalsAllowed);

            if(goalDifference < minGoalDiff) {
                minGoalDiff = goalDifference;
                bestTeam = team;
            }
        }

        return bestTeam;
    }
}
