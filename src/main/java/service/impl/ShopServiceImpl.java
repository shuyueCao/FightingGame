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



import java.util.ArrayList;
import java.util.List;

/**
 * created by csy on 2019/4/12
 **/
public class ShopServiceImpl implements ShopService {

    private static ShopServiceImpl instance;
    private static final int ENHANCE_PRICE = 200;
    private static final int ENHANCE_POWER = 5;

    private ShopServiceImpl() {
    }

    public static ShopServiceImpl getInstance() {
        if (instance == null) {
            return new ShopServiceImpl();
        }
        return instance;
    }

    @Override
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
            //还未有武器or是更换武器
            if (role.getWeapon() == null || change) {
                role.setWeapon(weapon);
                return "购买成功!";
            } else if (role.getWeapon() != null && !change) {
                return "已有武器!";
            }
        }
        return "金钱不够！";
    }

    @Override
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

    @Override
    public String buyGem(Role role, String equipName,String gemName) {
        Equipment equipment = null;
        if (equipName.equals("反伤刺甲")) {
            equipment = new Barde();
        } else if (equipName.equals("红莲斗篷")) {
            equipment = new Cloak();
        }

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

    @Override
    public String enhanceWeapon(Role role) {
        if (role.getMoney() >= ENHANCE_PRICE){
            role.getWeapon().enhancePower(ENHANCE_POWER);
            role.setMoney(role.getMoney() - ENHANCE_PRICE);
            return "武器已强化一级";
        }
        return "金钱不够";
    }

    @Override
    public List<String> getAllWeapons() {
        List<String> weapons = new ArrayList<String>();
        weapons.add("暗影战斧");
        weapons.add("穿云弓");
        weapons.add("匕首");
        weapons.add("无尽战刃");
        return weapons;
    }

    @Override
    public List<String> getAllEquips() {
        List<String> equips = new ArrayList<String>();
        equips.add("反伤刺甲");
        equips.add("红莲斗篷");
        return equips;
    }

    @Override
    public List<String> getAllGems() {
        List<String> gems = new ArrayList<String>();
        gems.add("红宝石");
        gems.add("蓝宝石");
        return gems;
    }

    @Override
    public String getWeaponInfo(String name) {
        if (name.equals("暗影战斧")) {
            return new Axe().getIntroduction();
        } else if (name.equals("穿云弓")) {
            return new Bow().getIntroduction();
        } else if (name.equals("匕首")) {
            return new Sword().getIntroduction();
        } else if (name.equals("无尽战刃")) {
            return new Warblade().getIntroduction();
        } else {
            return "";
        }
    }

    @Override
    public String getEquipInfo(String name) {
        if (name.equals("反伤刺甲")) {
            return new Barde().getIntroduction();
        } else if (name.equals("红莲斗篷")) {
            return new Cloak().getIntroduction();
        } else {
            return "";
        }
    }
}
