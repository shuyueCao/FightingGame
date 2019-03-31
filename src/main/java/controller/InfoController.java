package controller;

import factory.RoleFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class InfoController implements Initializable {

    @FXML
    public Label name;


    public void initialize(URL location, ResourceBundle resources) {
        name.setText(RoleFactory.getRole("").getName());

    }
}
