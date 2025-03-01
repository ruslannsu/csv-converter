package csv_converter;

import parser.Parser;

import java.util.Hashtable;

public class Converter {
    private Parser input_;
    private Hashtable<String, Integer> table_;
    public Converter(String[] args) throws Exception {
        input_ = new Parser(args[0]);
        table_ = new Hashtable<>();
        for (int i = 0; i != input_.getWords().size(); i++) {
            if (table_.get(input_.getWords().get(i)) == null) {
                table_.put(input_.getWords().get(i), 1);
            }
            else {
                int value = table_.get(input_.getWords().get(i)) + 1;
                table_.put(input_.getWords().get(i), value);
            }
        }
    }
    public void print_table() {
        for (int i = 0; i != input_.getWords().size(); ++i) {
            System.out.println((table_.get(input_.getWords().get(i))));
            System.out.println((input_.getWords().get(i)));
        }
    }
}
