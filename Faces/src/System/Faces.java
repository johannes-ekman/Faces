package System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Faces {

    public static void main(String[] args)  {
        if (args.length != 3)  {
            System.err.println("Usage: java -jar "
                    + "training-file.txt training-facit.txt test-file.txt");
	}
        try {
            System.out.println("# Parsing training...");
            ArrayList<Face> faces =  FaceParser.parse(args[0]);
            System.out.println("# Training finished parsing.");
            System.out.println("# Parsing facit...");
            HashMap<String, Integer> facitMap = FacitParser.parse(args[1]);
            System.out.println("# Facit parsing complete.");
            System.out.println("# Parsing test...");
            ArrayList<Face> testFaces =  FaceParser.parse(args[2]);
            System.out.println("# Test parsing complete.");

            new FacesController(faces, facitMap, testFaces).run();
            
        } catch (Exception ex) {
            Logger.getLogger(Faces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
