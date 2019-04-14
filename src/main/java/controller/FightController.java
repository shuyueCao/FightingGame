package controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import entity.monster.Monster;
import entity.role.Role;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import service.FightService;
import service.RoleService;
import service.impl.FightServiceImpl;
import service.impl.RoleServiceImpl;
import utils.fxmlLoader;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class FightController implements Initializable {

    @FXML
    private Label m_name;
    @FXML
    private Label m_attack;
    @FXML
    private Label m_hp;

    @FXML
    private Label r_name;
    @FXML
    private Label r_level;
    @FXML
    private Label r_exp;
    @FXML
    private Label r_money;
    @FXML
    private Label r_attack;
    @FXML
    private Label r_defence;
    @FXML
    private Label r_chp;
    @FXML
    private Label r_hp;
    @FXML
    private Label r_weapon;

    @FXML
    private Button skill2;
    @FXML
    private Button skill3;

    @FXML
    private TextArea info;


    private RoleService roleService;
    private FightService fightService;

    private int currentTimes;
    private Role currentRole;
    private Monster currentMonster;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roleService = RoleServiceImpl.getInstance();
        fightService = FightServiceImpl.getInstance();
        currentTimes = 0;
        currentRole = roleService.getCurrentRole();
        currentRole.setCurrentHP(currentRole.calculateHP());
        currentMonster = fightService.createMonster(currentRole, currentTimes);
        initial();
    }

    public void initial() {
        m_name.setText(currentMonster.getName());
        m_attack.setText(String.valueOf(currentMonster.getAttackValue()));
        m_hp.setText(String.valueOf(currentMonster.getHP()));

        r_name.setText(currentRole.getName());
        r_level.setText(String.valueOf(currentRole.getLevel()));
        r_exp.setText(String.valueOf(currentRole.getExperience()));
        r_money.setText(String.valueOf(currentRole.getMoney()));
        r_attack.setText(String.valueOf(currentRole.calculateDPS()));
        r_defence.setText(String.valueOf(currentRole.calculateDefense()));
        r_chp.setText(String.valueOf(currentRole.getCurrentHP()));
        r_hp.setText(String.valueOf(currentRole.calculateHP()));
        if (currentRole.getWeapon() != null) {
            r_weapon.setText(currentRole.getWeapon().getName());
        }

        if (currentRole.getSkill2() != null) {
            skill2.setDisable(false);
        }
        if (currentRole.getSkill3() != null) {
            skill3.setDisable(false);
        }
    }

    @FXML
    public void handleSimple() {
        if(currentMonster.getHP() > 0) {
            String res = fightService.attack(currentRole, currentMonster);

            System.out.println(currentMonster.getHP());
            info.setText(info.getText() + "\n" + res);
            initial();
        }
    }

    @FXML
    public void handleSkill1() {
        if(currentMonster.getHP() > 0) {
            String res = fightService.attackBySkill1(currentRole, currentMonster);
            info.setText(info.getText() + "\n" + res);
            initial();
        }

    }

    @FXML
    public void handleSkill2() {
        if(currentMonster.getHP() > 0) {
            String res = fightService.attackBySkill2(currentRole, currentMonster);
            info.setText(info.getText() + "\n" + res);
            initial();
        }

    }

    @FXML
    public void handleSkill3() {
        if(currentMonster.getHP() > 0) {
            String res = fightService.attackBySkill3(currentRole, currentMonster);
            info.setText(info.getText() + "\n" + res);
            initial();
        }

    }

    @FXML
    public void handleCombination() {
        if(currentMonster.getHP() > 0) {
            String res = fightService.attackByCombination(currentRole, currentMonster);
            info.setText(info.getText() + "\n" + res);
            initial();
        }

    }

    @FXML
    public void handleContinue() {
        if (currentMonster.getHP() <= 0) {
            info.setText("");
            currentTimes += 1;
            currentTimes %= 3;
            currentMonster = fightService.createMonster(currentRole, currentTimes);
            initial();
        } else {
            info.setText("请打败当前怪物再进行下一局游戏!");
        }

    }

    @FXML
    public void handleQuit() {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(fxmlLoader.loadPanel("info.fxml"));
        stage.get(0).setScene(scene);
    }
}
