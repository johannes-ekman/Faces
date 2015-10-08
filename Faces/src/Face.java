
public class Face {
	private int[][] dataPoints;
	private String id;
        
    public Face (int[][] dataPoints, String id) {
        this.dataPoints = dataPoints;
        this.id = id;
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
    public int[][] getDataPoints() {

        return dataPoints;
    }
    public void setDataPoints(int[][] dataPoints) {

        this.dataPoints = dataPoints;
    }

    public void rotateFace(int rotation) {

        int[][] newPoints = new int[20][20];

        //rotate using rotation

        setDataPoints(newPoints);
    }
}
