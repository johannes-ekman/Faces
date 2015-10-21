import java.util.*;

public class FacesController {
	private ArrayList<Face> trainingFaces;
	private HashMap<String, Integer> trainingFacit;
	private ArrayList<Face> testFaces;

	private Perceptron happy;
	private Perceptron sad;
	private Perceptron mischv;
	private Perceptron mad;
	
	public FacesController(ArrayList<Face> trainingFaces, 
			HashMap<String, Integer> trainingFacit, 
			ArrayList<Face> testFaces) {
		
		this.trainingFaces = trainingFaces;
		this.trainingFacit = trainingFacit;
		this.testFaces = testFaces;


		happy = new Perceptron(1);
		sad = new Perceptron(2);
		mischv = new Perceptron(3);
		mad = new Perceptron(4);
	}

	public void run() {
		train();
		evaluate();
	}

	private void train() {
		double[] activations = new double[4];
		int i = 0;
		do {
			// Start training
			Collections.shuffle(trainingFaces);
			for (Face face : trainingFaces) {
				double[][] dataPoints = face.getDoubleRepresentation();
				int type = trainingFacit.get(face.getId());

				happy.train(dataPoints, type);
				sad.train(dataPoints, type);
				mischv.train(dataPoints, type);
				mad.train(dataPoints, type);

				activations[0] = happy.getLatestActivation();
				activations[1] = sad.getLatestActivation();
				activations[2] = mischv.getLatestActivation();
				activations[3] = mad.getLatestActivation();

			}
			i++;
		} while(!trainingComplete(activations));

		System.out.println("# Training complete after " + i + " iterations.");

	}

	private boolean trainingComplete(double[] activations) {
		Arrays.sort(activations);
		double result = activations[3] - activations[2];
		if (result > 0.7)
			return true;

		return false;
	}

	private void evaluate() {

		for (Face face : testFaces) {
			double[][] dataPoints = face.getDoubleRepresentation();

			double happyErr = happy.evaluate(dataPoints);
			double sadErr = sad.evaluate(dataPoints);
			double mischvErr = mischv.evaluate(dataPoints);
			double madErr = mad.evaluate(dataPoints);

			int result = 1;
			double largestErr = happyErr;
			if (sadErr > largestErr) {
				largestErr = sadErr;
				result = 2;
			}

			if (mischvErr > largestErr) {
				largestErr = mischvErr;
				result = 3;
			}

			if (madErr > largestErr) {
				result = 4;
			}

			System.out.println(face.getId() + " " + result);

		}

	}
}
