import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class that handles startup of the program.
 * @author dv13jen, ens11pnn
 */
public class Faces {

    /**
     * Checks for correct arguments and starts parsing of all argument files.
     * Lastly creates the FacesController that handles training and evaluation.
     * @param args program arguments.
     */
    public static void main(String[] args)  {
        if (args.length != 3)  {
            System.err.println("Usage: java -jar "
                    + "training-file.txt training-facit.txt test-file.txt");
	}
        try {
            System.out.println("# Parsing training...");
            ArrayList<Face> faces =  FaceParser.parse(args[0]);
            System.out.println("# Training finished parsing.");
            System.out.println("# Parsing training facit...");
            HashMap<String, Integer> facitMap = FacitParser.parse(args[1]);
            System.out.println("# Training facit parsing complete.");
            System.out.println("# Parsing test...");
            ArrayList<Face> testFaces =  FaceParser.parse(args[2]);
            System.out.println("# Test parsing complete.");

            new FacesController(faces, facitMap, testFaces).run();
            
        } catch (Exception ex) {
            Logger.getLogger(Faces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
