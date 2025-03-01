package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Parser {
    private ArrayList<String> words_;
    public Parser(String file_path) throws Exception {
        words_ = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file_path));
        String line = reader.readLine();
        while (line != null) {
            int last_index = 0;
            for (int i = 0; i != line.length(); ++i) {
                try {
                    if (line.charAt(i) == ' ') {
                        if (line.charAt(i - 1) == '?' || line.charAt(i - 1) == '!' || line.charAt(i - 1) == ',') {
                            words_.add(line.substring(last_index, i - 1));
                            last_index = i + 1;
                            continue;
                        }
                        words_.add(line.substring(last_index, i));
                        last_index = i + 1;
                    }
                    if (i == line.length() - 1) {
                        words_.add(line.substring(last_index, i + 1));
                        break;
                    }
                }
                catch(Exception ex)
                    {
                        throw new RuntimeException("Bad input");
                    }
                }
            line = reader.readLine();
        }
        reader.close();
    }
    public void printer(){
        for (int i = 0; i != words_.size(); ++i) {
            System.out.println(words_.get(i));
        }
    }

    public ArrayList<String> getWords() {
        return words_;
    }
}
