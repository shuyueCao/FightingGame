package controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import entity.Role;
import factory.RoleFactory;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import utils.fxmlLoader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class StartController implements Initializable {

    @FXML
    public ChoiceBox roles;

    public void initialize(URL location, ResourceBundle resources) {
        List<String> data = new ArrayList<String>(RoleFactory.getAllRoles());
        roles.setItems(FXCollections.observableArrayList(data));
    }

    @FXML
    public void handleStart() {
        Role role = RoleFactory.getRole(roles.getValue().toString());
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(fxmlLoader.loadPanel("info.fxml"));
        stage.get(0).setScene(scene);
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}
