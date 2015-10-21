/**
 * Class contains methods to help a Face determine how it should
 * be rotated.
 * @author dv13jen, ens11pnn
 */
public class FaceUtilities {
    /**
     * The image is divided into 4 equal sized pieces.
     * The value of the pieces are counted and compared to determine
     * how the image needs to be rotated.
     * @param img a face image.
     * @return integer indicating how the image needs to be rotated.
     */
    public static int determineRotation(int[][] img) {
        // Assume square
        int size = img.length;

        int[] values = new int[4];

        for (int i = 0; i < size/2; i++) {
            for (int j = 0; j < size/2; j++) {
                // TopLeft
                values[0] += img[i][j];
            }
        }

        for (int i = 0; i < size/2; i++) {
            for (int j = size/2; j < size; j++) {
                //TopRight
                values[1] += img[i][j];
            }
        }

        for (int i = size/2; i < size; i++) {
            for (int j = 0; j < size/2; j++) {
                 //BottomLeft
                values[2] += img[i][j];
            }
        }

        for (int i = size/2; i < size; i++) {
            for (int j = size/2; j < size; j++) {
                //BottomRight
                values[3] += img[i][j];
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

    /**
     * Determine which two pieces of the image are largest.
     * @param values the four pieces of the image in an array. Indexes corresponds
     *               to pieces location.
     * @return the index of the top two largest pieces.
     */
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

    /**
     * Rotate image 90 degrees clockwise.
     * @param img face image to rotate.
     * @return new face image after rotation.
     */
    public static int[][] rotateCW90(int[][] img) {
        int size = img.length;
        int[][] rotated = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0 ; j < size; j++) {
                rotated[j][size-1-i] = img[i][j];
            }
        }

        return rotated;
    }
    /**
     * Rotate image 90 degrees counterclockwise.
     * @param img face image to rotate.
     * @return new face image after rotation.
     */
    public static int[][] rotateCCW90(int[][] img) {
        int size = img.length;
        int[][] rotated = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0 ; j < size; j++) {
                rotated[size-1-j][i] = img[i][j];
            }
        }

        return rotated;
    }
}
