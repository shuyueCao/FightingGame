package controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import entity.role.Role;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
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
public class ShopController implements Initializable{

    @FXML
    private Tab w;
    @FXML
    private Tab e;
    @FXML
    private Tab g;

    @FXML
    public Label money;
    @FXML
    public Label info;
    @FXML
    public ChoiceBox roleEquips;
    @FXML
    public ListView weaponList;
    @FXML
    public ListView equipList;
    @FXML
    public ListView gemList;

    private RoleService roleService;
    private ShopService shopService;

    private Role currentRole;
    private String selectWeapon;
    private String selectEquip;
    private String selectGem;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roleService = RoleServiceImpl.getInstance();
        shopService = ShopServiceImpl.getInstance();
        currentRole = roleService.getCurrentRole();

        initial();
    }

    @FXML
    public void handleBack() {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(fxmlLoader.loadPanel("info.fxml"));
        stage.get(0).setScene(scene);
    }

    public void initial() {
        money.setText(String.valueOf(currentRole.getMoney()));

        weaponList.setItems(FXCollections.observableArrayList(shopService.getAllWeapons()));
        equipList.setItems(FXCollections.observableArrayList(shopService.getAllEquips()));
        gemList.setItems(FXCollections.observableArrayList(shopService.getAllGems()));

        List<String> equips = new ArrayList<String>();
        currentRole.getEquipmentList().forEach((e) ->
                equips.add(e.getName())
        );
        roleEquips.setItems(FXCollections.observableArrayList(equips));
    }

    @FXML
    public void handleChooseWeapon() {
        selectWeapon = String.valueOf(weaponList.getSelectionModel().getSelectedItem());
        info.setText(shopService.getWeaponInfo(selectWeapon));
    }

    @FXML
    public void handleChooseEquip() {
        selectEquip = String.valueOf(equipList.getSelectionModel().getSelectedItem());
        info.setText(shopService.getEquipInfo(selectEquip));
    }

    @FXML
    public void handleChooseGem() {
        selectGem = String.valueOf(gemList.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void handleBuy() {
        if (w.isSelected()) {
            if (selectWeapon == null || selectWeapon.equals("")) {
                info.setText("您尚未选择武器");
            } else {
                boolean change = true;
                if (currentRole.getWeapon() != null) {
                    change = !(selectWeapon.equals(currentRole.getWeapon().getName()));
                }
                info.setText(shopService.buyWeapon(currentRole, selectWeapon, change));
            }
        } else if (e.isSelected()) {
            if (selectEquip == null || selectEquip.equals("")) {
                info.setText("您尚未选择装备");
            } else {
                info.setText(shopService.buyEquipment(currentRole, selectEquip));
            }
        } else if (g.isSelected()) {
            if (selectGem == null || selectGem.equals("")) {
                info.setText("您尚未选择宝石");
            } else if (roleEquips.getValue().toString() == null || roleEquips.getValue().toString().equals("")) {
                info.setText("您尚未选择要加成的装备");
            } else {
                info.setText(shopService.buyGem(currentRole, roleEquips.getValue().toString(), selectGem));
            }
        } else {
            if (selectWeapon == null || selectWeapon.equals("") && (selectEquip == null || selectEquip.equals(""))) {
                info.setText("您尚未选择要购买的物品!");
            }
        }

        //更新
        initial();
    }
}
