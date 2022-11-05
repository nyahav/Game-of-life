import java.util.Random;

public class GameOfLifeLogic {
	public final int SIZE;
	private static final int IS_ALIVE= 1;
	private static final int IS_DEAD= 0;
	private int[][] originalMat;
	private int[][] copyMat;

	public GameOfLifeLogic(int size) {
		SIZE=size;
		//Initialize both matrixes 
		originalMat= new int [SIZE][SIZE];
		copyMat= new int [SIZE][SIZE];
		Random rand = new Random();
		int randomValue;
		//creates random values and store them in the matrix
		for(int i=0; i<SIZE ;i++) {
			for (int j=0; j<SIZE ;j++) {
				randomValue = rand.nextInt(2);
				originalMat[i][j]=randomValue;
			}
		}
	}

	public int scanMat(int i, int j) {
		return originalMat[i][j];
	}
	//checks for each cell his status for the next generation matrix,according to the conwoy's gameOfLife rules
	public void nextGenMat() {
		int numOfNeighbors;
		copyLifeMat();
		for(int i=0; i<SIZE ;i++) {
			for (int j=0; j<SIZE ;j++) {
				numOfNeighbors=0;
				numOfNeighbors=calculateAliveNeighbors(i,j);
				if (originalMat[i][j]==IS_ALIVE) {
					if (numOfNeighbors==2 || numOfNeighbors==3 )
						originalMat[i][j]=IS_ALIVE;
					if (numOfNeighbors<2 || numOfNeighbors>3)
						originalMat[i][j]=IS_DEAD;
				}
				else if (originalMat[i][j]==IS_DEAD) {
					if (numOfNeighbors==3)
						originalMat[i][j]=IS_ALIVE;
				}
			}

		}
	}
	public int calculateAliveNeighbors(int i, int j) {
		int numOfNeighbors=0;
		int left=j-1;
		int right=j+1;
		int up=i-1;
		int down=i+1;
		if (left>=0) {//checks the three left neighbors
			numOfNeighbors+=copyMat[i][left];
			if (up>=0) {
				numOfNeighbors+=copyMat[up][left];
			}
			if(down<SIZE) {
				numOfNeighbors+=copyMat[down][left];
			}
		}
		if (right<SIZE) {//checks the three right neighbors
			numOfNeighbors+=copyMat[i][right];
			if (up>=0) {
				numOfNeighbors+=copyMat[up][right];
			}
			if(down<SIZE) {
				numOfNeighbors+=copyMat[down][right];
			}
		}
		if (up>=0) {
			numOfNeighbors+=copyMat[up][j];
		}
		if (down<SIZE) {
			numOfNeighbors+=copyMat[down][j];
		}
		return numOfNeighbors;
	}

	private void copyLifeMat() {
		for(int i=0; i<SIZE ;i++) 
			for (int j=0; j<SIZE ;j++) 
				copyMat[i][j]=originalMat[i][j];
	}
}