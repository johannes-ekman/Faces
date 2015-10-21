import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FaceParser {
    public static ArrayList<Face> parse(String fileName) throws Exception {

        FileReader input = new FileReader(fileName);
        BufferedReader bufRead = new BufferedReader(input);
        String line;
        ArrayList<Face> faces = new ArrayList<Face>();

        
        while ((line = bufRead.readLine()) != null) {  
            
            if (line.startsWith("#")) {
                // Do nothing
            } else if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
                // Do nothing
            } else {
                String id = line;

                Face face = new Face(readFaceMatrix(bufRead), id);
                faces.add(face);
            }
        }
        
        bufRead.close();
        return faces;
    }
    
    private static int[][] readFaceMatrix(BufferedReader br) throws Exception {
        int[][] matrix = new int[20][20];
        for (int i = 0; i < 20; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            for (int j = 0; j < 20; j++) {
                matrix[i][j] = Integer.parseInt(words[j]);
            }
           
        }
        return matrix;
    }
}
