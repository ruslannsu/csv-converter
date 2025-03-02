import csv_converter.Converter;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] arg = {"src/words.txt", "output2.csv"};
        Converter csv = new Converter(arg);
        csv.run();
    }
}