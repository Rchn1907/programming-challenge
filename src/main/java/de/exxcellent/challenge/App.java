package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        if(args.length < 2) {
            System.out.println("Call Program with 2 commands like: --weather weather.csv");
        }

        String command = args[0];
        String filePath = "src/main/resources/de/exxcellent/challenge/" + args[1];
        DataAnalyzer analyzer;

        if("--weather".equals(command)) {
            analyzer = new WeatherAnalyzer();
        }else if("--football".equals(command)) {
            analyzer = new FootballAnalyzer();
        }else {
            System.out.println("Invalid argument. Use --weather OR --football");
            return;
        }

        String result = analyzer.analyze(filePath);
        System.out.println(result);
    }
}
