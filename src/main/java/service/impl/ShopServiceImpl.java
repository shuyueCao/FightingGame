package service.impl;

import entity.equip.Barde;
import entity.equip.Cloak;
import entity.equip.Equipment;
import entity.equip.decorator.BlueGem;
import entity.equip.decorator.GemDecorator;
import entity.equip.decorator.RedGem;
import entity.role.Role;
import entity.weapon.*;
import service.ShopService;
import service.StartService;


import java.util.ArrayList;
import java.util.List;

/**
 * created by csy on 2019/4/12
 **/
public class ShopServiceImpl implements ShopService {

    private static ShopServiceImpl instance;

    public ShopServiceImpl() {
    }

    public static ShopServiceImpl getInstance() {
        if (instance == null) {
            return new ShopServiceImpl();
        }
        return instance;
    }


    public String buyWeapon(Role role, String weaponName, boolean change) {
        Weapon weapon = null;
        if (weaponName.equals("暗影战斧")) {
            weapon = new Axe();
        } else if (weaponName.equals("穿云弓")) {
            weapon = new Bow();
        } else if (weaponName.equals("匕首")) {
            weapon = new Sword();
        } else if (weaponName.equals("无尽战刃")) {
            weapon = new Warblade();
        }
        int cur_money = role.getMoney();
        if (weapon.getMoney() <= cur_money) {
            role.setMoney(cur_money - weapon.getMoney());
            if (role.getWeapon() == null || change) {//还未有武器or是更换武器
                role.setWeapon(weapon);
                return "购买成功!";
            } else if (role.getWeapon() != null && !change) {
                return "已有武器!";
            }
        }
        return "金钱不够！";
    }

    public String buyEquipment(Role role, String equipName) {
        Equipment equipment = null;
        if (equipName.equals("反伤刺甲")) {
            equipment = new Barde();
        } else if (equipName.equals("红莲斗篷")) {
            equipment = new Cloak();
        }

        if (role.getEquipmentList().size() == 3) {
            return "装备栏已满！";
        }
        int cur_money = role.getMoney();
        if (equipment.getMoney() <= cur_money) {
            role.getEquipmentList().add(equipment);
            role.setMoney(cur_money - equipment.getMoney());
            return "购买成功！";
        } else
            return "金钱不够！";
    }

    public String buyGem(Role role, Equipment equipment,String gemName) {
        GemDecorator decorator = null;
        if (gemName.equals("红宝石")){
            decorator = new RedGem(equipment);
        } else if (gemName.equals("蓝宝石")){
            decorator = new BlueGem(equipment);
        }
        if (decorator.getMoney()<= role.getMoney()){
            int index = role.getEquipmentList().indexOf(equipment);
            role.getEquipmentList().set(index,decorator);
            return "购买成功！";
        }

        return "金钱不够！";
    }

    public List<String> getAllWeapons() {
        List<String> weapons = new ArrayList<String>();
        weapons.add("暗影战斧");
        weapons.add("穿云弓");
        weapons.add("匕首");
        weapons.add("无尽战刃");
        return weapons;
    }

    public List<String> getAllEquips() {
        List<String> equips = new ArrayList<String>();
        equips.add("反伤刺甲");
        equips.add("红莲斗篷");
//        equips.add("红宝石");
//        equips.add("蓝宝石");
        return equips;
    }

    public List<String> getAllGems() {
        List<String> gems = new ArrayList<String>();
        gems.add("红宝石");
        gems.add("蓝宝石");
        return gems;
    }
}
