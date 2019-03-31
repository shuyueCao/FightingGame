package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class fxmlLoader {

	public static AnchorPane loadPanel(String fxml) {

		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(new URL("file:src/main/resources/"+fxml));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		AnchorPane result = null;
		try {
			result = (AnchorPane) loader.load();
		} catch (IOException e) {
			System.out.println(fxml + "加载失败");
			e.printStackTrace();
		}
		return result;
	}

}
