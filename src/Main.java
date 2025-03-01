import csv_converter.Converter;
import parser.*;
public class Main {
    public static void main(String[] args) throws Exception {
        String[] arg = {"src/words.txt"};
        Converter csv = new Converter(arg);
        csv.print_table();

    }
}