package entity.equip.decorator;

import entity.equip.Equipment;

/**
 * created by csy on 2019/3/29
 **/
public class BlueGem extends GemDecorator {
    private Equipment equipment;

    public BlueGem(Equipment equipment) {
        this.name = equipment.getName();
        this.equipment = equipment;
        this.defense = 20;
        this.HP = 20;
        this.description = "蓝宝石";
        this.money = 100;
    }

    @Override
    public int calculateDefense() {
        equipment.setDefense(this.defense + equipment.calculateDefense());

        return equipment.getDefense();
    }

    @Override
    public int calculateHP() {
        equipment.setHP(this.HP + equipment.calculateHP());
        return equipment.getHP();
    }

    @Override
    public String getIntroduction() {
        return equipment.getIntroduction() + " + " + this.description;
    }
}
