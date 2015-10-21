import java.util.*;

/**
 * Class handles training and evaluation using training faces,
 * training facit and test faces.
 * @author dv13jen, ens11pnn
 */
public class FacesController {
	private ArrayList<Face> trainingFaces;
	private HashMap<String, Integer> trainingFacit;
	private ArrayList<Face> testFaces;
	private static final double TRAINING_GOAL = 0.7;

	private Perceptron happy;
	private Perceptron sad;
	private Perceptron mischv;
	private Perceptron mad;

	/**
	 * Controller is created along with four perceptrons.
	 * @param trainingFaces list of faces created from parsed file, used for training.
	 * @param trainingFacit map of facit of the contents of trainingFaces.
	 * @param testFaces list of faces create from parsed file, used for evaluation.
	 */
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

	/**
	 * Run training until TRAINING_GOAL is achieved. Training is run
	 * on all perceptrons using trainingFaces and trainingFacit.
	 */
	private void train() {
		double[] activations = new double[4];
		int i = 0;
		do {
			// Start training
			Collections.shuffle(trainingFaces);
			for (Face face : trainingFaces) {
				double[][] img = face.getDoubleRepresentation();
				int faceType = trainingFacit.get(face.getId());

				happy.train(img, faceType);
				sad.train(img, faceType);
				mischv.train(img, faceType);
				mad.train(img, faceType);

				// Activation is needed to see when training is completed.
				activations[0] = happy.getLatestActivation();
				activations[1] = sad.getLatestActivation();
				activations[2] = mischv.getLatestActivation();
				activations[3] = mad.getLatestActivation();
			}
			i++;
		} while(!trainingComplete(activations));

		System.out.println("# Training complete after " + i + " iterations.");
	}

	/**
	 * All four perceptrons latest activation is used to check if training
	 * should be considered finished. A big difference between the largest
	 * and second largest activation (TRAINING_GOAL) means given an image
	 * there is one perceptron that is clearly more "correct".
	 * @param activations of all perceptrons
	 * @return boolean if training can be considered complete.
	 */
	private boolean trainingComplete(double[] activations) {
		Arrays.sort(activations);
		double result = activations[3] - activations[2];
		if (result > TRAINING_GOAL)
			return true;

		return false;
	}

	/**
	 * Run through testFaces, check result of all perceptrons. Largest
	 * result is most likely to be correct.
	 */
	private void evaluate() {
		for (Face face : testFaces) {
			double[][] img = face.getDoubleRepresentation();

			double happyRes = happy.evaluate(img);
			double sadRes = sad.evaluate(img);
			double mischvRes = mischv.evaluate(img);
			double madRes = mad.evaluate(img);

			int result = 1;
			double largestRes = happyRes;

			if (sadRes > largestRes) {
				largestRes = sadRes;
				result = 2;
			}

			if (mischvRes > largestRes) {
				largestRes = mischvRes;
				result = 3;
			}

			if (madRes > largestRes) {
				result = 4;
			}

			System.out.println(face.getId() + " " + result);
		}
	}
}
