package System;

import java.util.Arrays;

/**
 * Created by dv13jen on 2015-10-08.
 */
public class FaceUtilities {


    public static int determineRotation(int[][] matrix) {
        // Assume square
        int size = matrix.length;

        int[] values = new int[4];

        for (int i = 0; i < size/2; i++) {
            for (int j = 0; j < size/2; j++) {
                // TopLeft
                values[0] += matrix[i][j];
            }
        }

        for (int i = 0; i < size/2; i++) {
            for (int j = size/2; j < size; j++) {
                //TopRight
                values[1] += matrix[i][j];
            }
        }

        for (int i = size/2; i < size; i++) {
            for (int j = 0; j < size/2; j++) {
                 //BottomLeft
                values[2] += matrix[i][j];
            }
        }

        for (int i = size/2; i < size; i++) {
            for (int j = size/2; j < size; j++) {
                //BottomRight
                values[3] += matrix[i][j];
            }
        }

        int[] topTwo = twoLargestIndexes(values);

        if(topTwo[0] == 2  && topTwo[1] != 3){
            // rotate clockwise 90
            return -90;

        }
        if((topTwo[0] == 2 && topTwo[1] == 3) || (topTwo[0] == 3 && topTwo[1] == 2)) {
            // Rotate 180
            return 180;

        }
        if((topTwo[0] == 3 && topTwo[1] == 1) || (topTwo[0] == 3 && topTwo[1] == 0)) {
            // Rotate counterClockwise 90
            return 90;
        }

        return 0;
    }

    public static int[] twoLargestIndexes(int[] values) {

        int[] topTwo = {0,0};

        for(int i = 0; i < values.length; i++) {
            if (values[i] > topTwo[0]) {
                topTwo[1] = topTwo[0];
                topTwo[0] = i;
            } else if (values[i] > topTwo[1]) {
                topTwo[1] = i;
            }
        }

        return topTwo;
    }

    public static int[][] rotateCW90(int[][] matrix) {
        int size = matrix.length;
        int[][] rotated = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0 ; j < size; j++) {
                rotated[j][size-1-i] = matrix[i][j];
            }
        }

        return rotated;
    }
    public static int[][] rotateCCW90(int[][] matrix) {
        int size = matrix.length;
        int[][] rotated = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0 ; j < size; j++) {
                rotated[size-1-j][i] = matrix[i][j];
            }
        }

        return rotated;
    }
}
