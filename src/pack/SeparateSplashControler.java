package pack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SeparateSplashControler implements Initializable {
	
	@FXML
	private AnchorPane anchorPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new SSplashThread().start();
	}
	
	class SSplashThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {

						Stage stage = new Stage();
						Pane pane = null;
						try {
							pane = FXMLLoader.load(getClass().getResource("Screen.fxml"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						Scene scene = new Scene(pane);
						stage.setScene(scene);
						stage.setTitle("Nawigation Draver with Splash Screen");
						stage.getIcons().add(new Image("img/vixen.png"));
						stage.centerOnScreen();
						stage.initStyle(StageStyle.UNIFIED);
						stage.show();
						
						anchorPane.getScene().getWindow().hide();
					}
				});
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}