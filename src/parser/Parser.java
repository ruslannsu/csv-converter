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
                        if (line.charAt(i - 1) == '?' || line.charAt(i - 1) == '!' || line.charAt(i - 1) == ',' || line.charAt(i - 1) == '.') {
                            String fixed_word = Character.toUpperCase(line.substring(last_index, i - 1).charAt(0)) + line.substring(last_index + 1, i - 1);
                           //words_.add(line.substring(last_index, i - 1));
                            words_.add(fixed_word);
                            last_index = i + 1;
                            continue;
                        }
                        String fixed_word = Character.toUpperCase(line.substring(last_index, i).charAt(0)) + line.substring(last_index + 1, i);
                       // words_.add(line.substring(last_index, i));
                        words_.add(fixed_word);
                        last_index = i + 1;
                    }
                    if (i == line.length() - 1) {
                        if (line.charAt(i) == '?' || line.charAt(i) == '!' || line.charAt(i) == ',' || line.charAt(i) == '.') {
                            //words_.add(line.substring(last_index, i));
                            String fixed_word = Character.toUpperCase(line.substring(last_index, i).charAt(0)) + line.substring(last_index + 1, i);
                            words_.add(fixed_word);
                            break;
                        }
                        //words_.add(line.substring(last_index, i + 1));
                        String fixed_word = Character.toUpperCase(line.substring(last_index, i + 1).charAt(0)) + line.substring(last_index + 1, i + 1);
                        words_.add(fixed_word);
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
    public ArrayList<String> getWords() {
        return words_;
    }
}
