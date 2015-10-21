/**
 * Class implements the Perceptron algorithm. A Perceptron learns
 * gradually by modifying its weights.
 * @author dv13jen, ens11pnn
 */
public class Perceptron {
    private static final double LEARNING_RATE = 0.9;
    private int faceType;
    private double[][] weights;
    private double latestActivation;

    /**
     * Initiation of the Perceptron. It has a type and random
     * initial weights.
     * @param faceType integer value of type of Perceptron
     */
    public Perceptron(int faceType) {

        this.faceType = faceType;
        weights = new double[20][20];
        latestActivation = 0.0;

        // Start off with random weights
        for(int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 20; j++) {
                weights[i][j] = Math.random();
            }
        }

    }

    /**
     * One training session using one image and its corresponding
     * correct faceType.
     * @param img face image
     * @param faceType the face image correct integer value
     */
    public void train(double[][] img, int faceType) {
        double outputError;
        int desiredOutput = 0;

        if (faceType == this.faceType) {
            desiredOutput = 1;
        }

        // Get current difference between img and weights.
        double activation = activation(img);

        // Get error using difference and expected result.
        outputError = desiredOutput - activation;

        // Update current weights
        for(int i = 0; i < img.length ; i++) {
            for(int j = 0; j < img.length ; j++) {
                weights[i][j] += (LEARNING_RATE * outputError * img[i][j]);
            }
        }
    }

    /**
     * Method provides a value representing the current difference
     * between weights and the argument face image. The value is a
     * double between 0-1 where 0 is a huge difference and 1 is no
     * difference at all.
     * @param img face image to compare with weights.
     * @return difference between weights and img as double
     */
    private double activation(double[][] img) {
        double act = 0.0;
        for(int i = 0; i < img.length; i++) {
            for(int j = 0; j < img.length; j++) {

                act += weights[i][j] * img[i][j];
            }
        }
        latestActivation = act/400;
        return latestActivation;
    }

    public double getLatestActivation() {
        return latestActivation;
    }

    public double evaluate(double[][] img) {
        return activation(img);
    }
}
