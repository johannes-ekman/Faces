
public class Perceptron {
    private static final double LEARNING_RATE = 0.9;
    private int faceType;
    private double[][] weights;
    private double latestActivation;

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

    public void train(double[][] img, int faceType) {
        double outputError;
        int desiredOutput = 0;

        if (faceType == this.faceType) {
            desiredOutput = 1;
        }

        double activation = activation(img);

        outputError = desiredOutput - activation;

        for(int i = 0; i < img.length ; i++) {
            for(int j = 0; j < img.length ; j++) {
                weights[i][j] += (LEARNING_RATE * outputError * img[i][j]);
            }
        }

    }

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
