package controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.fxmlLoader;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class ShopController implements Initializable{

    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleBack() {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(fxmlLoader.loadPanel("info.fxml"));
        stage.get(0).setScene(scene);
    }
}
