package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    @Test
    void runFootball() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main("--football", "football.csv");

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Team with smallest goal spread")); // Check if normal program is running with the right arguments
    }

    @Test
    void runWeather() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main("--weather", "weather.csv");

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Day with smallest temperature spread")); // Check if normal program is running with the right arguments
    }

}