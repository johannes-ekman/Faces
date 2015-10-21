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

        int[] topTwoIndex = {0,0};
        int[] topTwoValues = {0,0};

        for(int i = 0; i < values.length; i++) {
            if (values[i] > topTwoValues[0]) {
                topTwoIndex[1] = topTwoIndex[0];
                topTwoValues[1] = topTwoValues[0];
                topTwoIndex[0] = i;
                topTwoValues[0] = values[i];
            } else if (values[i] > topTwoValues[1]) {
                topTwoIndex[1] = i;
                topTwoValues[1] = values[i];
            }
        }

        return topTwoIndex;
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
