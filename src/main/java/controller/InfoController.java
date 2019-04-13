package controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import entity.role.Role;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import service.RoleService;
import service.ShopService;
import service.impl.RoleServiceImpl;
import service.impl.ShopServiceImpl;
import utils.fxmlLoader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class InfoController implements Initializable {

    @FXML
    public Label name;
    @FXML
    public Label level;
    @FXML
    public Label attack;
    @FXML
    public Label defence;
    @FXML
    public Label money;
    @FXML
    public Label experience;
    @FXML
    public Label hp;



    @FXML
    public Label weapon;
    @FXML
    public ListView equipList;
    @FXML
    public ListView skillList;
    @FXML
    public Label info;

    private RoleService roleService;
    private ShopService shopService;
    private Role currentRole;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roleService = RoleServiceImpl.getInstance();
        shopService = ShopServiceImpl.getInstance();
        currentRole = roleService.getCurrentRole();

        initial();
    }

    public void initial() {
        name.setText(currentRole.getName());
        level.setText(currentRole.getLevel()+"级");
        attack.setText(String.valueOf(currentRole.calculateDPS()));
        defence.setText(String.valueOf(currentRole.calculateDefense()));
        money.setText(String.valueOf(currentRole.getMoney()));
        experience.setText(String.valueOf(currentRole.getExperience()));
        hp.setText(String.valueOf(currentRole.calculateHP()));

        weapon.setText(currentRole.getWeapon().getName());
        initialEquips();
        initialSkills();
    }

    public void initialEquips() {
        List<String> equips = new ArrayList<String>();
        currentRole.getEquipmentList().forEach((e) ->
                equips.add(e.getName())
        );
        equipList.setItems(FXCollections.observableArrayList(equips));
    }

    public void initialSkills() {
        List<String> skills = new ArrayList<String>();
        skills.add(currentRole.getSkill1().getIntroduction());
        if(currentRole.getSkill2() != null) {
            skills.add(currentRole.getSkill2().getIntroduction());
        } else {
            skills.add("尚未解锁技能2");
        }
        if(currentRole.getSkill3() != null) {
            skills.add(currentRole.getSkill3().getIntroduction());
        } else {
            skills.add("尚未解锁技能3");
        }
        skillList.setItems(FXCollections.observableArrayList(skills));
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
    public void handleShow() {
        info.setText(currentRole.getWeapon().getBriefDescription());
    }

    @FXML
    public void handleUpdateWeapon() {
        String result = shopService.enhanceWeapon(currentRole);
        info.setText(result);
        initial();
    }

    @FXML
    public void handleShop() {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(fxmlLoader.loadPanel("shop.fxml"));
        stage.get(0).setScene(scene);
    }

    @FXML
    public void handleEquipShow() {
        String name = String.valueOf(equipList.getSelectionModel().getSelectedItem());
        info.setText(shopService.getEquipInfo(name));
    }

}
