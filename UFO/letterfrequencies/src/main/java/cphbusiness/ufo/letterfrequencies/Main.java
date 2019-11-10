package cphbusiness.ufo.letterfrequencies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

/**
 * Frequency analysis Inspired by
 * https://en.wikipedia.org/wiki/Frequency_analysis
 *
 * @author kasper
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // START MARK 2 TYPE MESUREMENT
        Timer t = new Timer();
        int count = 200;
        String fileName = "./src/main/resources/FoundationSeries.txt";
        for (int i = 0; i < count; i++) {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            Map<Integer, Integer> freq = new HashMap<>(52);
            tallyChars(br, freq);
            print_tally(freq);
        }
        double time = t.check() * 1e9 / count;
        System.out.printf("%6.1f ns%n", time);
        System.out.println("time ms " + time / 1e6);

    }

    private static void tallyChars(BufferedReader reader, Map<Integer, Integer> freq) throws IOException {
        int b;
        while ((b = reader.read()) != -1) {
            try {
                if ((b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z')) {
                    freq.put(b, freq.get(b) + 1);
                }
            } catch (NullPointerException np) {
                freq.put(b, 1);
            };
        }
//        freq.forEach((k, v) -> System.out.println("" + k + ": " + v));
    }

    private static void print_tally(Map<Integer, Integer> freq) {
        int dist = 'a' - 'A';
        Map<Character, Integer> upperAndlower = new LinkedHashMap();
        for (Character c = 'A'; c <= 'Z'; c++) {
            upperAndlower.put(c, freq.getOrDefault(c, 0) + freq.getOrDefault(c + dist, 0));
        }
        Map<Character, Integer> sorted = upperAndlower
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        for (Character c : sorted.keySet()) {
            System.out.println("" + c + ": " + sorted.get(c));;
        }
    }
}
