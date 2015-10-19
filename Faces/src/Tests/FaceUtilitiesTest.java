package Tests;

import junit.framework.TestCase;
import org.junit.Test;
import System.FaceUtilities;

public class FaceUtilitiesTest extends TestCase {

    @Test
    public void testRotateCW90() throws Exception {
        System.out.println("Running RotateCW90");
        int[][] src = new int[4][4];
        for(int i = 0 ; i< 4; i++) {
            for(int j = 0 ; j < 4 ; j++) {
                if(i == 0) src[i][j] = 1;
                else src[i][j] = 0;
            }
        }

        for(int i = 0 ; i< 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(src[i][j] + " ");
            }
        }

        src = FaceUtilities.rotateCW90(src);
        for(int i = 0 ; i< 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(src[i][j]+" ");
            }
        }
        System.out.println();
    }
    @Test
    public void testRotateCCW90() throws Exception {
        System.out.println("Running RotateCCW90");
        int[][] src = new int[4][4];
        for(int i = 0 ; i< 4; i++) {
            for(int j = 0 ; j < 4 ; j++) {
                if(i == 0) src[i][j] = 1;
                else src[i][j] = 0;
            }
        }

        for(int i = 0 ; i< 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(src[i][j] + " ");
            }
        }

        src = FaceUtilities.rotateCCW90(src);
        for(int i = 0 ; i< 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(src[i][j]+" ");
            }
        }
        System.out.println();
    }
    @Test
    public void testTwoLargestIndexes() {
        int[] arr = {1, 0, 2, 3};
        int[] res = FaceUtilities.twoLargestIndexes(arr);
        System.out.println("TopTwo is: "+ res[0]+" " + res[1]);
    }
    @Test
    public void testDetermineRotation() {
        System.out.println("Testing determine rotation, input matrix:");
        int[][] matrix = new int[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 1;
        matrix[1][1] = 2;

        for(int i = 0 ; i< 2; i++) {
            System.out.println();
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println();

        int res = FaceUtilities.determineRotation(matrix);

        System.out.println("Result is: "+res);

    }
}