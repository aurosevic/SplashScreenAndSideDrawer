package pack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class ScreenControler implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		VBox vbox = null;
		try {
			vbox = FXMLLoader.load(getClass().getResource("NavigationDrawer.fxml"));
			drawer.setSidePane(vbox);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for(Node node: vbox.getChildren()) {
			if (node.getAccessibleText() != null) {
				node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
					switch (node.getAccessibleText()) {
						case "Material_One" :
							//anchorPane.setStyle("-fx-background-color: yellow");
							anchorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#efef21"), CornerRadii.EMPTY, Insets.EMPTY)));
							break;
						case "Material_Two" :
							anchorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#ef2b2b"), CornerRadii.EMPTY, Insets.EMPTY)));
							break;
						case "Material_Three" :
							anchorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#3fe212"), CornerRadii.EMPTY, Insets.EMPTY)));
							break;
						case "Material_Four" :
							anchorPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#11dbca"), CornerRadii.EMPTY, Insets.EMPTY)));
							break;
						case "Material_Five" :
							System.exit(0);
					}
				});
			}
		}
		
		HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(hamburger);
		transition.setRate(-1);
		hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			transition.setRate(transition.getRate() * -1);
			transition.play();
			
			if (drawer.isShown()) {
				drawer.close();
			} else {
				drawer.open();
			}
		});
	}
}