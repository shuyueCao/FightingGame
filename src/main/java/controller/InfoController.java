package controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import entity.role.Role;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
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
public class InfoController implements Initializable {

    @FXML
    public Label name;

    @FXML
    public TableView weapons;
    @FXML
    public TableView equips;
    @FXML
    public TableView skills;

    private RoleService roleService;


    public void initialize(URL location, ResourceBundle resources) {
        roleService = RoleServiceImpl.getInstance();
        Role currentRole = roleService.getCurrentRole();
        name.setText(currentRole.getName());
    }

    @FXML
    public void handleStartFight() {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(fxmlLoader.loadPanel("fight.fxml"));
        stage.get(0).setScene(scene);
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }

    @FXML
    public void handleShop() {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(fxmlLoader.loadPanel("shop.fxml"));
        stage.get(0).setScene(scene);
    }
}
