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
}