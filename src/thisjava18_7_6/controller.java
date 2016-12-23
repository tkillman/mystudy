package thisjava18_7_6;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class controller implements Initializable {
	@FXML
	Label label;

	static int c=0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					c++;
					Platform.runLater(()->{
						label.setText(Integer.toString(c));
					});
					
					if (c > 10) {
						break;
					}

				}

			}
		};

		Thread t = new Thread(runnable);
		t.start();
	}

}
