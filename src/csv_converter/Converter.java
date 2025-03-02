package csv_converter;

import parser.Parser;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Converter {
    private Parser input_;
    private TreeMap<String, Integer> map_;
    private String output_path_;
    public Converter(String[] args) throws Exception {
        input_ = new Parser(args[0]);
        output_path_ = args[1];
        map_ = new TreeMap<>();
        for (int i = 0; i != input_.getWords().size(); i++) {
            if (map_.get(input_.getWords().get(i)) == null) {
                map_.put(input_.getWords().get(i), 1);
            }
            else {
                int value = map_.get(input_.getWords().get(i)) + 1;
                map_.put(input_.getWords().get(i), value);
            }
        }
    }
    public TreeMap<String, Integer> sortMap(TreeMap<String, Integer> map) {
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String k1, String k2) {
                int comp = map.get(k1).compareTo(map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };
        TreeMap<String, Integer> sorted_map = new TreeMap<>(comparator);
        sorted_map.putAll(map_);
        return sorted_map;
    }
    public void run() throws IOException {
        FileWriter fw  = new FileWriter(output_path_);
        TreeMap<String, Integer> sorted_map = sortMap(map_);
        for(Map.Entry<String,Integer> entry : sorted_map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            double proc =  (double) (((double)(value) / (input_.getWords().size())) * 100);
            String line = key + ',' + value + ',' + proc + '%';
            fw.write(line);
            fw.write("\n");
        }
        fw.flush();

    }
}
