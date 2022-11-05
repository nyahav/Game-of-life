import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Q2M12Controller {

	@FXML
	private Canvas canvas;
	private GraphicsContext gc;
	private final static int SIZE=10;
	GameOfLifeLogic game= new GameOfLifeLogic(SIZE);//creates a new GameOfLifeLogic object
	private double cubesHeigth;
	private double cubesWidth;

	public void initialize() {
		gc = canvas.getGraphicsContext2D();
		cubesHeigth=canvas.getHeight()/game.SIZE;
		cubesWidth=canvas.getWidth()/game.SIZE;
		drawMat();
	}

	@FXML
	void btnPressed(ActionEvent event) {
		game.nextGenMat();//calculates the matrix for the next generation
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());//cleans the old matrix
		drawMat();//draws the new matrix
	}


	public void drawMat() {
		for(int i=0; i<game.SIZE ;i++) {
			for (int j=0; j<game.SIZE ;j++) {
				if(game.scanMat(i,j)==0)
					//dead cells are drawn white
					gc.strokeRect(j* cubesWidth, i*cubesHeigth,  cubesWidth, cubesHeigth);
				else 
					//live cells are drawn black
					gc.fillRect(j* cubesWidth, i*cubesHeigth,  cubesWidth, cubesHeigth);
			}
		}
	}
}