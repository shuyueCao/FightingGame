package entity.equip.decorator;

import entity.equip.Equipment;
import lombok.Data;

/**
 * created by csy on 2019/3/29
 **/
@Data
public class RedGem extends GemDecorator {

    private Equipment equipment;

    public RedGem(Equipment equipment) {
        this.name = equipment.getName();
        this.equipment = equipment;
        this.defense = 10;
        this.HP = 10;
        this.description = "红宝石";
        this.money = 50;
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
        return equipment.getIntroduction() + "。镶嵌" + this.description;
    }
}
