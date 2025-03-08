package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FootballTest {
    private static final String TEST_FILE = "src/main/resources/de/exxcellent/challenge/test_football.csv";   
    private FootballAnalyzer analyzer = new FootballAnalyzer();

    @BeforeEach
    void setUp() throws IOException {
        // Creating mock data for testing the Methods of my Program
        try(FileWriter writer = new FileWriter(TEST_FILE)) {
            writer.write("Team,Games,Wins,Losses,Draws,Goals,Goals Allowed,Points\n");
            writer.write("Arsenal,38,26,9,3,79,36,87\n");
            writer.write("Liverpool,38,24,8,6,67,30,80\n");
            writer.write("Manchester United,38,24,5,9,87,45,77\n");
            writer.write("Newcastle,38,21,8,9,74,52,71\n");
        }
    }

    @Test
    void testFindDayWithSmallestTemperatureSpread() {
        String result = analyzer.analyze(TEST_FILE);
        assertEquals("Newcastle", result, "Expected team with smallest goal difference is Newcastle!");
    }

    @Test
    void testEmptyFile() throws IOException {
        Files.write(Path.of(TEST_FILE), "".getBytes());
        String result = analyzer.analyze(TEST_FILE);
        assertEquals("No Team", result, "Should return 'No Team' for empty file!");
    }

    @Test
    void testIncorrectFormat() throws IOException{
        try(FileWriter writer = new FileWriter(TEST_FILE)) {
            writer.write("Wrong,Format\n");
        }
        String result = analyzer.analyze(TEST_FILE);
        assertEquals("No Team", result, "Should return 'No Team' for incorrect file format!");
    }

}