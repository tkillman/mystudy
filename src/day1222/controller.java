package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class controller implements Initializable {
	@FXML
	Label label;
	static String str;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				
					while(true){
					InputStream is = System.in;
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);

					try {
						str = br.readLine();
						//System.out.println(str);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					Platform.runLater(() -> {
						
						label.setText(str);
						
					});

					
					}
					
			}//run 메소드 종료
		};//runnable 끝
		
		Thread t = new Thread(runnable);
		t.setDaemon(true);
		t.start();

	}

}
