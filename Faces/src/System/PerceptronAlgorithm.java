package System;

/**
 * Created by dv13jen on 2015-10-08.
 */
public class PerceptronAlgorithm {
    private static final double LEARNING_RATE = 1.0;
    private int faceType;
    private int[][] weights;

    public PerceptronAlgorithm(int faceType) {

        this.faceType = faceType;
        weights = new int[20][20];

        for(int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 20; j++) {
                weights[i][j] = (int) (Math.random() * 32);
            }
        }

    }

    public int[][] runAlgorithm(int[][] matrix) {


        return matrix;
    }
    public int[][] getWeights() {
        return weights;
    }

}
