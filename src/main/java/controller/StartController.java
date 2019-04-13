package controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import service.RoleService;
import service.impl.RoleServiceImpl;
import utils.fxmlLoader;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class StartController implements Initializable {

    @FXML
    public ChoiceBox roles;

    private RoleService roleService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roleService = RoleServiceImpl.getInstance();
        roles.setItems(FXCollections.observableArrayList(roleService.getAllRoles()));
    }

    @FXML
    public void handleStart() {
        roleService.createRole(roles.getValue().toString());
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(fxmlLoader.loadPanel("info.fxml"));
        stage.get(0).setScene(scene);
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}
