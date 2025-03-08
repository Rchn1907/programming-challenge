package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private WeatherAnalyzer weatherAnalyzer;

    @BeforeEach
    void setUp() throws IOException {
        List<String> csvData = Files.readAllLines(Paths.get("src/main/resources/de/exxcellent/challenge/weather.csv"));

        weatherAnalyzer = new WeatherAnalyzer(csvData);
    }

    @Test
    void runWeather() {
        int result = weatherAnalyzer.findDayWithSmallestTempSpread();
        assertEquals(10, result, "The day with the smallest temperature should be correct!");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

}