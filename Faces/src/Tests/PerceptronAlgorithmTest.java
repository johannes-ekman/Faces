package Tests;

import junit.framework.TestCase;
import org.junit.Test;
import System.PerceptronAlgorithm;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PerceptronAlgorithmTest extends TestCase {

    @Test
    public void testPerceptronAlgorithm() {
        System.out.println("Running PerceptronAlgorithm constructor");
        PerceptronAlgorithm pA = new PerceptronAlgorithm(1);
        int[][] matrix = new int[20][20];
        matrix = pA.getWeights();

        for(int i = 0 ; i< 20; i++) {
            System.out.println();
            for (int j = 0; j < 20; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println();
    }

}