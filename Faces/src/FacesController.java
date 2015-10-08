
import java.util.ArrayList;
import java.util.HashMap;

public class FacesController {
	private ArrayList<Face> trainingFaces;
	private HashMap<String, Integer> trainingFacit;
	private ArrayList<Face> testFaces;
	
	public FacesController(ArrayList<Face> trainingFaces, 
			HashMap<String, Integer> trainingFacit, 
			ArrayList<Face> testFaces) {
		
		this.trainingFaces = trainingFaces;
		this.trainingFacit = trainingFacit;
		this.testFaces = testFaces;
	}

}
