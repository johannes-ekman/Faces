import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Class used to parse a text-file containing face id and correct value.
 * @author dv13jen, ens11pnn
 */
public class FacitParser {
    public static HashMap<String, Integer> parse(String fileName) throws Exception {

        FileReader input = new FileReader(fileName);
        BufferedReader bufRead = new BufferedReader(input);
        String line;
        HashMap<String, Integer> facitMap = new HashMap<String, Integer>();

        while ((line = bufRead.readLine()) != null) {  

            if (line.startsWith("#")) {
                // Do nothing
            } else if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
                // Do nothing
            } else {
                String[] words = line.split(" ");
                String key = words[0];
                int value = Integer.parseInt(words[1]);
                facitMap.put(key, value);
            }
        }
        bufRead.close();
        return facitMap;
    }
}
