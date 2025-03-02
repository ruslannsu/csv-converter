import csv_converter.Converter;
import parser.*;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] arg = {"src/words.txt"};
        Converter csv = new Converter(arg);
        csv.run();

    }
}