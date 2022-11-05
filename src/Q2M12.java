import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Q2M12 extends Application{
	public void start(Stage stage) throws Exception{
		Parent root = (Parent)

				FXMLLoader.load(getClass().getResource("Q2M12.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Game Of Life");//title of the window
		stage.setScene(scene);
		stage.setFullScreen(false);//change this line to true if you like full screen app 

		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
		System.out.println();
	}
}