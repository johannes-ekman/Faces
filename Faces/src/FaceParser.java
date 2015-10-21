import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class used to parse a text-file containing text representations of faces and their id.
 * @author dv13jen, ens11pnn
 */
public class FaceParser {

    /**
     * Parse file and return an arraylist of faces.
     * @param fileName String containing name of file to parse.
     * @return list of created faces after parsing.
     * @throws Exception for problems with the file to parse.
     */
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

                Face face = new Face(readFaceMatrix(bufRead), line);
                faces.add(face);
            }
        }
        
        bufRead.close();
        return faces;
    }

    /**
     * Handle parsing of the text representing the image part of a face.
     * @param br reader
     * @return matrix containing the data representing a face image.
     * @throws Exception for problems with reading the file.
     */
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
