package thisjava18_7_6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class appMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = fxml.load();
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	
	}
	public static void main(String[] args) {
		launch(args);
		
	}
	
}
