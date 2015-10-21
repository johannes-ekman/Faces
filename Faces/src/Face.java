/**
 * Class used to handle information related to a face.
 * The class can rotate the image if needed and also create
 * a representation of its image with doubles between 0-1 instead
 * of integers between 0-31.
 * @author dv13jen, ens11pnn
 */
public class Face {
	private int[][] img;
	private String id;
        
    public Face(int[][] dataPoints, String id) {
        this.img = dataPoints;
        this.id = id;

        evaluateRotation();
    }

    /**
     * Evaluate the need for rotation, rotate if necessary.
     */
    private void evaluateRotation() {
        int rotation = FaceUtilities.determineRotation(img);
        if (rotation == 90) {
            img = FaceUtilities.rotateCCW90(img);
        } else if (rotation == -90) {
            img = FaceUtilities.rotateCW90(img);
        } else if (rotation == 180) {
            for(int i = 0; i < 2; i++) {
                img = FaceUtilities.rotateCW90(img);
            }
        }
    }

    public String getId() {
        return id;
    }

    /**
     * Use current image to create a new matrix representing the
     * values with doubles between 0-1 instead of integers between 0-31.
     * @return the new matrix representation of the face image.
     */
    public double[][] getDoubleRepresentation() {
        double[][] matrix = new double[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                matrix[i][j] = (float) img[i][j] / 32;
            }
        }
        return matrix;
    }
}
