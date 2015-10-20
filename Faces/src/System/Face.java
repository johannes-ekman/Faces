package System;

public class Face {
	private int[][] dataPoints;
	private String id;
        
    public Face(int[][] dataPoints, String id) {
        this.dataPoints = dataPoints;
        this.id = id;
        evaluateRotation();
    }

    private void evaluateRotation() {
        int rotation = FaceUtilities.determineRotation(dataPoints);
        if (rotation == 90) {
            dataPoints = FaceUtilities.rotateCCW90(dataPoints);
        } else if (rotation == -90) {
            dataPoints = FaceUtilities.rotateCW90(dataPoints);
        } else if (rotation == 180) {
            for(int i = 0; i < 2; i++) {
                dataPoints = FaceUtilities.rotateCW90(dataPoints);
            }
        }
    }

    public void printFace() {
        System.out.println(id);
        for(int i = 0; i < 20; i++) {
            if(i !=0) System.out.println();
            for(int j = 0; j < 20; j++) {
                System.out.print(dataPoints[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println();

    }

    public String getId() {
        return id;
    }

    public double[][] getDoubleRepresentation() {
        double[][] matrix = new double[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                matrix[i][j] = (float) dataPoints[i][j] / 32;
            }
        }

        return matrix;
    }
}
