
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FaceParser {
	public static ArrayList<Face> parse(String fileName) throws Exception {
            
            FileReader input = new FileReader(fileName);
            BufferedReader bufRead = new BufferedReader(input);
            String line = null;

            while ((line = bufRead.readLine()) != null) {    

            }
		return new ArrayList<Face>();
	}
}
