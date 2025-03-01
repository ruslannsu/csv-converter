import parser.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Parser pr = new Parser("src/words.txt");
        pr.printer();

    }
}