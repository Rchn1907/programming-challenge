package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private static final String TEST_FILE = "test_weather.csv";    

    @BeforeEach
    void setUp() throws IOException {
        // Creating mock data for testing the Methods of my Program
        try(FileWriter writer = new FileWriter(TEST_FILE)) {
            writer.write("Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP\n");
            writer.write("1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5\n");
            writer.write("2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5\n");
            writer.write("3,77,55,66,39.6,0,350,5,350,9,2.8,59,24,1016.8\n");
            writer.write("4,77,59,68,51.1,0,110,9.1,130,12,8.6,62,40,1021.1\n");
        }
    }

    @Test
    void testFindDayWithSmallestTemperatureSpread() {
        int result = WeatherAnalyzer.findDayWithSmallestTempSpread(TEST_FILE);
        assertEquals(2, result, "The day with the smallest temperature should be correct!");
    }

    @Test
    void testEmptyFile() throws IOException {
        Files.write(Path.of(TEST_FILE), "".getBytes());
        int result = WeatherAnalyzer.findDayWithSmallestTempSpread(TEST_FILE);
        assertEquals(-1, result, "Should return -1 for empty file!");
    }

    @Test
    void testIncorrectFormat() throws IOException{
        try(FileWriter writer = new FileWriter(TEST_FILE)) {
            writer.write("Wrong,Format\n");
        }
        int result = WeatherAnalyzer.findDayWithSmallestTempSpread(TEST_FILE);
        assertEquals(-1, result, "Should return -1 for incorrect file format!");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

}